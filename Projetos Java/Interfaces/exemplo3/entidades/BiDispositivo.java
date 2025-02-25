package exemplo3.entidades;

import exemplo3.servicos.Impressora;
import exemplo3.servicos.Leitor;

public class BiDispositivo extends Dispositivo implements Leitor, Impressora{

	public BiDispositivo(String numeroSerie) {
		super(numeroSerie);
	}

	@Override
	public void processarDoc(String doc) {
		System.out.println("Processo Combo: " + doc);
	}

	@Override
	public void print(String doc) {
		System.out.println("Imprimiu isso: " + doc);
	}

	@Override
	public String scan() {
		return "Leitor combo resultado";
	}
	
	
	
}
