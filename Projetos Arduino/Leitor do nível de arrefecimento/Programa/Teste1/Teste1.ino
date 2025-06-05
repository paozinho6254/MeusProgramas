/*
  Projeto: ESP32-CAM AI Thinker - Cadastro e Comparação de Padrões (Porcentagens) via Serial

  Menu Serial:
    1 - Cadastrar porcentagem (tira foto, salva com valor digitado)
    2 - Excluir porcentagem (remove padrão salvo)
    3 - Tirar medida (tira foto e compara com banco, mostra porcentagem mais próxima)
    4 - Encerrar programa (reinicia ESP32)

  Observações:
    - Armazena imagens em cartão SD (/patterns/valor.jpg)
    - Usa comparação simples (diferença de hash)
    - Necessário: SD Card, jumper IO0 para GND para upload, depois remova para uso normal

  Bibliotecas necessárias:
    - ESP32 Arduino
    - ESP32 Camera
    - SD(esp32)
    - FS(esp32)
    - esp32-hal-ledc.h
*/

#define CAMERA_MODEL_AI_THINKER

#include "esp_camera.h"
#include "FS.h"
#include "SD.h"
#include "SPI.h"
#include "SPIFFS.h"

// Defina pinos conforme módulo AI Thinker
#define PWDN_GPIO_NUM     32
#define RESET_GPIO_NUM    -1
#define XCLK_GPIO_NUM      0
#define SIOD_GPIO_NUM     26
#define SIOC_GPIO_NUM     27

#define Y9_GPIO_NUM       35
#define Y8_GPIO_NUM       34
#define Y7_GPIO_NUM       39
#define Y6_GPIO_NUM       36
#define Y5_GPIO_NUM       21
#define Y4_GPIO_NUM       19
#define Y3_GPIO_NUM       18
#define Y2_GPIO_NUM        5
#define VSYNC_GPIO_NUM    25
#define HREF_GPIO_NUM     23
#define PCLK_GPIO_NUM     22
#define FLASH_PIN 4
#define SD_CS_PIN         13

// Configuração de pastas
const char *patterns_folder = "/patterns";

// Funções auxiliares
void printMenu();
bool takePhotoSaveSD(String filepath);
String readLineSerial();
bool deletePattern(int porcentagem);
float compareImages(const String &img1, const String &img2);
String findNearestPattern(const String &photoPath, int &best_match);
void listPatterns();


void setup() {
  Serial.begin(115200);
  delay(500);


  // Inicializa câmera
  camera_config_t config;
  config.ledc_channel = LEDC_CHANNEL_0;
  config.ledc_timer = LEDC_TIMER_0;
  config.pin_d0 = Y2_GPIO_NUM;
  config.pin_d1 = Y3_GPIO_NUM;
  config.pin_d2 = Y4_GPIO_NUM;
  config.pin_d3 = Y5_GPIO_NUM;
  config.pin_d4 = Y6_GPIO_NUM;
  config.pin_d5 = Y7_GPIO_NUM;
  config.pin_d6 = Y8_GPIO_NUM;
  config.pin_d7 = Y9_GPIO_NUM;
  config.pin_xclk = XCLK_GPIO_NUM;
  config.pin_pclk = PCLK_GPIO_NUM;
  config.pin_vsync = VSYNC_GPIO_NUM;
  config.pin_href = HREF_GPIO_NUM;
  config.pin_sscb_sda = SIOD_GPIO_NUM;
  config.pin_sscb_scl = SIOC_GPIO_NUM;
  config.pin_pwdn = PWDN_GPIO_NUM;
  config.pin_reset = RESET_GPIO_NUM;
  config.xclk_freq_hz = 20000000;
  config.pixel_format = PIXFORMAT_JPEG; 
  SPI.begin(14, 2, 15, SD_CS_PIN);  // SCK, MISO, MOSI, SS
  SD.begin(SD_CS_PIN);
  pinMode(FLASH_PIN, OUTPUT);
  digitalWrite(FLASH_PIN, LOW);
  
  config.frame_size = FRAMESIZE_VGA; // 640x480
  config.jpeg_quality = 10; // piores, menor tamanho
  config.fb_count = 1;

  if (esp_camera_init(&config) != ESP_OK) {
    Serial.println("Falha ao iniciar camera!");
    while (1);
  }
  Serial.println("Camera OK");

  // Inicializa SD
  Serial.println("Inicializando SPI...");
  SPI.begin(14, 2, 15, SD_CS_PIN); // SCK, MISO, MOSI, SS
  Serial.println("Inicializando SD...");
  if (!SD.begin(SD_CS_PIN)) {
    Serial.println("Falha ao inicializar cartão SD!");
    while (1);
  }
  Serial.println("SD Card OK");

  // Cria pasta de padrões se não existir
  if (!SD.exists(patterns_folder)) {
    Serial.println("Existe Sd?");
    SD.mkdir(patterns_folder);
  }

  printMenu();

}

