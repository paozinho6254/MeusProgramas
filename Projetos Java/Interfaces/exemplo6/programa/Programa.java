package exemplo6.programa;

import java.util.Scanner;

import exemplo6.servicos.ServicoTaxaBrasil;
import exemplo6.servicos.ServicoTaxaUsa;
import exemplo6.servicos.TaxaServico;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantia: ");
		Double valor = input.nextDouble();
		System.out.println("Meses: ");
		Integer meses = input.nextInt();
		
		/* Aqui o programa chama a interface Taxa Servico pois contém os métodos
		 * e logo depois o instanceia as classes que colocam o métodos na prática
		 * O que entra é o valor da taxa de acordo com o pais, na classe há um construtor
		 * para atribuir esse valor, pois o valor da taxa é atributo de uma classe de serviço
		 * de um pais especifico
		 */
		TaxaServico br = new ServicoTaxaBrasil(1.02);
		TaxaServico us = new ServicoTaxaUsa(1.01);

		System.out.println("Pagamento após "+meses+" meses nos Estados Unidos: ");
		System.out.println(String.format("%.2f", us.pagamento(valor, meses)));
		
		System.out.println();
		
		System.out.println("Pagamento após "+meses+" meses no Brasil: ");
		System.out.println(String.format("%.2f", br.pagamento(valor, meses)));
	
		input.close();
	}

}
