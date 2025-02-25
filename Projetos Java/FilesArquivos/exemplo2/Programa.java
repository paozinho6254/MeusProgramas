package exemplo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Programa {

	public static void main(String[] args) {

		String caminho = "c:\\temp\\in.txt";

		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			
			// Programa irá ler as linhas do arquivo txt
			String linha = br.readLine();

			// aqui ordena que ele leia todas, até que seja nula
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		} 
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

}
