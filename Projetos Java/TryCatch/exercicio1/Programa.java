package exercicio1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do quarto: ");
			int numero = input.nextInt();
	
			System.out.print("Data do checkin(dd/MM/yyyy): ");
			Date checkin = sfd.parse(input.next());
	
			System.out.print("Data do Checkout(dd/MM/yyyy): ");
			Date checkout = sfd.parse(input.next());
	
			Reserva reserva = new Reserva(numero, checkin, checkout);
			
			System.out.println("Reserva: " + reserva);
	
			System.out.println("Digite a data atualizada: ");
	
			System.out.print("Data do checkin(dd/MM/yyyy): ");
			checkin = sfd.parse(input.next());
	
			System.out.print("Data do Checkout(dd/MM/yyyy): ");
			checkout = sfd.parse(input.next());
	
			reserva.upDatas(checkin, checkout);
	
			System.out.println("Reserva: " + reserva);
		}
		
		catch (ParseException e) {
			System.out.println("Formato de data invalida!");
		}

		catch(DominioExcecao e) {
			System.out.println("Erro na reserva: "+ e.getMessage());
		}
		/*
		 * Qualquer outro erro inesperado 
		 * (Como escrever letras ao invés de números)
		 */
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		

		input.close();
	}

}
