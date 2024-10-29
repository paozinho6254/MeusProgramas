package POO.testes;

import java.util.Scanner;
import POO.entidades.Retangulo;

public class RetanguloTeste {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Retangulo retan = new Retangulo();
		
		System.out.println("Digite a altura e largura do retangulo: ");
		retan.altura = input.nextDouble();
		retan.largura = input.nextDouble(); 
		
		System.out.println(retan);
		
		input.close();
	}
}