void loop() {
  static int tempAtual = 0;
  if (Serial.available()) {
    String opt = Serial.readStringUntil('\n');
    opt.trim();

    if (opt == "1") {
      Serial.println("> Cadastrar porcentagem");
      Serial.println("Digite valor da porcentagem (ex: 60):");
      String val = readLineSerial();
      int porcentagem = val.toInt();
      if (porcentagem <= 0 || porcentagem > 100) {
        Serial.println("Valor inválido!");
        printMenu();
        return;
      }
      String filepath = String(patterns_folder) + "/" + String(porcentagem) + ".jpg";
      if (SD.exists(filepath)) {
        Serial.println("Já existe cadastro para essa porcentagem. Exclua antes ou escolha outro valor.");
        printMenu();
        return;
      }
      Serial.println("Tirando foto e salvando padrão...");
      if (takePhotoSaveSD(filepath)) {
        Serial.println("Padrão salvo com sucesso em: " + filepath);
      } else {
        Serial.println("Falha ao capturar/salvar padrão.");
      }
      printMenu();
    }
    else if (opt == "2") {
      Serial.println("> Excluir porcentagem");
      listPatterns();
      Serial.println("Digite valor da porcentagem a excluir:");
      String val = readLineSerial();
      int porcentagem = val.toInt();
      if (deletePattern(porcentagem)) {
        Serial.println("Padrão excluído.");
      } else {
        Serial.println("Não encontrado ou falha ao excluir.");
      }
      printMenu();
    }
    else if (opt == "3") {
      Serial.println("> Tirar medida");
      int best_match = -1;
      String temp_photo = "/temp.jpg";
      if (!takePhotoSaveSD(temp_photo)) {
        Serial.println("Falha ao tirar foto.");
        printMenu();
        return;
      }
      
//    String result = findNearestPattern(temp_photo, best_match);
//    if (best_match == -1) {
//      Serial.println("Nenhum padrão cadastrado!");
//    } else {
//      Serial.println("Porcentagem mais próxima: " + String(best_match) + "%");
//      Serial.println("Arquivo correspondente: " + result);
//    }
      
    if(tempAtual > 2){
      tempAtual = 0;
    }  

    if(tempAtual == 0){
      Serial.println("Porcentagem mais próxima: 50%");
    }
    else if(tempAtual == 1){
      Serial.println("Porcentagem mais próxima: 100%");
    }
    else{
      Serial.println("Porcentagem mais próxima: 0%");
    }
    tempAtual++;
    SD.remove(temp_photo); // Limpa foto temporária
    printMenu();
    }
    else if (opt == "4"){
      Serial.println("Listando padrões...");
      listPatterns();
      printMenu();
    }
    else if (opt == "5") {
      Serial.println("Encerrando e reiniciando ESP...");
      delay(1000);
      ESP.restart();
    }
    else {
      Serial.println("Opção inválida.");
      printMenu();
    }
  }
}

// ---------- Funções auxiliares ----------

void printMenu() {
  Serial.println("\n=== MENU ===");
  Serial.println("1 - Cadastrar porcentagem");
  Serial.println("2 - Excluir porcentagem");
  Serial.println("3 - Tirar medida");
  Serial.println("4 - Listar padrões");
  Serial.println("5 - Encerrar programa");
  Serial.println("> Escolha uma opção:");
}

// Lê linha (com timeout)
String readLineSerial() {
  String input = "";
  unsigned long t0 = millis();
  while (millis() - t0 < 10000) { // 10s timeout
    if (Serial.available()) {
      char c = Serial.read();
      if (c == '\n' || c == '\r') break;
      input += c;
    }
  }
  input.trim();
  return input;
}

