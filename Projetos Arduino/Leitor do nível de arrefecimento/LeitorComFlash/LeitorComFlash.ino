#include "esp_camera.h"
#include "Arduino.h"
#include "FS.h"
#include "SPIFFS.h"
#include "soc/soc.h"
#include "soc/rtc_cntl_reg.h"
#include "driver/rtc_io.h"

// Definições dos pinos para a placa ESP32-CAM modelo AI_THINKER - conexões entre o ESP32 e o sensor de câmera OV2640
#define PWDN_GPIO_NUM     32  // Power down - controla o estado de energia da câmera
#define RESET_GPIO_NUM    -1  // Reset não utilizado neste modelo (-1 indica que não está conectado)
#define XCLK_GPIO_NUM      0  // Clock externo para a câmera - essencial para o funcionamento do sensor
#define SIOD_GPIO_NUM     26  // Serial I/O Data (SDA) - comunicação I2C para configurar o sensor
#define SIOC_GPIO_NUM     27  // Serial I/O Clock (SCL) - clock da comunicação I2C
#define Y9_GPIO_NUM       35  // Pino de dados Y9 - os pinos Y9-Y2 formam o barramento paralelo de dados da câmera
#define Y8_GPIO_NUM       34  // Pino de dados Y8 (MSB) - bits mais significativos dos pixels capturados
#define Y7_GPIO_NUM       39  // Pino de dados Y7 - parte do barramento de 8 bits da câmera
#define Y6_GPIO_NUM       36  // Pino de dados Y6 - parte do barramento de dados para transferência de imagem
#define Y5_GPIO_NUM       21  // Pino de dados Y5 - parte do barramento paralelo da câmera
#define Y4_GPIO_NUM       19  // Pino de dados Y4 - parte do barramento paralelo da câmera
#define Y3_GPIO_NUM       18  // Pino de dados Y3 - parte do barramento paralelo da câmera
#define Y2_GPIO_NUM        5  // Pino de dados Y2 (LSB) - bits menos significativos dos pixels
#define VSYNC_GPIO_NUM    25  // Sincronização vertical - indica o início de um novo quadro
#define HREF_GPIO_NUM     23  // Referência horizontal - indica linha válida de dados
#define PCLK_GPIO_NUM     22  // Pixel clock - sincroniza a leitura de cada pixel do sensor

// LEDs para feedback visual - flash para iluminar a cena e LED integrado para indicar status
#define FLASH_LED_PIN 4       // LED de flash para iluminar a cena durante a captura
#define BUILT_IN_LED 33       // LED integrado para feedback de status do sistema

// Diretório no sistema de arquivos para armazenar as imagens de referência
#define REFERENCE_FOLDER "/referencias"

void setup() {
  WRITE_PERI_REG(RTC_CNTL_BROWN_OUT_REG, 0); // Desabilita detector de brownout para evitar reset em queda de tensão
  
  // Configurar LEDs como saída para feedback visual
  pinMode(FLASH_LED_PIN, OUTPUT);
  pinMode(BUILT_IN_LED, OUTPUT);
  
  // Sequência de inicialização do LED - indica que o sistema está ligando
  for (int i = 0; i < 5; i++) {
    digitalWrite(BUILT_IN_LED, HIGH);
    delay(200);
    digitalWrite(BUILT_IN_LED, LOW);
    delay(200);
  }
  
  // Inicialização da comunicação serial com tempo de estabilização
  delay(3000);
  Serial.begin(115200);
  delay(1000);
  
  // Enviando mensagens múltiplas para garantir visibilidade no monitor serial
  for (int i = 0; i < 10; i++) {
    Serial.println();
    Serial.println("==================================");
    Serial.println("Iniciando ESP32-CAM...");
    Serial.println("==================================");
    delay(100);
  }
  
  // Inicialização do sistema de arquivos SPIFFS com formatação automática se necessário
  if (!SPIFFS.begin(true)) {
    Serial.println("Erro ao montar SPIFFS");
    // Sinalização visual rápida para indicar erro de inicialização do sistema de arquivos
    for (int i = 0; i < 10; i++) {
      digitalWrite(BUILT_IN_LED, HIGH);
      delay(100);
      digitalWrite(BUILT_IN_LED, LOW);
      delay(100);
    }
    return;
  }
  
  Serial.println("SPIFFS montado com sucesso!");
  
  // Criação do diretório para imagens de referência se não existir
  if (!SPIFFS.exists(REFERENCE_FOLDER)) {
    Serial.println("Criando pasta de referências");
    SPIFFS.mkdir(REFERENCE_FOLDER);
  }
  
  // Inicialização e verificação do módulo da câmera
  if (inicializar_camera()) {
    Serial.println("Câmera inicializada com sucesso!");
  } else {
    Serial.println("ERRO: Falha ao inicializar a câmera!");
    // Sinalização visual diferenciada para erro específico da câmera
    for (int i = 0; i < 3; i++) {
      digitalWrite(BUILT_IN_LED, HIGH);
      delay(500);
      digitalWrite(BUILT_IN_LED, LOW);
      delay(500);
    }
  }
  
  // Mensagem de inicialização completa com instruções para o usuário
  Serial.println();
  Serial.println("**********************************");
  Serial.println("* ESP32-CAM pronto! *");
  Serial.println("* Comandos disponíveis: *");
  Serial.println("* - salvar_referencia *");
  Serial.println("* - capturar *");
  Serial.println("* - listar *");
  Serial.println("* - excluir *");
  Serial.println("**********************************");
  Serial.println();
  
  // Sinalização final de prontidão
  digitalWrite(BUILT_IN_LED, HIGH);
  delay(1000);
  digitalWrite(BUILT_IN_LED, LOW);
}

