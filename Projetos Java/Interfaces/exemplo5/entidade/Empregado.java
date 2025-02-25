package exemplo5.entidade;

public class Empregado implements Comparable<Empregado>{
	
	private String nome;
	private Double salario;
	
	public Empregado() {
		
	}

	public Empregado(String nome, Double salario) {
		this.nome = nome;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public int compareTo(Empregado outro) {
		return salario.compareTo(outro.getSalario());
	}
	
}
