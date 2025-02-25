package exemplo6.servicos;

public class ServicoTaxaBrasil implements TaxaServico {
	
	private double taxa;
	
	public ServicoTaxaBrasil(double taxa) {
		this.taxa = taxa;
	}

	@Override
	public Double getTaxa() {
		return taxa;
	}
	
}
