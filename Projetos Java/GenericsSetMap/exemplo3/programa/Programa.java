package exemplo3.programa;

import java.util.Arrays;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
		
		System.out.println("Lista de números: ");
		List<Integer> myInts = Arrays.asList(5, 2, 10);
		printList(myInts);
		
		System.out.println("Lista de nomes:");
		List<String> meusNomes = Arrays.asList("Rrceba",
				"bora bill", 
				"receive!");
		printList(meusNomes);
	}

	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}	

}
