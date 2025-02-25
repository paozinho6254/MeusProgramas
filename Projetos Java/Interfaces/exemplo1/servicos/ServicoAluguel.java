package exemplo1.servicos;

import java.time.Duration;

import exemplo1.entidades.AluguelCarro;
import exemplo1.entidades.Fatura;

public class ServicoAluguel extends AluguelCarro{

	private Double valorHora;
	private Double valorDia;
	
	private ServicoTaxa taxaServico;
	
	public ServicoAluguel(Double valorHora, Double valorDia, ServicoTaxa taxaServico) {
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.taxaServico = taxaServico;
	}



	public void processFatura(AluguelCarro aluguel) {
		double minutos = Duration.between(aluguel.getRetirada(), aluguel.getRetorno()).toMinutes();
		double horas = minutos / 60;
		
		double pagamentoBasico;
		if(horas <= 12) {
			//Math.ceil é uma função math que arredonda um número para cima
			//ex: 4.10 horas = 5 horas
			pagamentoBasico = valorHora * Math.ceil(horas);
		}
		else {
			pagamentoBasico = valorDia * Math.ceil(horas/24);
			
		}
		double taxa = taxaServico.taxa(pagamentoBasico);

		aluguel.setFatura(new Fatura(pagamentoBasico, taxa));
	}
	
}
