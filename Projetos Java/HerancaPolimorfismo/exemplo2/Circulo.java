package exemplo2;

public class Circulo extends Formato{

	private static final double PI = 3.14;
	
	private double raio;
	
	public Circulo() {
		
	}

	public Circulo(Cor cor, double raio) {
		super(cor);
		this.raio = raio;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	@Override
	public double areaCalculo() {
		double area = 0;
		area = (Math.pow(raio, 2)) * PI; 
		return area;
	}	
	
}
