package set.exemplo4.programa;

import java.util.Set;
import java.util.TreeSet;

import set.exemplo4.entidades.Produto;

public class Programa {

	public static void main(String[] args) {

		Set<Produto> set = new TreeSet<>();
		set.add(new Produto("TV", 900.0));
		set.add(new Produto("Notebook", 1200.0));
		set.add(new Produto("Tablet", 400.0));

		for (Produto p : set) {
			System.out.println(p);
		}
		
	}

}
