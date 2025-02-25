package exemplo2.programa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import exemplo2.entidades.Produto;
import exemplo2.servicos.ServicoCalculo;

public class Programa {

	public static void main(String[] args) {
		
		//Aqui determino o caminho do arquivo
		String caminho = "C:\\Temp\\ListaProdutos.txt";
		
		//instanceio uma lista de tipo produto e guardar produtos
		List<Produto> produtos = new ArrayList<>();
		
		//Abro try com br e fr para ler as linhas no arquivo (caminho, por que dá no arquivo
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			//Comece a ler a primeira linha
			String linha = br.readLine();
			//enquanto o que tiver na linha for diferente de nulo faça
			while(linha != null) {
				//vetor String para separar quando der virgula e separar os dois itens com split
				String[] fields = linha.split(",");
				//na primeira divisa tem o nome
				String nome = fields[0];
				//depois da vírgula o preco(só numero)
				Double preco = Double.parseDouble(fields[1]);
				//lista adicionas os produtos como um objeto
				produtos.add(new Produto(nome, preco));
				//pula para a proxima linha e repete até ter uma linha nula
				linha = br.readLine();
			}
			
			//Lista os produtos presentes na lista
			for(Produto produto: produtos) {
				System.out.println(produto);
			}
			
			//x de tipo produto recebe o objeto do produto mais caro (Classe serviço)
			Produto x = ServicoCalculo.max(produtos);
			
			System.out.println("Produto mais caro: "+ x);
		}
		//catch pra qualquer erro
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}
}
