package exemplo4.programa;

import java.util.ArrayList;
import java.util.List;

import exemplo4.entidades.Circulo;
import exemplo4.entidades.Retangulo;
import exemplo4.servicos.Forma;

public class Programa {

	public static void main(String[] args) {	
		List<Forma> myFormas = new ArrayList<>();
		myFormas.add(new Retangulo(3.0, 2.0));
		myFormas.add(new Circulo(2.0));
		
		List<Circulo> myCirculos = new ArrayList<>();
		myCirculos.add(new Circulo(2.0));
		myCirculos.add(new Circulo(3.0));
		
		List<Retangulo> myRetangulos = new ArrayList<>();
		myRetangulos.add(new Retangulo(2.0, 5.0));
		myRetangulos.add(new Retangulo(3.0, 4.0));
		
		System.out.println("Total area: " + totalArea(myCirculos));
		
		List<Object> objetos = new ArrayList<Object>();
		
		copy(myRetangulos, objetos);
		
		for (Object s : objetos) {
			System.out.println(s);
		}
		
	}
	
	
	public static void copy(List<?> copia, List<?> cola) {
		cola = copia;
	}
	
	public static double totalArea(List<? extends Forma> list) {
		double sum = 0.0;
		for (Forma s : list) {
			sum += s.area();
		}
		return sum;
	}
}
