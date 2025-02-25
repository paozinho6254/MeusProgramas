package exemplo1.servicos;

import java.util.ArrayList;
import java.util.List;

public class ServicoImprime<T> {

	private List<T> numeros = new ArrayList<>();
	
	public ServicoImprime() {
		
	}
	
	public void addLista(T valor) {
		numeros.add(valor);
	}
	
	public T primeiro() {
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
