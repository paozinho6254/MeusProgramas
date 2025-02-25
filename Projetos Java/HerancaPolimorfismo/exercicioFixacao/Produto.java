package exercicioFixacao;

import java.util.ArrayList;
import java.util.List;

public class Produto {

	private String nome;
	private Double preco;
	private List<Produto> produtos = new ArrayList<>();
	
	public Produto() {
		
	}

	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public String toString() {
		return getNome()
				+ " $ "
				+ getPreco();
	}
	
}	
