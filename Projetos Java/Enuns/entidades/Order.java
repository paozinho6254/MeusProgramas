package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDateTime momento;
	private OrderStatus status;
	private Cliente cliente;
	private List<OrderItem> pedidos = new ArrayList<>();
	
	public Order() {
	}

	public Order(Cliente cliente,LocalDateTime momento, OrderStatus status) {
		this.cliente = cliente;
		this.momento = momento;
		this.status = status;
	}

	
	public LocalDateTime getmomento() {
		return momento;
	}

	public void setmomento(LocalDateTime momento) {
		this.momento = momento;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addPedidos(OrderItem pedido) {
		pedidos.add(pedido);
	}
	
	public void removePedidos(OrderItem pedido) {
		pedidos.remove(pedido);
	}
	
	public double total() {
		double sum = 0.0;
		for (OrderItem item : pedidos) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(fmt1.format(momento) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(cliente + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : pedidos) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
}
