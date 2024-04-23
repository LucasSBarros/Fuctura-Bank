package models;

public class ContaPoupanca extends Contas {

	private int numero;

	public ContaPoupanca(int numero, String nomeDaConta, String nomeDoTitular, double saldoDisponivel) {
		super(nomeDaConta, nomeDoTitular, saldoDisponivel);
		this.numero = numero;

	}

	public void resgatarValores(ContaPoupanca contaPoupanca, ContaCorrente contaCorrente, double valor) {

		if (valor > 0 && contaPoupanca.getSaldoDisponivel() >= valor) {

			contaPoupanca.setSaldoDisponivel(contaPoupanca.getSaldoDisponivel() - valor);
			contaCorrente.setSaldoDisponivel(contaCorrente.getSaldoDisponivel() + valor);

			System.out.println("Resgate realizado com sucesso!\\n");

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
