package fixacao1.servicos;

public class ServicoPaypal implements ServicoOnlinePagamento{

	public double acrescimo(Double valor, Integer meses) {
		return valor * 0.01 * meses;
	}

	public double taxa(Double valor) {
		return valor * 0.02;
	}

}
