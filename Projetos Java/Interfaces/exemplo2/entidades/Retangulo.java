package exemplo2.entidades;

import exemplo2.enuns.Cor;
import exemplo2.servicos.FormaAbstrata;

public class Retangulo extends FormaAbstrata {
	
	private Double altura;
	private Double largura;
	private Cor cor;
	
	public Retangulo(Cor cor, Double altura, Double largura) {
		super(cor);
		this.altura = altura;
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}
	
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	public Double getLargura() {
		return largura;
	}
	
	public void setLargura(Double largura) {
		this.largura = largura;
	}
	
	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	@Override
	public double area() {
		return largura * altura;
	}	
	
}
