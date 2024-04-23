package models;

public class ContaCorrente extends Contas {

	private int numero;

	public ContaCorrente(int numero, String nomeDaConta, String nomeDoTitular, double saldoDisponivel) {
		super(nomeDaConta, nomeDoTitular, saldoDisponivel);
		this.numero = numero;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
