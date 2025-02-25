package exemplo6.servicos;

public interface TaxaServico {

	Double getTaxa();
	
	default double pagamento(Double valor, Integer meses) {
		for(int i = 0; i < meses; i++) {
			valor *= getTaxa();
		}
		return valor;
	}
	
}
