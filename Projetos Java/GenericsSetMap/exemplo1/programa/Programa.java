package exemplo1.programa;

import java.util.Scanner;

import exemplo1.servicos.ServicoImprime;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		System.out.println("Quantos números: ");
		Integer nums = input.nextInt();
		
		ServicoImprime<String> si = new ServicoImprime<>();
		
		for(int i = 0; i < nums; i++) {
			System.out.println("Valor: ");
			String valor = input.next();
			si.addLista(valor);
		}
		
		si.print();
		String x = si.primeiro();
		System.out.println();
		System.out.println("Primeiro: "+x);
		
		input.close();
	}

}
