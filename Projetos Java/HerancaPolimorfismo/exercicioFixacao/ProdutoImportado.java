package exercicioFixacao;

public class ProdutoImportado extends Produto {
	
	private Double taxaAlfa;
	
	public ProdutoImportado() {
		
	}

	public ProdutoImportado(String nome, Double price, Double taxaAlfa) {
		super(nome, price);
		this.taxaAlfa = taxaAlfa;
	}

	public Double getTaxaAlfa() {
		return taxaAlfa;
	}

	public void setTaxaAlfa(Double taxaAlfa) {
		this.taxaAlfa = taxaAlfa;
	}
	
	public double precoTotal() {
		Double soma = getPreco() + taxaAlfa;
		return soma;
	}
	
	public String toString() {
		return getNome()
				+ " $ "
				+ precoTotal()
				+ " (Taxa da alfandega: $"
				+ getTaxaAlfa()
				+ ")";
	}
	
}
