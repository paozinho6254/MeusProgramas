package fixacao1.servicos;

import java.time.LocalDate;

import fixacao1.entidades.Contrato;
import fixacao1.entidades.Parcelamento;

public class ServicoContrato {

	private ServicoOnlinePagamento servicoOnline;

	public ServicoContrato(ServicoOnlinePagamento servicoOnline) {
		this.servicoOnline = servicoOnline;
	}

	public void processContract(Contrato contrato, Integer meses) {
		double parcelaLimpa = contrato.getValorTotal() / meses;
		for (int i = 1; i <= meses; i++) {
			LocalDate dataParcela = contrato.getData().plusMonths(i);
			
			double acrecimo = servicoOnline.acrescimo(parcelaLimpa, i);
			double taxa = servicoOnline.taxa(acrecimo + parcelaLimpa);			
			double parcela = parcelaLimpa + acrecimo + taxa ;
			
			contrato.getParcelas().add(new Parcelamento(dataParcela, parcela));
		}
	}

}
