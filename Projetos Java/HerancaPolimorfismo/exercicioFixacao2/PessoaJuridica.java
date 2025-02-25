package exercicioFixacao2;

public class PessoaJuridica extends Pessoa {
	
	private Integer qtdFuncionarios;
	
	public PessoaJuridica(){
		
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer qtdFuncionarios) {
		super(nome, rendaAnual);
		this.qtdFuncionarios = qtdFuncionarios;
	}

	public Integer getQtdFuncionarios() {
		return qtdFuncionarios;
	}

	public void setQtdFuncionarios(Integer qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}

	@Override
	public Double imposto() {
		double imposto = 0;
		if(qtdFuncionarios < 10) {
			imposto = 0.16;
		}
		else if (qtdFuncionarios >= 10) {
			imposto = 0.16;
		}	
		double impostos = (getRendaAnual() * imposto);
		return impostos;
	}
	

}
