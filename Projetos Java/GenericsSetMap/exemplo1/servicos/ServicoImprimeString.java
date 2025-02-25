package exemplo1.servicos;

import java.util.ArrayList;
import java.util.List;

public class ServicoImprimeString {

	private List<String> numeros = new ArrayList<>();
	
	public ServicoImprimeString() {
		
	}
	
	public void addLista(String valor) {
		numeros.add(valor);
	}
	
	public String primeiro() {
		return numeros.get(0);
	}
	
	public void print() {
		System.out.print("[");
		if(!numeros.isEmpty()) {
			System.out.print(numeros.get(0));
		}
		for(int i = 1; i < numeros.size(); i++) {
			System.out.print(", "+numeros.get(i));
		}
		System.out.print("]");
	}
	
}
