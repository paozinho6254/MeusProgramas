package exemplo1.programa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import exemplo1.entidades.AluguelCarro;
import exemplo1.entidades.Carro;
import exemplo1.servicos.ServicoAluguel;
import exemplo1.servicos.SevicoTaxaBrasil;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
		
		System.out.println("Dados do aluguel do carro: ");
		
		System.out.println("Modelo do carro: ");
		String modelo = input.nextLine();
		
		System.out.println("Retirada (dd/MM/yyyy HH:mm): ");
		LocalDateTime retirada = LocalDateTime.parse(input.nextLine(), fmt1);
		
		System.out.println("Retorno (dd/MM/yyyy HH:mm): ");
		LocalDateTime retorno = LocalDateTime.parse(input.nextLine(), fmt1);

		AluguelCarro aluguel = new AluguelCarro(retirada, retorno, new Carro(modelo));
		
		System.out.println("Valor da hora: ");
		double valorHora = input.nextDouble();
		System.out.println("Valor do dia: ");
		double valorDia = input.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(valorHora, valorDia, new SevicoTaxaBrasil());
		
		servicoAluguel.processFatura(aluguel);
		
		System.out.println("Fatura:");
		System.out.println("Pagamento basico: "+aluguel.getFatura().getPagamentoBasico());
		System.out.println("Taxa: "+aluguel.getFatura().getTaxa());
		System.out.println("Pagamento total: "+aluguel.getFatura().getValorTotal());
	}

}
