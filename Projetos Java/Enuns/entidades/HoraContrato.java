package entidades;

import java.time.LocalDate;

public class HoraContrato {

	private LocalDate data;
	private Double valorHora;
	private Integer horas;
	
	public HoraContrato() {
		
	}

	public HoraContrato(LocalDate data, Double valorHora, Integer horas) {
		this.data = data;
		this.valorHora = valorHora;
		this.horas = horas;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public double valorTotal() {
		return horas * valorHora;
	}
	
	
}
