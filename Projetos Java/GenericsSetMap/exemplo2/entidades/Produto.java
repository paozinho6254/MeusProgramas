package exemplo2.entidades;

//implemente Comparable para que produto possa ser comparado
public class Produto implements Comparable<Produto> {
	
	private String nome;
	private Double preco;

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

	
	
	@Override
	public String toString() {
		return nome + ", R$" + preco;
	}

	//para poder comparar os objetos entre si (É como se habilitasse)
	@Override
	public int compareTo(Produto other) {
		return preco.compareTo(other.getPreco());
	}
	
}
