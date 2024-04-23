package models;

public class ContaPoupanca extends Contas {

	private int id;
	private static int contador;

	public ContaPoupanca(String nomeDaConta, String nomeDoTitular, double saldoDisponivel) {
		super(nomeDaConta, nomeDoTitular, saldoDisponivel);
		this.contador = contador++;
		this.id = contador;

	}

	public void resgatarValores(ContaPoupanca contaPoupanca, ContaCorrente contaCorrente, double valor) {

		if (valor > 0 && contaCorrente.getSaldoDisponivel() >= valor) {

			contaCorrente.setSaldoDisponivel(contaCorrente.getSaldoDisponivel() + valor);
			contaPoupanca.setSaldoDisponivel(contaPoupanca.getSaldoDisponivel() - valor);

			System.out.println("Resgate realizado com sucesso!\\n");

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
		ContaPoupanca.contador = contador;
	}

}
