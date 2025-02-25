package exercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		List<Produto> produtos = new ArrayList<>();

		System.out.println("Insira o caminho do arquivo: ");
		String caminhoArquivo = input.nextLine();

		File caminho = new File(caminhoArquivo);

		String caminhoPasta = caminho.getParent();

		String arquivoAlvo = caminhoPasta + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

			String itemCsv = br.readLine();

			while (itemCsv != null) {

				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				produtos.add(new Produto(name, price, quantity));

				itemCsv = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoAlvo))) {

				for (Produto item : produtos) {
					bw.write(item.getNome() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}

				System.out.println(arquivoAlvo + " CREATED!");

			} 
			catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} 
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		input.close();
	}

}
