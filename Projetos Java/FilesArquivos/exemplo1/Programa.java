package exemplo1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		File file = new File("C:\\temp\\in.txt");
		Scanner input = null;
		
		/*
		 * Como o Scanner esta nulo, vamos instanciar ele
		 * mas ao instanciar pode haver algumas exceções
		 * com isso coloque em um bloco try para tratar possiveis
		 * exceções
		 */
		
		try {
			input = new Scanner(file);
			//hasNextLine é para testar se ainda há uma nova linha no arquivo
			while (input.hasNextLine()) {
				//se sim ele le a linha do arquivo
				System.out.println(input.nextLine());
				
			}
			input.close();
		}
		catch (IOException e) {
		System.out.println("Erro: "+e.getMessage());
		}
		//uma boa pratica é finalizar o input no finally
		finally {
			if(input != null) {
				input.close();
			}

		}
			
	
	}

}
