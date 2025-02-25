package exercicioFixacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Quantidade de itens: ");
		int qtdProdu = input.nextInt();
		List<Produto> produtos = new ArrayList<>();
		for(int i = 0; i < qtdProdu; i++) {
			System.out.println("Dados do "+(i+1)+"º produto: ");
			System.out.print("Produto comum, usado ou importado? (c/u/i): ");
			char tipoProduto = input.next().charAt(0);
			input.nextLine();
			System.out.print("Nome: ");
			String nome = input.nextLine();
			System.out.print("Preço: ");
			Double preco = input.nextDouble();
			
			if(tipoProduto == 'c' || tipoProduto == 'C') {
				produtos.add(new Produto(nome, preco));
			}
			
			else if(tipoProduto == 'u' || tipoProduto == 'U') {
				System.out.println("Data de manufatura: ");
				System.out.print("Dia: ");
				int dia = input.nextInt();
				System.out.print("Mês: ");
				int mes = input.nextInt();
				System.out.print("Ano: ");
				int ano = input.nextInt();
				LocalDate dataManufatura = LocalDate.of(ano, mes, dia);
				produtos.add(new ProdutoUsado(nome, preco, dataManufatura));
			}
			
			else if(tipoProduto == 'i' || tipoProduto == 'I') {
				System.out.println("Taxa da Alfandega: ");
				Double taxaAfandega = input.nextDouble();
				produtos.add(new ProdutoImportado(nome, preco, taxaAfandega));
			}
			
		}
		System.out.println();
		System.out.println("Etiqueta de preços: ");
		
		for(Produto x: produtos) {
			System.out.println(x);
		}
		
		input.close();
	}

}
