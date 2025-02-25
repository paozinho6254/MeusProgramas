package programas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Empresa;
import entidades.Funcionario;
import entidades.HoraContrato;
import entidades.NivelFuncionario;

public class Exercicio1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Insira o nome da empresa: ");
		String nomeEmpresa = input.nextLine();
		System.out.println("Dados do funcionário: ");
		System.out.print("Nome: ");
		String nomeFuncionario = input.nextLine();
		System.out.print("Nível Funcionario: ");
		String nivel = input.nextLine();
		System.out.print("Salário base: ");
		Double salario = input.nextDouble();
		
		Funcionario funcionario = new Funcionario(nomeFuncionario, NivelFuncionario.valueOf(nivel), salario, new Empresa(nomeEmpresa));
		
		System.out.print("Insira o número de contratos: ");
		int numContratos = input.nextInt();
		
		for(int i = 0; i < numContratos; i++) {
			
			System.out.println("Insira o "+(i+1)+"º contrato:");
			System.out.println("Data (DD/MM/YYYY)");
			System.out.print("Dia: ");
			int dia = input.nextInt();
			System.out.print("Mês: ");
			int mes = input.nextInt();
			System.out.print("Ano: ");
			int ano = input.nextInt();
			LocalDate dataContrato = LocalDate.of(ano, mes, dia);
			System.out.println("Data do contrato = " + dataContrato.format(fmt1));
			System.out.print("Valor da hora do contrato: ");
			Double valorHora = input.nextDouble();
			System.out.print("Duração do contrato: ");
			int duracao = input.nextInt();
			HoraContrato contrato = new HoraContrato(dataContrato, valorHora, duracao); 
			funcionario.addContrato(contrato);
		}
		
		System.out.println("Digite o mês e o ano do contrato para calcular o salario: ");
		System.out.print("Mês: ");
		int mes = input.nextInt();
		System.out.print("Ano: ");
		int ano = input.nextInt();
		double renda = funcionario.renda(ano, mes);
		
		System.out.println("Nome: "+funcionario.getNomeFuncionario());
		System.out.println("Empresa: "+funcionario.getNomeEmpresa().getNomeEmpresa());
		System.out.println("Renda de "+mes+"/"+ano+": "+renda);
		
	}

}
