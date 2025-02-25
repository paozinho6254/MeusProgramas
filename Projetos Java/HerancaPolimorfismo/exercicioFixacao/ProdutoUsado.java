package exercicioFixacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoUsado extends Produto {
	
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	
	private LocalDate dataManufatura;
	
	public ProdutoUsado() {
		
	}

	public ProdutoUsado(String nome, Double price, LocalDate dataManufatura) {
		super(nome, price);
		this.dataManufatura = dataManufatura;
	}

	public LocalDate getDataManufatura() {
		return dataManufatura;
	}

	public void setDataManufatura(LocalDate dataManufatura) {
		this.dataManufatura = dataManufatura;
	}
	
	public String toString() {
		return getNome()
				+ " (usado) $ "
				+ getPreco()
				+ " (Data de produção: "
				+ dataManufatura.format(fmt1)	
				+ ")";
	}
	
}
