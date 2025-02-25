package exemplo3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Programa {

	public static void main(String[] args) {
		
		String[] linhas = new String[] { "Não vale ", "tentar ser ", "programador" , "mesmo que eu tente"};
		
		String caminho = "C:\\temp\\out.txt";
		//Acrescenta ao que já tinha com o true
		//try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
			for(String line: linhas) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
