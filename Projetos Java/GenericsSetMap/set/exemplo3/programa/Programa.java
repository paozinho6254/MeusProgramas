package set.exemplo3.programa;

import java.util.HashSet;
import java.util.Set;

import set.exemplo3.entidade.Produto;

public class Programa {

	public static void main(String[] args) {
		
		Set<Produto> set = new HashSet<>();
		 set.add(new Produto("TV", 900.0));
		 set.add(new Produto("Notebook", 1200.0));
		 set.add(new Produto("Tablet", 400.0));
		 Produto prod = new Produto("Notebook", 1200.0);
		 //O resultado vai ser false caso não tenha os métodos em hashcode
		 //com os métodos ele não vai comparar por referência/memória
		 //mas sim pelo conteúdo
		 System.out.println(set.contains(prod));

	}

}
