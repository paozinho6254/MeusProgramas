package programas;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program3 {
	
	public static void main(String[] args) {
				
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate d04 = LocalDate.parse("2025-01-08");
		LocalDateTime d05 = LocalDateTime.parse("2025-01-08T12:50:30");
		Instant d06 = Instant.parse("2025-01-08T01:50:30Z");
		
		//a variavel pastweek é para saber a data hora de 7 dias atrás
		LocalDate pastWeekLocalDate = d04.minusDays(7);
		//ja a nextweek adiciona 7 dias, proxima semana
		LocalDate nextWeekLocalDate = d04.plusDays(7);
		//adiciona 100 anos a data citada
		LocalDate nextYearLocalDate = d04.plusYears(100);
		
		System.out.println("d04 + 7 dias = "+nextWeekLocalDate.format(fmt2));
		System.out.println("d04 - 7 dias = "+pastWeekLocalDate.format(fmt2));
		System.out.println("d04 = 100 anos = "+nextYearLocalDate.format(fmt2));
		

		LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
		LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);
		
		System.out.println("d05 + 7 dias = "+nextWeekLocalDateTime.format(fmt1));
		System.out.println("d05 - 7 dias = "+pastWeekLocalDateTime.format(fmt1)); 
		
		Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
		Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);
		
		System.out.println("d06 + 7 dias = " + nextWeekInstant);
		System.out.println("d06 - 7 dias = " + pastWeekInstant);
		
		//O duration é que compara a distancia de tempo entre duas datas
		Duration d1 = Duration.between(pastWeekLocalDateTime, d05);
		//Duration d2 = Duration.between(pastWeekLocalDate, d04);
		//obs, O duration só funciona com datas com segundos/horarios
		//por isso ao usar o comando em barra o console da erro
		
		//já que a variável e d04 são localdate (Sem horário) converto para que sejam
		//00:00 assim tendo um "time" digamos assim 
		//mas caso queira bonitar, use atStartOfDay, muda nada
		Duration d2 = Duration.between(pastWeekLocalDate.atTime(0, 0), d04.atStartOfDay());
		
		//por curiosidade o instant funciona sem problemas
		Duration d3 = Duration.between(pastWeekInstant, d06);
		
		Duration d4 = Duration.between(d06, pastWeekInstant);
		
		
		//o metodo toDays do duration passa esse tempo de diferença para dias
		System.out.println("Tempo entre semana passada e 08/01/2025 de d05 = " + d1.toDays());
		System.out.println("Tempo entre semana passada e 08/01/2025 de d04 = " + d2.toDays());
		System.out.println("Tempo entre semana passada e 08/01/2025 de d06 = " + d3.toDays());
		//pergunte o que quiser, é como fazer (1 - 8) que dá -7
		System.out.println("Tempo entre 08/01/2025 e semana passada de d06 = " + d4.toDays());
	}	
}
