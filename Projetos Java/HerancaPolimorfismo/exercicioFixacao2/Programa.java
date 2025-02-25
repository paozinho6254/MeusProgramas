package exercicioFixacao2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Número de pagadores de imposto: ");
		int qtdPessoas = input.nextInt();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		for(int i = 0; i < qtdPessoas; i++) {
			System.out.println("Pagador de impostos nº"+(1+i)+": ");
			System.out.print("Pessoa jurídica ou física? (j/f): ");
			input.nextLine();
			char tipoPessoa = input.next().charAt(0);
			System.out.print("Nome: ");
			input.nextLine();
			String nome = input.next();
			System.out.print("Renda anual: R$");
			input.nextLine();
			Double renda = input.nextDouble();
			
			if(tipoPessoa == 'j' || tipoPessoa == 'J') {
				System.out.print("Número de funcionarios: ");
				int qtdFuncionario = input.nextInt(); 
				pessoas.add(new PessoaJuridica(nome, renda, qtdFuncionario));
			}
			else if(tipoPessoa == 'f' || tipoPessoa == 'F') {
				System.out.print("Gastos com saúde: ");
				double gastoSaude = input.nextDouble();
				pessoas.add(new PessoaFisica(nome, renda, gastoSaude));
			}

 		}
		
		System.out.println();
		System.out.println("Impostos pagos: ");
		for(Pessoa x: pessoas) {
			System.out.println(x);
		}
		
		input.close();
	
	}

}
