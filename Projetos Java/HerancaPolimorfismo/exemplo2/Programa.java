package exemplo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Número de formatos: ");
		int qtdFmt = input.nextInt();
		
		List<Formato> formatos = new ArrayList<>();
		
		for(int i = 0; i < qtdFmt; i++) {
			//%d
			System.out.println("Formato Nº"+(i+1)+":  ");
			System.out.print("Retangulo ou circulo? (r/c): ");
			char tipoForma = input.next().charAt(0);
			input.nextLine();
			System.out.print("Cor (PRETO/AZUL/VERMELHO): ");
			String cor = input.nextLine();
			if(tipoForma == 'r' || tipoForma == 'R') {
				System.out.print("Largura: ");
				Double largura = input.nextDouble();
				System.out.print("Altura: ");
				Double altura = input.nextDouble();
				formatos.add(new Retangulo(Cor.valueOf(cor), largura, altura));
			}
			else if(tipoForma == 'c' || tipoForma == 'C') {
				System.out.print("Raio: ");
				Double raio = input.nextDouble();
				formatos.add(new Circulo(Cor.valueOf(cor), raio));
			}
		}
		
		System.out.println();
		
		System.out.println("Area dos formatos: ");
		for(Formato x: formatos) {
			System.out.println(x.areaCalculo());
		}
		
		input.close();
	}

}
