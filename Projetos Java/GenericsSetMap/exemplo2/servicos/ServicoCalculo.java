package exemplo2.servicos;

import java.util.List;

public class ServicoCalculo<T> {
	
	/*
	 * Como vou comparar objetos com variaveis de tipos diferentes,
	 * preciso adicionar a variável T a classe de serviço.
	 * O método é static pois posso chama-lo sem criar um objeto 
	 * no programa, T extende Comparable de tipo T para poder comparar
	 * os objetos. Assim se chama a lista de tipo T
	 */
	public static <T extends Comparable<T>> T max(List<T> lista) {
		// Varível max de tipo T assume primeiro item da lista
		T max = lista.get(0);
		//para cada item da lista de tipo T
		for (T item : lista) {
			//compare se o item atual é maior que max
			//compareTo é de Produto
			if (item.compareTo(max) > 0) {
				//se sim max assume o item que foi maior que sua versão anterior
				max = item;
			}
		}
		//retorne o item mais caro
		return max;
	}

}
