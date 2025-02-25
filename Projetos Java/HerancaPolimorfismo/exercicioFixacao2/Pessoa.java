package exercicioFixacao2;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

	private String nome;
	private Double rendaAnual;
	private List<Pessoa> listaPessoas = new ArrayList<>();
	
	public Pessoa() {
		
	}

	public Pessoa(String nome, Double rendaAnual) {
		super();
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(Double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	
	public void addPessoa(Pessoa pessoa) {
		listaPessoas.add(pessoa);
	}
	
	public abstract Double imposto();
	
	public String toString() {
		return nome
				+ " : "
				+ imposto();
	}
	
}
