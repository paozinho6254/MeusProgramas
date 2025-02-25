package exercicio;

public class EmpregadoTerceiros extends Empregado{

	private Double taxaAdicional;
	
	public EmpregadoTerceiros() {
		super();
	}
	
	public EmpregadoTerceiros(String nome, Integer horas, Double valorHora, Double taxaAdicional) {
		super(nome, horas, valorHora);
		this.taxaAdicional = taxaAdicional;
	}

	public Double getTaxaAdicional() {
		return taxaAdicional;
	}

	public void setTaxaAdicional(Double taxaAdicional) {
		this.taxaAdicional = taxaAdicional;
	}

	@Override
	public double pagamento() {
		taxaAdicional *= 1.1;
		return super.pagamento() + taxaAdicional;
	}

	
}
