package exemplo3.entidades;

import exemplo3.servicos.Impressora;

public class ConcreteImpressora extends Dispositivo implements Impressora {

	public ConcreteImpressora(String numeroSerie) {
		super(numeroSerie);
	}

	@Override
	public void processarDoc(String doc) {
		System.out.println("Processou Impressora: " + doc);
	}
	
	@Override
	public void print(String doc) {
		System.out.println("Imprimiu isso: " + doc);
	}
	
}
