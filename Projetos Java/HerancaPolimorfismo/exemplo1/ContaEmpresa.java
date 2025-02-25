package exemplo1;

public class ContaEmpresa extends ContaComum {

	private Double limiteCredito;

	public ContaEmpresa() {

	}

	public ContaEmpresa(Integer numeroConta, String nome, Double saldo, Double limiteCredito) {
		super(numeroConta, nome, saldo);
		this.limiteCredito = limiteCredito;
	}

	public Double getlimiteCredito() {
		return limiteCredito;
	}

	public void setlimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public void emprestimo(Double quantia) {
		if (quantia > limiteCredito) {
			saldo += quantia - 10;
		}
	}

	@Override
	public void saque(Double quantia) {
		super.saque(quantia);
		saldo -= 2.0;
	}

}
