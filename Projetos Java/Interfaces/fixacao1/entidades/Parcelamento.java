package fixacao1.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcelamento {
	
	private LocalDate data;
	private Double valor;

	public Parcelamento() {
		
	}
	
	public Parcelamento(LocalDate data, Double valor) {
		this.data = data;
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data + " - " + String.format("%.2f", valor);
	}

	
	
}
