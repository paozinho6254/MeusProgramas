package exercicioFixacao2;

public class PessoaFisica extends Pessoa {

	private Double gastoSaude;
	
	public PessoaFisica() {
		
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}
	
	@Override
	public Double imposto() {
		double imposto = 0;
		if(getRendaAnual() < 20000) {
			imposto = 0.15;
		}
		else if (getRendaAnual() >= 20000) {
			imposto = 0.25;
		}	
		double impostos = (getRendaAnual() * imposto) - (gastoSaude * 0.50);
		return impostos;
	}
	
}
