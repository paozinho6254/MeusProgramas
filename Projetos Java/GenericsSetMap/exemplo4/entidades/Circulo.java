package exemplo4.entidades;

import exemplo4.servicos.Forma;

public class Circulo implements Forma{

	private Double raio;
	
	public Circulo(Double raio) {
		this.raio = raio;
	}

	public Double getRaio() {
		return raio;
	}

	public void setRaio(Double raio) {
		this.raio = raio;
	}

	@Override
	public double area() {
		return Math.pow(raio, 2) * Math.PI;
	}
	
}
