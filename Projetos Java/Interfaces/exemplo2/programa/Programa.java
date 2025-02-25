package exemplo2.programa;

import exemplo2.entidades.Circulo;
import exemplo2.entidades.Retangulo;
import exemplo2.enuns.Cor;
import exemplo2.servicos.Forma;
import exemplo2.servicos.FormaAbstrata;

public class Programa {

	public static void main(String[] args) {
		
		FormaAbstrata f1 = new Circulo(Cor.VERMELHO, 5.0);
		FormaAbstrata f2 = new Retangulo(Cor.PRETO, 4.0 , 5.0);
		
		System.out.println("Cor do circulo: "+f1.getCor());
		System.out.println("Cor do Retangulo: "+f2.getCor());
		System.out.println("Area do circulo: "+f1.area());
		System.out.println("Area do retangulo: "+f2.area());
	}

}
