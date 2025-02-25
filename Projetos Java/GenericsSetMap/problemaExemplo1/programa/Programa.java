package problemaExemplo1.programa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programa {

	public static void main(String[] args) {

		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs = new ArrayList<Object>();
		
		copy(myInts, myObjs);
		printList(myObjs);
		
		copy(myDoubles, myObjs);
		printList(myObjs);
		
	}
	
	/*
	 * A lista copia é um caso de covariancia, onde posse acessar os dados dela,
	 * enquanto a cola é uma contravariancia que aceita inserir dados de copia nela
	 */
	public static void copy(List<? extends Number> copia , List<? super Number> cola) {
		for(Number number: copia) {
			cola.add(number);
		}
	}
	
	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.print(obj+" ");
		}
		System.out.println();
	}

}
