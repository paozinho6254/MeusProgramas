package exemplo1;

public class Programa {

	public static void main(String[] args) {
		
		ContaComum conta = new ContaComum(1800, "Pão", 0.0);
		ContaEmpresa contaEmpresa = new ContaEmpresa(1922, "Borabill", 0.0, 500.0);
		
		//Upcasting
		//O motivo por não dar é pelo fato de que a contaEmpresa é uma "conta"
		ContaComum acc1 = contaEmpresa;
		//Vai dar certo por empresa ainda é uma conta
		ContaComum acc2 = new ContaEmpresa(2020, "Receba", 0.0, 500.0);
		ContaComum acc3 = new ContaPoupança(1004, "Anna", 0.0, 0.1);
		
		//downCasting
		/*ContaEmpresa acc4 = acc2 vai dar erro pois não da para conveter de
		 * contaComum para uma contaEmpresa.
		 * o que é acontece é que a contaEmpresa é uma conta, por isso é possivel criar 
		 * com base conta para uma de empresa com o complemento, mas não uma contaEmpresa 
		 * com uma comum, pois a comum tem menos elementos/variaveis do que sua sub
		 * 
		 * Por isso usamos este (ContaEmpresa), que é para converte acc2 (ContaComum)
		 * para um tipo ContaEmpresa
		 */
		ContaEmpresa acc4 = (ContaEmpresa)acc2;
		acc4.emprestimo(100.0);
		
		//Nota se eu quiser fazer um emprestimo com acc2 não é possivel pois é uma
		//contaComum
		
		//tome cuidado, acc3 é um tipo contaComum porém criada como ContaPoupança
		//e como contaEmpresa e Poupança são subclasses e de elementos diferentes
		//vai dar erro no programa, mas o compilador não sabe, por isso o código
		//não aparenta erro
		//ContaEmpresa acc5 = (ContaEmpresa)acc3;
		
		//"if" se o que tiver na variavel acc3, for um objeto que seja instancia de 
		//ContaEmpresa
		if(acc3 instanceof ContaEmpresa) {
			ContaEmpresa acc5 = (ContaEmpresa)acc3;
			acc5.emprestimo(300.0);
			System.out.println("Pobre!");
		}
		
		if(acc3 instanceof ContaPoupança) {
			ContaPoupança acc5 = (ContaPoupança)acc3;
			acc5.updateSaldo();
			System.out.println("Poupou dinheiro!");
		}
		
		/*Mas o que foi que aconteceu em cima ao rodar o programa?
		 * o primeiro if falhou pois não é instancia de ContaEmpresa
		 * ou seja, não era compativel com este tipo (acc3 é contaPoupança)
		 * enquanto o segundo if que é verificar se tem instancia em cotnaPoupança
		 * possui sim, então o programa escreve poupou dinheiro
		 */
		
		//contaComum possui taxa.
		ContaComum acc6 = new ContaComum(2000, "Bruh", 1000.0);
		acc6.saque(100.0);
		System.out.println(acc6.saldo);
		
		//ContaPoupança não
		ContaComum acc7 = new ContaPoupança(1200, "bob", 1000.0, 0.0);
		acc7.saque(100.0);
		System.out.println(acc7.saldo);
		
		//Conta Empresa com super()
		//Por que saiu 893 e não 898? simples, taxa da super/contaComum
		ContaComum acc8 = new ContaEmpresa(123, "Receba", 1000.0, 0.0);
		acc8.saque(100.0);
		System.out.println(acc8.saldo);
		
	}

}
