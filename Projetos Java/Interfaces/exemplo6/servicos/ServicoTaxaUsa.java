package exemplo6.servicos;

public class ServicoTaxaUsa implements TaxaServico {

private double taxa;
	
	public ServicoTaxaUsa(double taxa) {
		this.taxa = taxa;
	}

	@Override
	public Double getTaxa() {
		return taxa;
	}
	
}
