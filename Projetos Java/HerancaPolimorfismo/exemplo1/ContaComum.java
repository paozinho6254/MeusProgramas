package exemplo1;

public abstract class ContaComum {
	
	private Integer numeroConta;
	private String nome;
	protected Double saldo;
	
	public ContaComum() {
		
	}
	
	public ContaComum(Integer numeroConta, String nome, Double saldo) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public void deposito(Double quantia) {
		saldo += quantia;
	}
	
	public void saque(Double quantia) {
		saldo -= quantia + 5;
	}
	
	
}
