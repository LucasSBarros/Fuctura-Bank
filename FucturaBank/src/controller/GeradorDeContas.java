package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import models.ContaCorrente;
import models.ContaPoupanca;

public class GeradorDeContas {

	static Random random = new Random();

	private static List<ContaCorrente> ccs;
	private static List<ContaPoupanca> cps;

	public GeradorDeContas() {
		GeradorDeContas.ccs = new ArrayList<>();
		GeradorDeContas.cps = new ArrayList<>();
	}

	public static void criarConta(int opcao) {

		Scanner sc = new Scanner(System.in);

		if (opcao == 1) {

			System.out.println("Informe o nome da conta corrente: ");
			String nomeDaConta = sc.nextLine();

			System.out.println("Informe o seu nome: ");
			String nomeDoCliente = sc.nextLine();

			System.out.println("Deseja realizar um depósito inicial? (S/N)");
			String resposta = sc.nextLine();

			if (resposta.equalsIgnoreCase("s")) {

				System.out.println("Qual o valor do depósito inicial? ");
				double valor = sc.nextDouble();

				int numeroRandomico = random.nextInt(1000);

				ccs.add(new ContaCorrente(numeroRandomico, nomeDaConta, nomeDoCliente, valor));

				System.out.println("Conta corrente criada com sucesso!\n" + "\nID da Conta: " + numeroRandomico + "\n");

			} else if (resposta.equalsIgnoreCase("n")) {

				int numeroRandomico = random.nextInt(1000);

				ccs.add(new ContaCorrente(numeroRandomico, nomeDaConta, nomeDoCliente, 0.0));

				System.out.println("Conta corrente criada com sucesso!\n" + "\nID da Conta: " + numeroRandomico + "\n");

			} else {
				System.out.println("Opção inválida.\n");
			}

		}
		if (opcao == 2) {

			System.out.println("Informe o nome da conta poupança: ");
			String nomeDaConta = sc.nextLine();

			System.out.println("Informe o seu nome: ");
			String nomeDoCliente = sc.nextLine();

			System.out.println("Deseja realizar um depósito inicial? (S/N)");
			String resposta = sc.nextLine();

			if (resposta.equalsIgnoreCase("s")) {

				System.out.println("Qual o valor do depósito inicial? ");
				double valor = sc.nextDouble();

				int numeroRandomico = random.nextInt(1000);

				cps.add(new ContaPoupanca(numeroRandomico, nomeDaConta, nomeDoCliente, valor));

				System.out.println("Conta poupanca criada com sucesso!\n" + "\nID da Conta: " + numeroRandomico + "\n");

			} else if (resposta.equalsIgnoreCase("n")) {

				int numeroRandomico = random.nextInt(1000);

				cps.add(new ContaPoupanca(numeroRandomico, nomeDaConta, nomeDoCliente, 0.0));

				System.out.println("Conta poupanca criada com sucesso!\n" + "\nID da Conta: " + numeroRandomico + "\n");

			} else {
				System.out.println("Opção inválida.\n");
			}

		}

	}

	public static List<ContaCorrente> getCcs() {
		return ccs;
	}

	public static List<ContaPoupanca> getCps() {
		return cps;
	}

	public static void setCcs(List<ContaCorrente> ccs) {
		GeradorDeContas.ccs = ccs;
	}

	public static void setCps(List<ContaPoupanca> cps) {
		GeradorDeContas.cps = cps;
	}

}
