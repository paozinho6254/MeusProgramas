package exemplo3.entidades;

import exemplo3.servicos.Leitor;

public class ConcreteLeitor extends Dispositivo implements Leitor{

	public ConcreteLeitor(String numeroSerie) {
		super(numeroSerie);
	}

	@Override
	public void processarDoc(String doc) {
		System.out.println("Processou Leitor: " + doc);
	}

	@Override
	public String scan() {
		return "Leitor combo resultado";
	}

}