void loop() {
  // Heartbeat - pisca periodicamente para indicar que o sistema está em execução
  static unsigned long ultimoPiscar = 0;
  if (millis() - ultimoPiscar > 5000) {
    digitalWrite(BUILT_IN_LED, HIGH);
    delay(50);
    digitalWrite(BUILT_IN_LED, LOW);
    ultimoPiscar = millis();

    // Mensagem periódica no console para confirmar funcionamento
    Serial.println("ESP32-CAM aguardando comandos...");
  }

  // Sistema de processamento de comandos via interface serial
  if (Serial.available()) {
    String comando = Serial.readStringUntil('\n');
    comando.trim();

    Serial.println("Comando recebido: " + comando);

    // Interpretação e execução dos comandos disponíveis
    if (comando == "capturar") {
      capturar_e_comparar();
    } else if (comando == "salvar_referencia") {
      salvar_imagem_referencia();
    } else if (comando == "listar") {
      listar_imagens_referencia();
    } else if (comando == "excluir") {
      excluir_imagem_referencia();
    } else {
      Serial.println("Comando desconhecido. Comandos disponíveis:");
      Serial.println("- salvar_referencia");
      Serial.println("- capturar");
      Serial.println("- listar");
      Serial.println("- excluir");
    }
  }

  delay(100); // Pequena pausa para estabilidade do sistema e economia de energia
}

