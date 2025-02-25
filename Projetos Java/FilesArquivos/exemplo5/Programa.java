package exemplo5;

import java.io.File;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insira o caminho do arquivo: ");
		String caminhoArquivo = input.nextLine();
		
		File caminho = new File(caminhoArquivo);
		
		System.out.println("Nome do arquivo = " + caminho.getName());
		System.out.println("Parente do arquivo = " + caminho.getParent());
		System.out.println("Caminho do arquivo = " + caminho.getPath());
		
		input.close();
	}
	
}