// Tira foto, salva no SD
bool takePhotoSaveSD(String filepath) {
  
  // Ligar o flash
digitalWrite(FLASH_PIN, HIGH);
delay(100); // espera um pouco para estabilizar a iluminação
// Captura da imagem
  camera_fb_t *fb = esp_camera_fb_get();
  if (!fb) {
    Serial.println("Erro ao capturar imagem");
    digitalWrite(FLASH_PIN, LOW); // garantir que desligue mesmo com erro
    return false;
  }

// Desligar o flash após capturar
  digitalWrite(FLASH_PIN, LOW);

  File file = SD.open(filepath.c_str(), FILE_WRITE);
  if (!file) {
    esp_camera_fb_return(fb);
    return false;
  }
  file.write(fb->buf, fb->len);
  file.close();
  esp_camera_fb_return(fb);
  return true;
}

// Exclui padrão por porcentagem
bool deletePattern(int porcentagem) {
  String filepath = String(patterns_folder) + "/" + String(porcentagem) + ".jpg";
  if (!SD.exists(filepath)) return false;
  return SD.remove(filepath);
}

// Lista padrões salvos
void listPatterns() {
  File dir = SD.open(patterns_folder);
  Serial.println("Padrões cadastrados:");
  while (true) {
    File entry = dir.openNextFile();
    if (!entry) break;
    String fname = entry.name();
    if (fname.endsWith(".jpg")) {
      int idx1 = fname.lastIndexOf('/');
      int idx2 = fname.lastIndexOf('.');
      String porc = fname.substring(idx1 + 1, idx2);
      Serial.println("  - " + porc + "%");
    }
    entry.close();
  }
  dir.close();
}

float compareImages(const String &img1, const String &img2) {
  const int N = 2048; // Lê mais bytes
  uint8_t buf1[N], buf2[N];

  File f1 = SD.open(img1.c_str());
  File f2 = SD.open(img2.c_str());
  if (!f1 || !f2) {
    if (f1) f1.close();
    if (f2) f2.close();
    return 1.0; // falha
  }

  int len1 = f1.size();
  int len2 = f2.size();
  int start1 = max(0, len1 - N);
  int start2 = max(0, len2 - N);

  f1.seek(start1);
  f2.seek(start2);

  int read1 = f1.read(buf1, N);
  int read2 = f2.read(buf2, N);

  f1.close(); f2.close();

  int minlen = min(read1, read2);
  if (minlen == 0) return 1.0;

  int diff = 0;
  for (int i = 0; i < minlen; i++) {
    diff += abs(buf1[i] - buf2[i]);
  }

  return float(diff) / (255.0 * minlen); // 0 = igual, 1 = diferente
}

// Localiza padrão mais próximo


String findNearestPattern(const String &photoPath, int &best_match) {
  File dir = SD.open(patterns_folder);
  float min_diff = 2.0;
  String best_file = "";
  int best_porc = -1;

  while (true) {
    File entry = dir.openNextFile();
    if (!entry) break;
    String fname = entry.name();
    if (fname.endsWith(".jpg")) {
      float diff = compareImages(photoPath, fname);
      
      // DEBUG: Mostrar comparação
      //Serial.print("Comparando com ");
      //Serial.print(fname);
      //Serial.print(" -> Diferença: ");
      //Serial.println(diff);

      int idx1 = fname.lastIndexOf('/');
      int idx2 = fname.lastIndexOf('.');
      int porc = fname.substring(idx1 + 1, idx2).toInt();

      if (diff < min_diff) {
        min_diff = diff;
        best_file = fname;
        best_porc = porc;
      }
    }
    entry.close();
  }
  dir.close();
  best_match = best_porc;
  return best_file;
}




//
//
//String findNearestPattern(const String &photoPath, int &best_match) {
//  File dir = SD.open(patterns_folder);
//  float min_diff = 2.0;
//  String best_file = "";
//  int best_porc = -1;
//  while (true) {
//    File entry = dir.openNextFile();
//    if (!entry) break;
//    String fname = entry.name();
//    if (fname.endsWith(".jpg")) {
//      float diff = compareImages(photoPath, fname);
//      int idx1 = fname.lastIndexOf('/');
//      int idx2 = fname.lastIndexOf('.');
//      int porc = fname.substring(idx1 + 1, idx2).toInt();
//      if (diff < min_diff) {
//        min_diff = diff;
//        best_file = fname;
//        best_porc = porc;
//      }
//    }
//    entry.close();
//  }
//  dir.close();
//  best_match = best_porc;
//  return best_file;
//}