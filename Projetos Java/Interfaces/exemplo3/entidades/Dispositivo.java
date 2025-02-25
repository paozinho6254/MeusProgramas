package exemplo3.entidades;

public abstract class Dispositivo {
	
	private String numeroSerie;
		
	public Dispositivo() {
		
	}

	public Dispositivo(String numeroSerie) {
		super();
		this.numeroSerie = numeroSerie;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	public abstract void processarDoc(String doc);

}
