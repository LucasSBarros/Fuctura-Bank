package models;

public class ContaCorrente extends Contas {

	private int id;
	private static int contador;

	public ContaCorrente(String nomeDaConta, String nomeDoTitular, double saldoDisponivel) {
		super(nomeDaConta, nomeDoTitular, saldoDisponivel);
		this.contador = contador++;
		this.id = contador;

	}

	public void sacarValores(double valor) {

		if (valor > 0 && valor <= getSaldoDisponivel()) {
			setSaldoDisponivel(getSaldoDisponivel() - valor);
			System.out.println("Saque realizado com sucesso!\n");
		} else if (valor > getSaldoDisponivel()) {
			System.out.println("Saldo insificiente, saque não realizado!\n");
		} else {
			System.out.println("Valor inválido, saque não realizado!\n");
		}

	}

	public void aplicarValores(ContaPoupanca contaPoupanca, ContaCorrente contaCorrente, double valor) {

		if (valor > 0 && contaCorrente.getSaldoDisponivel() >= valor) {

			contaPoupanca.setSaldoDisponivel(contaPoupanca.getSaldoDisponivel() + valor);
			contaCorrente.setSaldoDisponivel(contaCorrente.getSaldoDisponivel() - valor);

			System.out.println("Aplicação realizada com sucesso!\n");

		} else {

			System.out.println("Valor inválido, aplicação não realizada!\n");

		}

	}

	public int getId() {
		return id;
	}

	public static int getContador() {
		return contador;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void setContador(int contador) {
		ContaCorrente.contador = contador;
	}

}
