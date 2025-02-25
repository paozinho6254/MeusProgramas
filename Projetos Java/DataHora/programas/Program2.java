package programas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class Program2 {

	public static void main(String[] args) {
		//coleção com os nomes do fuso-horarios customizados
		//coisa pra caralho
		//ZoneId.getAvailableZoneIds();
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		LocalDate d04 = LocalDate.parse("2025-01-08");
		LocalDateTime d05 = LocalDateTime.parse("2025-01-08T12:50:30");
		Instant d06 = Instant.parse("2025-01-08T01:50:30Z");
		
		//Como converter do data hora global para o local
		
		//muda o fuso-horario considerando o horário do meu computador
		//por isso que d06(Londres = 01:50) volta um dia (Brasil 22:50)
		LocalDateTime r1 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
		//aqui de acordo com o fuso horário de portugal (mesmo de londres ent nem muda
		LocalDateTime r2 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));
		
		//resultado é que volte 1 dia pois o horário esta nas 01:50 no horário de londres
		System.out.println("R1 = "+fmt1.format(r1));
		
		//Horario continue como atribui no d06
		System.out.println("R2 = "+fmt1.format(r2));
		
		//Como obter dados com data horas locais
		
		//um get do dia do mês da data de d04 (08/01/2025) 
		System.out.println("d04 dia do mês = "+ d04.getDayOfMonth());
		//você consegue o valor do mes
		System.out.println("d04 valor do mês = "+ d04.getMonthValue());
		//valor do ano
		System.out.println("d04 valor do ano = "+ d04.getYear());
		//valor da hora do dia
		System.out.println("d05 hora guardada = "+ d05.getHour());
		//valor dos minutos
		System.out.println("d05 minuto guardada = "+ d05.getMinute());
		

	}
}