// Configura e inicializa o módulo da câmera com os parâmetros adequados para o hardware
bool inicializar_camera() {
  camera_config_t config;
  config.ledc_channel = LEDC_CHANNEL_0;  // Canal PWM usado para gerar o sinal de clock
  config.ledc_timer = LEDC_TIMER_0;      // Timer usado pelo canal PWM
  // Mapeamento dos pinos de dados (D0 a D7) que transmitem os dados de pixel da câmera para o ESP32
  config.pin_d0 = Y2_GPIO_NUM;  // Bit menos significativo (LSB)
  config.pin_d1 = Y3_GPIO_NUM;
  config.pin_d2 = Y4_GPIO_NUM;
  config.pin_d3 = Y5_GPIO_NUM;
  config.pin_d4 = Y6_GPIO_NUM;
  config.pin_d5 = Y7_GPIO_NUM;
  config.pin_d6 = Y8_GPIO_NUM;
  config.pin_d7 = Y9_GPIO_NUM;  // Bit mais significativo (MSB)
  // Pinos de controle que gerenciam comunicação e sincronização com o sensor
  config.pin_xclk = XCLK_GPIO_NUM;    // Clock externo gerado pelo ESP32 para a câmera
  config.pin_pclk = PCLK_GPIO_NUM;    // Pixel clock recebido da câmera para sincronização
  config.pin_vsync = VSYNC_GPIO_NUM;  // Sinal de sincronização vertical (início de frame)
  config.pin_href = HREF_GPIO_NUM;    // Sinal de habilitação horizontal (linha válida)
  config.pin_sscb_sda = SIOD_GPIO_NUM; // SDA do barramento I2C para configuração do sensor
  config.pin_sscb_scl = SIOC_GPIO_NUM; // SCL do barramento I2C para comunicação com o sensor
  config.pin_pwdn = PWDN_GPIO_NUM;     // Controle de energia da câmera (power down)
  config.pin_reset = RESET_GPIO_NUM;   // Reset da câmera (-1 se não utilizado)
  config.xclk_freq_hz = 20000000;      // Frequência do clock da câmera (20MHz padrão)
  config.pixel_format = PIXFORMAT_JPEG; // Formato de saída: JPEG para compressão eficiente
  
  // Configurações específicas baseadas na disponibilidade de PSRAM (memória externa)
  if (psramFound()) {
    config.frame_size = FRAMESIZE_240X240; // Resolução da imagem quadrada
    config.jpeg_quality = 10;  // Melhor qualidade (menor número = maior qualidade)
    config.fb_count = 2;       // Dois buffers para melhor desempenho com PSRAM
  } else {
    config.frame_size = FRAMESIZE_240X240;
    config.jpeg_quality = 12;  // Qualidade moderada para economizar memória
    config.fb_count = 1;       // Apenas um buffer quando a memória é limitada
  }
  
  // Inicializa o driver da câmera com as configurações definidas
  esp_err_t err = esp_camera_init(&config);
  if (err != ESP_OK) {
    Serial.printf("Falha ao inicializar a câmera. Erro: 0x%x\n", err);
    return false;
  }
  
  return true;
}

// Captura uma imagem e compara com as imagens de referência para determinar o nível de líquido
void capturar_e_comparar() {
  Serial.println("Capturando imagem...");
  
  // Ativa o flash para melhorar a iluminação durante a captura
  digitalWrite(FLASH_LED_PIN, HIGH);
  delay(100); // Pequeno delay para estabilizar a iluminação
  
  // Obtém o frame buffer da câmera com a imagem capturada
  camera_fb_t *fb = esp_camera_fb_get();
  
  // Desativa o flash após a captura
  digitalWrite(FLASH_LED_PIN, LOW);
  
  // Verifica se a captura foi bem-sucedida
  if (!fb) {
    Serial.println("Falha ao capturar imagem");
    return;
  }
  
  Serial.printf("Imagem capturada: %dx%d, %d bytes\n", fb->width, fb->height, fb->len);
  
  // Analisa a imagem comparando com as referências armazenadas
  int melhor_match = comparar_com_referencias(fb);
  
  // Libera a memória do frame buffer após o uso
  esp_camera_fb_return(fb);
  
  // Reporta o resultado da análise
  if (melhor_match >= 0) {
    Serial.printf("Nível de líquido: %d%%\n", melhor_match);
  } else {
    Serial.println("Não foi possível determinar o nível de líquido");
  }
}

