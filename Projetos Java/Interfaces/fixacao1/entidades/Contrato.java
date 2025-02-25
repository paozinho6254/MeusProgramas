package fixacao1.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {
	
	private LocalDate data;
	private Integer numero;
	private Double valorTotal;

	List<Parcelamento> parcelas = new ArrayList<>();
	
	public Contrato(Integer numero, LocalDate data, Double valorTotal) {
		this.numero = numero;
		this.data = data;
		this.valorTotal = valorTotal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Parcelamento> getParcelas() {
		return parcelas;
	}
	
	public void addParcela(Parcelamento parcela) {
		parcelas.add(parcela);
	}
	
}
