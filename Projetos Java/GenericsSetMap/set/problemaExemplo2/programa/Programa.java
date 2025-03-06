package problemaExemplo2.programa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import problemaExemplo2.entidades.Usuario;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o local do doc: ");
		String caminhoString = input.next();
		
		//Abre o caminho que o usuário escreve
		File caminhoArquivo = new File(caminhoString);
		
		/*
		 * Faz o bufferedReader e FileReader seguir o caminho que o usuário inseriu
		 */
		try(BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))){
			//Cria lista HashSet de tipo Usuario
			Set<Usuario> set = new HashSet<>();

			//Conteúdos da linha 
			String linha = br.readLine();
			//Enquanto o que o programa ler na linha for diferente de nulo
			while(linha != null) {
				//seps vai ser usado para separar os elementos a cada espaço na linha do txt
				String[] seps = linha.split(" ");
				//Nome pega a primeira parte da linha
				String nome = seps[0];
				//horario traduz o texto para date com instant.parse
				Date horario = Date.from(Instant.parse(seps[1]));
				
				//adiciona na lista set um novo usuário
				set.add(new Usuario(nome, horario));
				
				//Linha pula para uma nova linha e le o conteúdo (Isso se tiver)
				linha = br.readLine();
				
			}
			
			//Aqui lista os usuário presentes na lista set
			for(Usuario x: set) {
				System.out.println(x);
			}
			
			//Imprime a quantidade de usuários, se os nomes forem iguais eles não contam
			System.out.println("Total de usuário: "+set.size());
			
			input.close();
			
		}
		
		//Exceção IO 
		catch (IOException e) {
			e.getMessage();
		}
		
	}

}
