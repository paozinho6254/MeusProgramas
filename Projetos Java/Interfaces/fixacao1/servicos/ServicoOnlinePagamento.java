package fixacao1.servicos;

public interface ServicoOnlinePagamento {

	double taxa(Double valor);
	double acrescimo(Double valor, Integer meses);
	
}
