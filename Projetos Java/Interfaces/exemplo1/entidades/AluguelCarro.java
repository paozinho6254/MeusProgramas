package exemplo1.entidades;

import java.time.LocalDateTime;

public class AluguelCarro {

	private LocalDateTime retirada;
	private LocalDateTime retorno;
	private Carro modelo;

	private Fatura fatura;
	
	public AluguelCarro() {
		
	}

	/*
	 * fatura na lógica do programa ainda não existe, por isso não
	 * adicionei no construtor, assim não crio algo que nem existe
	 */
	public AluguelCarro(LocalDateTime retirada, LocalDateTime retorno, Carro modelo) {
		this.retirada = retirada;
		this.retorno = retorno;
		this.modelo = modelo;
	}

	public LocalDateTime getRetirada() {
		return retirada;
	}

	public void setRetirada(LocalDateTime retirada) {
		this.retirada = retirada;
	}

	public LocalDateTime getRetorno() {
		return retorno;
	}

	public void setRetorno(LocalDateTime retorno) {
		this.retorno = retorno;
	}

	public Carro getModelo() {
		return modelo;
	}

	public void setModelo(Carro modelo) {
		this.modelo = modelo;
	}

	public Fatura getFatura() {
		return fatura;
	}
	
	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}	
	
}
