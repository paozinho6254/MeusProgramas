package set.exemplo1.programa;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Programa {

	public static void main(String[] args) {

		Set<String> set = new TreeSet<>();
		
		set.add("TV");
		set.add("Notebook");
		set.add("Tablet");
	
		//remove itens da lista com tal condição (ex: se maior ou igual a 3 caracteres
		set.removeIf(x -> x.length() >= 3);
		
		//Escreve o tamanho da lista com base na quantidade de itens contidos nela
		System.out.println(set.size());
		
		//apaga todos o elementos da lista
		set.clear();
		
		System.out.println(set.contains("TV"));
		
		
		for (String p : set) {
			System.out.println(p);
		}

	}

}
