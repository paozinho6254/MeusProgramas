package exemplo4.programa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programa {

	public static void main(String[] args) {

		List<String> lista = new ArrayList<>();
		File caminho = new File("C:\\Temp\\ListaPessoas.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			//br.readLine() le a linha
			String name = br.readLine();
			//Enquanto o que conter na linha for diferente de nulo faça tal
			while (name != null) {
				lista.add(name);
				//le e pula para próxima linha
				name = br.readLine();
			}
			//Ordena a lista em ordem alfabética
			Collections.sort(lista);
			for (String s : lista) {
				System.out.println(s);
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
