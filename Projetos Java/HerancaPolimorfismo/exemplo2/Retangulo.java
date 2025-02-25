package exemplo2;

public class Retangulo extends Formato {

	private Double largura;
	private Double altura;
	
	public Retangulo() {
		
	}
	
	public Retangulo(Cor cor, Double largura, Double altura) {
		super(cor);
		this.largura = largura;
		this.altura = altura;
	}	

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public double areaCalculo() {
		double area = 0;
		area = largura * altura;
		return area;
	}

}
