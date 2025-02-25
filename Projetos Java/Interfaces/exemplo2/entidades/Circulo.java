package exemplo2.entidades;

import exemplo2.enuns.Cor;
import exemplo2.servicos.FormaAbstrata;

public class Circulo extends FormaAbstrata{

	private Double raio;
	private Cor cor;

	public Circulo(Cor cor, Double raio) {
		super(cor);
		this.raio = raio;
	}

	public Double getRaio() {
		return raio;
	}

	public void setRaio(Double raio) {
		this.raio = raio;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	@Override
	public double area() {
		return Math.pow(raio, 2) * Math.PI;
	}
	
}
