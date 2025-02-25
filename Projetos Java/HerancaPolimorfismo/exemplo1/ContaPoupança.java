package exemplo1;

public final class ContaPoupança extends ContaComum {
	
	private Double taxaJuros;
	
	public ContaPoupança() {
		super();
	}

	public ContaPoupança(Integer numeroConta, String nome, Double saldo, Double taxaJuros) {
		super(numeroConta, nome, saldo);
		this.taxaJuros = taxaJuros;
	}

	public Double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(Double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public void updateSaldo() {
		saldo += saldo * taxaJuros;
	}
	
	@Override
	public void saque(Double quantia) {
		saldo -= quantia;
	}
	
	
}
