package set.exemplo4.entidades;

public class Produto implements Comparable<Produto>{

	private String name;
	private Double price;

	public Produto(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

	//Estou ordenando os nomes em ordem alfabética
	//o mesmo acontece se ordenarmos por preço
	@Override
	public int compareTo(Produto other) {
		return name.toUpperCase().compareTo(other.getName().toUpperCase());
	}

}
