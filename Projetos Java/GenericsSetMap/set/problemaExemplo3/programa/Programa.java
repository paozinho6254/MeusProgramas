package problemaExemplo3.programa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import problemaExemplo3.entidades.Usuario;

public class Programa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Set<Usuario> set = new HashSet<>();
		
		
		for(int i = 0; i < 3; i++) {
			System.out.print("Quantidade de alunos no curso "+(i+1)+": ");
			int qtdAlunos = input.nextInt();
			for(int j = 0; j < qtdAlunos; j++) {
				int nmrAluno = input.nextInt();
				
				set.add(new Usuario(nmrAluno));
			}
		}
		
		System.out.println("Número total de alunos: "+set.size());
		
		
	}
	
}
