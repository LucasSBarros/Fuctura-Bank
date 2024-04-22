package models;

public abstract class Contas {

	// Atributos
	private String nomeDaConta;
	private String nomeDoTitular;
	private double saldoDisponivel;

	// Construtor

	public Contas(String nomeDaConta, String nomeDoTitular, double saldoDisponivel) {
		this.nomeDaConta = nomeDaConta;
		this.nomeDoTitular = nomeDoTitular;
		this.saldoDisponivel = saldoDisponivel;
	}

	// Métodos

	public void exibirDados() {
		System.out.println("Nome da conta: " + nomeDaConta);
		System.out.println("Nome do titular: " + nomeDoTitular);
	}

	public double depositar(double valor) {

		if (valor > 0) {
			saldoDisponivel += valor;
			System.out.println("Depósito realizado com sucesso!\n");
		} else {
			System.out.println("Valor incorreto, depósito não realizado!\n");
		}

		return saldoDisponivel;

	}

	public void exibirSaldoDasContas() {

		System.out.println("R$ " + saldoDisponivel);

	}

	// Métodos acessores
	public String getNomeDaConta() {
		return nomeDaConta;
	}

	public String getNomeDoTitular() {
		return nomeDoTitular;
	}

	public double getSaldoDisponivel() {
		return saldoDisponivel;
	}

	public void setNomeDaConta(String nomeDaConta) {
		this.nomeDaConta = nomeDaConta;
	}

	public void setNomeDoTitular(String nomeDoTitular) {
		this.nomeDoTitular = nomeDoTitular;
	}

	public void setSaldoDisponivel(double saldoDisponivel) {
		this.saldoDisponivel = saldoDisponivel;
	}

}
