package exercicio1;

public class DominioExcecao extends RuntimeException {

	private static final long serialVersionUID = 1l;
	
	//Para que serve a msg no construtor?
	/* msg é a mensagem que deixamos de erro nos métodos ou tratamentos de execeções nas classes
	 * (Olhar a classe Reserva para entender)
	 */
	public DominioExcecao(String msg) {
		super(msg);
	}
	
}
