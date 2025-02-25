package exemplo4;

import java.io.File;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Escreva um caminho de pasta: ");
		String caminhoPasta = input.nextLine();
		
		File caminho = new File(caminhoPasta);
		
		File[] pastas = caminho.listFiles(File::isDirectory);
		
		System.out.println("Pastas: ");
		for(File pasta : pastas) {
			System.out.println(pasta);
		}
		
		
		File[] arquivos = caminho.listFiles(File::isFile);
		
		System.out.println("Arquivos: ");
		for(File arquivo : arquivos) {
			System.out.println(arquivo);
		}
		
		boolean sucesso = new File(caminhoPasta + "\\Pasta").mkdir();
		System.out.println("Diretório criado com sucesso: "+sucesso);
		
		
		input.close();

	}

}
