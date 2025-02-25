package exercicio1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numero;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numero, Date checkin, Date checkout) {
		if (!checkout.after(checkin)) {
			throw new DominioExcecao("As datas de checkout precisam ser depois do checkin!");
		}
		this.numero = numero;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duracao() {
		long duracao = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(duracao, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numero
				+ ", Checkin: "
				+ sdf.format(checkin)
				+ ", Checkout: "
				+ sdf.format(checkout)
				+ ", "
				+ duracao()
				+ " noite(s)";
	}

	public void upDatas(Date checkin, Date checkout) {
		
		Date agora = new Date();

		/*(DominioExcecao contexto)
		 * O dev deve colocar esta mensagem para quando
		 * quando o programa captura uma exceção.
		 */
		if (checkin.before(agora) || checkout.before(agora)) {
			throw new DominioExcecao("As datas informadas devem ser de dias futuros!");
		}
		if (!checkout.after(checkin)) {
			throw new DominioExcecao("As datas de checkout precisam ser depois do checkin!");
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
}
