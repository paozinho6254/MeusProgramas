package exemplo3.programa;

import java.util.Scanner;

import exemplo3.entidades.BiDispositivo;
import exemplo3.entidades.ConcreteImpressora;
import exemplo3.entidades.ConcreteLeitor;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Conteudos de Impressora:");
		ConcreteImpressora p = new ConcreteImpressora("1000");
		p.processarDoc("Eu po");
		p.print("Eu Meu");
		
		System.out.println();
		System.out.println("Conteudos de Leitor: ");
		ConcreteLeitor l = new ConcreteLeitor("2000");
		l.processarDoc("Contendo");
		System.out.println("Conteudo do conteudo: "+l.scan());
		
		System.out.println();
		System.out.println("Conteudos de Bidispositivo: ");
		BiDispositivo dispositivo = new BiDispositivo("213");
		dispositivo.processarDoc("Documento");
		dispositivo.print("Top");
		System.out.println("Conteudo do ComboConteudo: "+dispositivo.scan());
		
		input.close();
	}

}
