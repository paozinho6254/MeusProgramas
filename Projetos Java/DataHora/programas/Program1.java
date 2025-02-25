package programas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class Program1 {

	public static void main(String[] args) {

		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;
		
		//Ano/Mes/Dia atual
		LocalDate d01 =  LocalDate.now();
		System.out.println("Ano/Mes/Dia atual = "+d01);
		
		//Ano/Mes/Dia hora/minuto/segundo/fração caralhenta atual
		LocalDateTime d02 = LocalDateTime.now();
		System.out.println("Ano/Mes/Dia hora/minuto/segundo atual = "+d02);
		
		//instant, mesma coisa mas só muda 3 horas por conta do fuso-horário com o de greenwich
		Instant d03 = Instant.now();
		System.out.println("Instant/Greenwich = "+d03);
		
		//LocalDate.parse, um horário que defini
		LocalDate d04 = LocalDate.parse("2025-01-08");
		System.out.println(d04);
		
		//Mesma coisa com horario
		LocalDateTime d05 = LocalDateTime.parse("2025-01-08T12:50:30");
		System.out.println(d05);
		
		//E também instant
		Instant d06 = Instant.parse("2025-01-08T12:50:30Z");
		System.out.println(d06);
		
		//Aqui é só foi adicionado o -03:00 pois indico que estou no horário de são paulo
		//que na teoria estamos com 3 horas a menos do que o de londres, por isso o "-"
		Instant d07 = Instant.parse("2025-01-08T12:50:30-03:00");
		System.out.println(d07);
		
		//sim se eu tentar colocar "LocalDate.parse("20/07/2002");" não vai dar certo
		//por isso utilizamos o DateTimeFormatter para traduzir o que escrevemos
		//nota: sempre escreva mes em maiusculo
		LocalDate d08 = LocalDate.parse("08/01/2025", fmt1);
		System.out.println(d08);
		
		//Para adicionar horas e minutos apenas adicione outro formato e também as horas e minutos no parse

		LocalDateTime d09 = LocalDateTime.parse("08/01/2025 03:50", fmt2);
		System.out.println(d09);
		
		//forma simplificada do parse E QUE PODE INSERIR NUMEROS com ano, mes e dia
		int ano = 2025;
		int mes = 1; 
		int dia = 8;	
		LocalDate d10 = LocalDate.of(ano, mes, dia);
		System.out.println("d10 = "+d10.format(fmt1));
		
		//Aqui você adiciona os horarios como no exemplo acima ^^^
		LocalDateTime d11 = LocalDateTime.of(2025, 1, 8, 1, 20);
		System.out.println(d11);
		
		//Aqui em d12 e d13 estamos retomando os exemplos 4 e 5
		LocalDate d12 = LocalDate.parse("2025-01-08");
		System.out.println("d12 = "+d12.format(fmt1));
		
		LocalDateTime d13 = LocalDateTime.parse("2025-01-08T12:50:30");
		System.out.println("d13 = "+d13.format(fmt2));
		
		//ja para uma data hora global vamos precisar traduzir ela no caso o "Instant"
		//do exemplo d06, isso acontece pois o instant é algo ambíguo, é outro horário/fuso-horário
		//é aqui o pulo do gato, como o fuso-horário muda, o dia também muda dependendo da hora
		//ou seja 1:50Am - 03:00 = 22:50 do dia anterior
		Instant d14 = Instant.parse("2025-01-08T01:50:30Z");
		//como já dito nates, o instant não aceito o format, por isso vamos chamar o método fmt3
		//para assumir e encaixar no metodo format o d14, no caso o instant
		System.out.println("d14 = "+fmt3.format(d14));

		//Mas e se usarmos formatadores prontos? no caso os isos(linha 16)
		LocalDateTime d15 = LocalDateTime.parse("2025-01-08T12:50:30");
		System.out.println("d15 = "+d15.format(fmt4));
		
		//Mas ao tentar com Instant do exemplo d14, não da certo pois continua sendo instant
		//Como fazer? adicione ISO_Instant, também mantendo a estrutura do instant \/ abaixo
		Instant d16 = Instant.parse("2025-01-08T01:50:30Z");
		System.out.println("d16/14 = "+fmt5.format(d16));
		//mas o instant também pode ser impresso no toString
		System.out.println("d16 toString = "+d16.toString());
		
	}
}