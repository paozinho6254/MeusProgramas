package exemplo2;

import java.util.ArrayList;
import java.util.List;

public abstract class Formato {
	
	private Cor cor;
	private List<Formato> formatos = new ArrayList<>();
	
	public Formato() {
		
	}
	
	public Formato(Cor cor) {
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public void addFormato(Formato formato) {
		formatos.add(formato);
	}
	
	
	public abstract double areaCalculo();
	
}