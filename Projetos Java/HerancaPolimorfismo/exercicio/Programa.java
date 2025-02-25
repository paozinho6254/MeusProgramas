package exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Quantidade de funcionarios: ");
		int qtdF = input.nextInt();
		
		List<Empregado> empregados = new ArrayList<>();
		
		for(int i = 0; i < qtdF; i++) {
			System.out.println();
			System.out.print("É terceirizado? (S/N): ");
			char tipoFuncionario = input.next().charAt(0);
			System.out.println("Dados do "+(i+1)+"º escravo: ");
			System.out.print("Nome: ");
			input.nextLine();
			String nome = input.nextLine();
			System.out.print("Valor da hora: ");
			double valorHora = input.nextDouble();
			System.out.print("Horas trabalhadas: ");
			int horas = input.nextInt();
			if(tipoFuncionario == 'S' || tipoFuncionario == 's') {
				System.out.println("Valor adicional: ");
				double valorAdicional = input.nextDouble();
				empregados.add(new EmpregadoTerceiros(nome, horas, valorHora, valorAdicional));
				}
			else if(tipoFuncionario == 'N' || tipoFuncionario == 'n') {
				empregados.add(new Empregado(nome, horas, valorHora));
			}
		}
		System.out.println();
		System.out.println("Pagamentos: ");
		System.out.println();
		
		for(Empregado x: empregados) {
			System.out.println(x);
		}
		input.close();
	}

}
