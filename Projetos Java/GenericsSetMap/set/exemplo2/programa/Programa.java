package set.exemplo2.programa;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Programa {

	public static void main(String[] args) {

		Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
		
		// união de listas, c instanceia com elementos a 
		Set<Integer> c = new TreeSet<>(a);
		//e depois adiciona todos de b
		c.addAll(b);
		System.out.println(c);
		
		// interseção, d recebe elementos que a e b compartilham em comum
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println(d);
		
		// diferença, e recebe a e remove todos que possui em comum com b
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println(e);

	}

}
