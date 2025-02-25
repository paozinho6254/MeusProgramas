package exemplo1;

import java.util.ArrayList;
import java.util.List;

public class Programa1 {

	public static void main(String[] args) {
			
		
		List<ContaComum> contas = new ArrayList<>();

		contas.add(new ContaPoupança(1002, "bob", 1000.0, 0.01));
		contas.add(new ContaEmpresa(2000, "receba", 1000.0, 200.0));
		contas.add(new ContaPoupança(1022, "judas", 1000.0, 0.01));
		contas.add(new ContaEmpresa(2030, "bebe pelé", 1000.0, 200.0));
		contas.add(new ContaPoupança(1202, "top", 1000.0, 0.01));
		contas.add(new ContaEmpresa(2001, "bill", 1000.0, 200.0));
				
		double soma = 0.0;
		for(ContaComum x: contas) {
			System.out.println("Conta = "+x.getSaldo());
			x.saldo += 10;
			System.out.println(x.getSaldo());
			soma += x.saldo;
		}
		System.out.println(soma);
	}

}