// Captura e salva uma nova imagem de referência associada a um nível específico de líquido
void salvar_imagem_referencia() {
  Serial.println("Capturando imagem de referência...");
  
  // Ativa o flash para iluminação consistente
  digitalWrite(FLASH_LED_PIN, HIGH);
  delay(100);
  
  // Captura a imagem
  camera_fb_t *fb = esp_camera_fb_get();
  
  // Desativa o flash
  digitalWrite(FLASH_LED_PIN, LOW);
  
  // Verifica se a captura foi bem-sucedida
  if (!fb) {
    Serial.println("Falha ao capturar imagem");
    return;
  }
  
  // Solicitação ao usuário para informar o nível de líquido correspondente à imagem
  Serial.println("Digite o nível de líquido (0-100%):");
  
  // Sistema de timeout para a entrada do usuário com feedback visual
  unsigned long inicio = millis();
  while (!Serial.available() && millis() - inicio < 30000) { // 30 segundos de timeout
    delay(100);
    // Piscar LED enquanto aguarda entrada (indicador visual de espera)
    if ((millis() - inicio) % 1000 < 500) {
      digitalWrite(BUILT_IN_LED, HIGH);
    } else {
      digitalWrite(BUILT_IN_LED, LOW);
    }
  }
  
  // Cancela a operação se o timeout for atingido
  if (!Serial.available()) {
    Serial.println("Timeout aguardando entrada. Operação cancelada.");
    esp_camera_fb_return(fb);
    digitalWrite(BUILT_IN_LED, LOW);
    return;
  }
  
  digitalWrite(BUILT_IN_LED, LOW);
  
  // Lê e valida o valor de nível informado pelo usuário
  int nivel = Serial.parseInt();
  Serial.println("Valor recebido: " + String(nivel));
  
  if (nivel < 0 || nivel > 100) {
    Serial.println("Nível inválido. Deve estar entre 0 e 100%");
    esp_camera_fb_return(fb);
    return;
  }
  
  // Gera o nome do arquivo baseado no nível informado
  String nome_arquivo = String(REFERENCE_FOLDER) + "/nivel_" + String(nivel) + ".jpg";
  
  // Salva a imagem no sistema de arquivos
  File file = SPIFFS.open(nome_arquivo, FILE_WRITE);
  if (!file) {
    Serial.println("Falha ao abrir o arquivo para escrita");
    esp_camera_fb_return(fb);
    return;
  }
  
  // Escreve os dados da imagem no arquivo
  file.write(fb->buf, fb->len);
  file.close();
  
  Serial.printf("Imagem de referência para nível %d%% salva como %s\n", nivel, nome_arquivo.c_str());
  
  // Libera o buffer da câmera
  esp_camera_fb_return(fb);
  
  // Feedback visual de sucesso
  for (int i = 0; i < 3; i++) {
    digitalWrite(BUILT_IN_LED, HIGH);
    delay(200);
    digitalWrite(BUILT_IN_LED, LOW);
    delay(200);
  }
}

// Lista todas as imagens de referência disponíveis no sistema de arquivos
void listar_imagens_referencia() {
  Serial.println("Imagens de referência disponíveis:");
  
  // Abre o diretório de referências
  File root = SPIFFS.open(REFERENCE_FOLDER);
  if (!root || !root.isDirectory()) {
    Serial.println("Falha ao abrir diretório de referências");
    return;
  }
  
  // Itera sobre os arquivos no diretório
  File file = root.openNextFile();
  int contador = 0;
  
  while (file) {
    if (!file.isDirectory()) {
      String nome_arquivo = file.name();
      Serial.printf("- %s (%d bytes)\n", nome_arquivo.c_str(), file.size());
      contador++;
    }
    file = root.openNextFile();
  }
  
  // Reporta o resultado da listagem
  if (contador == 0) {
    Serial.println("Nenhuma imagem de referência encontrada");
  } else {
    Serial.printf("Total: %d imagens de referência\n", contador);
  }
}

// Remove uma imagem de referência específica do sistema de arquivos
void excluir_imagem_referencia() {
  Serial.println("Excluir imagem de referência");

  // Mostra as imagens disponíveis para facilitar a escolha
  listar_imagens_referencia();

  // Solicita o nível da imagem a ser excluída
  Serial.println("Digite o nível da imagem que deseja excluir (0-100%):");

  // Sistema de timeout para a entrada do usuário com feedback visual
  unsigned long inicio = millis();
  while (!Serial.available() && millis() - inicio < 30000) { // 30 segundos de timeout
    delay(100);
    // Piscar LED enquanto aguarda entrada
    if ((millis() - inicio) % 1000 < 500) {
      digitalWrite(BUILT_IN_LED, HIGH);
    } else {
      digitalWrite(BUILT_IN_LED, LOW);
    }
  }

  // Cancela a operação se o timeout for atingido
  if (!Serial.available()) {
    Serial.println("Timeout aguardando entrada. Operação cancelada.");
    digitalWrite(BUILT_IN_LED, LOW);
    return;
  }

  digitalWrite(BUILT_IN_LED, LOW);

  // Lê e valida o valor de nível informado
  int nivel = Serial.parseInt();
  Serial.println("Valor recebido: " + String(nivel));

  if (nivel < 0 || nivel > 100) {
    Serial.println("Nível inválido. Deve estar entre 0 e 100%");
    return;
  }

  // Gera o nome do arquivo baseado no nível
  String nome_arquivo = String(REFERENCE_FOLDER) + "/nivel_" + String(nivel) + ".jpg";

  // Verifica se o arquivo existe
  if (!SPIFFS.exists(nome_arquivo)) {
    Serial.println("Arquivo não encontrado: " + nome_arquivo);
    return;
  }

  // Remove o arquivo
  if (SPIFFS.remove(nome_arquivo)) {
    Serial.println("Imagem de referência para nível " + String(nivel) + "% excluída com sucesso");

    // Feedback visual de sucesso
    for (int i = 0; i < 3; i++) {
      digitalWrite(BUILT_IN_LED, HIGH);
      delay(200);
      digitalWrite(BUILT_IN_LED, LOW);
      delay(200);
    }
  } else {
    Serial.println("Falha ao excluir o arquivo: " + nome_arquivo);
  }
}

