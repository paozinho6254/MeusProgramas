package programas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import entidades.Cliente;
import entidades.Order;
import entidades.OrderItem;
import entidades.OrderStatus;
import entidades.Produto;

public class ExercicioFixacao {

	public static void main(String[] args) {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Scanner input = new Scanner(System.in);

		System.out.println("Informações do cliente: ");

		System.out.print("Nome: ");
		String nome = input.nextLine();

		System.out.println("Email: ");
		String email = input.nextLine();

		System.out.println("Data de nascimento (DD/MM/YYYY): ");
		int dia, mes, ano;

		System.out.println("Dia: ");
		dia = input.nextInt();

		System.out.println("Mês");
		mes = input.nextInt();

		System.out.println("Ano: ");
		ano = input.nextInt();

		LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
		dataNascimento.format(fmt1);

		Cliente cliente = new Cliente(nome, email, dataNascimento);

		input.nextLine();
		System.out.print("status do pedido: " + "\n1 - Esperando Pagamento" + "\n2 - Processando"
				+ "\n3 - Saiu para entrega" + "\n4 - Entregue" + "\n: ");
		int numStatus = input.nextInt();
		String statusPedido = null;
		switch (numStatus) {
		case 1:
			statusPedido = "PENDING_PAYMENT";
			break;
		case 2:
			statusPedido = "PROCESSING";
			break;
		case 3:
			statusPedido = "SHIPPED";
			break;
		case 4:
			statusPedido = "DELIVERED";
		}
		
		LocalDateTime momento = LocalDateTime.now();

		Order pedido = new Order(cliente ,momento, OrderStatus.valueOf(statusPedido));
		
		System.out.print("Quantos itens serão pedidos: ");
		int qtdItens = input.nextInt();
		
		for (int i = 0; i < qtdItens; i++) {
			input.nextLine();
			System.out.println("Insira as informações do item #" + (i + 1) + ":");
			System.out.print("Nome do produto: ");
			String nomeProduto = input.nextLine();
			System.out.println("Preço do produto: ");
			double precoProduto = input.nextDouble();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			System.out.println("Quantidade: ");
			int qtdProduto = input.nextInt();
			
			OrderItem pedidodeitem = new OrderItem(qtdProduto, precoProduto, produto);
			
			pedido.addPedidos(pedidodeitem);
		}


		System.out.println("Sumario do pedido: ");
		System.out.println(pedido);
		
		input.close();

	}
}
