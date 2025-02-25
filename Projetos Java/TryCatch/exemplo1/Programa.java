package exemplo1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		metodo1();
		
		System.out.println("Fim do programa");

	}

	public static void metodo1() {
		System.out.println("**Começo do metodo1**");
		metodo2();
		System.out.println("**Fim do metodo1**");
	}
	
	public static void metodo2() {
		System.out.println("**Começo do metodo2**");
		Scanner input = new Scanner(System.in);
		try {
			String[] vetor = input.nextLine().split(" ");

			int pos = input.nextInt();
			System.out.println(vetor[pos]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Posição invalida!");
			e.printStackTrace();
			input.next();
		} catch (InputMismatchException e) {
			System.out.println("Insira numeros!");
		}
		System.out.println("**Fim do metodo2**");
	}
}
