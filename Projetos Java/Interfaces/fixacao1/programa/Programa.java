package fixacao1.programa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import fixacao1.entidades.Contrato;
import fixacao1.entidades.Parcelamento;
import fixacao1.servicos.ServicoContrato;
import fixacao1.servicos.ServicoPaypal;


public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Número: ");
		Integer numero = input.nextInt();

		System.out.println("Data do contrato: ");
		LocalDate data = LocalDate.parse(input.next(), fmt1);

		System.out.println("Valor do contrato: ");
		Double valor = input.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valor);
		
		System.out.println("Número de parcelas: ");
		Integer numParcelas = input.nextInt();
		
		ServicoContrato servicoContrato = new ServicoContrato(new ServicoPaypal());
		
		servicoContrato.processContract(contrato, numParcelas);
		
		for(Parcelamento parcelamento : contrato.getParcelas()) {
			System.out.println(parcelamento);
		}
		
		input.close();
	}

}