// Compara a imagem capturada com todas as referências e identifica o nível de líquido mais próximo
int comparar_com_referencias(camera_fb_t *fb) {
  // Abre o diretório de referências
  File root = SPIFFS.open(REFERENCE_FOLDER);
  if (!root || !root.isDirectory()) {
    Serial.println("Falha ao abrir diretório de referências");
    return -1;
  }
  
  // Inicializa variáveis para rastrear o melhor match
  File file = root.openNextFile();
  float melhor_similaridade = 0;
  int melhor_nivel = -1;
  
  // Processa cada arquivo de referência
  while (file) {
    if (!file.isDirectory()) {
      String nome_arquivo = file.name();
      
      // Extrai o valor de nível do nome do arquivo
      int inicio = nome_arquivo.indexOf("_") + 1;
      int fim = nome_arquivo.indexOf(".");
      if (inicio > 0 && fim > inicio) {
        String nivel_str = nome_arquivo.substring(inicio, fim);
        int nivel = nivel_str.toInt();
        
        // Calcula a similaridade entre a imagem atual e a referência
        float similaridade = calcular_similaridade(fb, file);
        
        Serial.printf("Similaridade com %s: %.2f%%\n", nome_arquivo.c_str(), similaridade * 100);
        
        // Atualiza o melhor match se necessário
        if (similaridade > melhor_similaridade) {
          melhor_similaridade = similaridade;
          melhor_nivel = nivel;
        }
      }
    }
    file = root.openNextFile();
  }
  
  Serial.printf("Melhor similaridade: %.2f%%\n", melhor_similaridade * 100);
  
  // Retorna o nível apenas se a confiança for suficiente
  if (melhor_similaridade > 0.6) {
    return melhor_nivel;
  } else {
    return -1; // Indica que não foi possível determinar o nível com confiança
  }
}

// Algoritmo simplificado para calcular a similaridade entre duas imagens JPEG
float calcular_similaridade(camera_fb_t *fb, File &referencia) {
  // Implementação simplificada para demonstração - compara amostras de bytes das imagens
  // Em um sistema real, seria necessário decodificar o JPEG e implementar métodos mais robustos
  
  // Aloca buffer para a imagem de referência
  size_t tamanho_ref = referencia.size();
  uint8_t *buf_ref = new uint8_t[tamanho_ref];
  
  // Carrega a imagem de referência no buffer
  referencia.seek(0);
  referencia.readBytes((char*)buf_ref, tamanho_ref);
  
  // Converte tipos para evitar problemas na função min()
  int fb_len = static_cast<int>(fb->len);
  int tamanho_ref_int = static_cast<int>(tamanho_ref);
  int menor_tamanho = (fb_len < tamanho_ref_int) ? fb_len : tamanho_ref_int;
  int amostras = (1000 < menor_tamanho) ? 1000 : menor_tamanho;
  
  // Conta bytes similares (com tolerância) nas duas imagens
  int matches = 0;
  for (int i = 0; i < amostras; i++) {
    // Considera similar se a diferença for menor que um limite
    if (abs((int)fb->buf[i] - (int)buf_ref[i]) < 30) {
      matches++;
    }
  }
  
  // Libera a memória alocada
  delete[] buf_ref;
  
  // Retorna a proporção de bytes similares como medida de similaridade
  return (float)matches / amostras;
}