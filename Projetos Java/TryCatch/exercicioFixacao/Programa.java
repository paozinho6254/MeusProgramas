package exercicioFixacao;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		try {
		System.out.println("Número da conta: ");
		int numConta = input.nextInt();
		System.out.println("Nome do proprietario: ");
		String nome = input.next();
		System.out.println("Saldo inicial: ");
		double saldo = input.nextDouble();
		System.out.println("Limite do saque da conta: ");
		double limiteSaque = input.nextDouble();
		
		Conta conta = new Conta(numConta, nome, saldo, limiteSaque);
		
		System.out.println("Insira o valor do saque: ");
		double valor = input.nextDouble();
		
		conta.saque(valor);
		
		System.out.println("Novo saldo = "+conta.getSaldo());
		}
		catch (DominioExcecao e) {
			System.out.println("Error: "+e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		
		input.close();
	}

}
