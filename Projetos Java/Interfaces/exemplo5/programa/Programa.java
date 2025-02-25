package exemplo5.programa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exemplo5.entidade.Empregado;

public class Programa {

	public static void main(String[] args) {
		
		List<Empregado> funcionarios = new ArrayList<>();
		File caminho = new File("C:\\temp\\ListaFuncionarios.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			
			String funcionarioCsv = br.readLine();
			
			while (funcionarioCsv != null) {
				
				String[] fields = funcionarioCsv.split(",");

				funcionarios.add(new Empregado(fields[0], Double.parseDouble(fields[1])));
				funcionarioCsv = br.readLine();
			}
			
			Collections.sort(funcionarios);
			for (Empregado emp : funcionarios) {
				System.out.println(emp.getNome() + ", " + emp.getSalario());
			}
		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
	}

}
