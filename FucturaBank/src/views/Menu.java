package views;

import java.util.List;
import java.util.Scanner;

import controller.GeradorDeContas;
import models.ContaCorrente;
import models.ContaPoupanca;

public class Menu {

	GeradorDeContas gc = new GeradorDeContas();

	public void interfaceCliente() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Bem vindo ao FucturaBank!");

		System.out.println("Digite uma das seguintes opções:\n" + "Opção 1: Abrir uma Conta\n"
				+ "Opção 2: Acessar a sua conta\n" + "Opção 3: Sair\n");

		int opcao = sc.nextInt();

		if (opcao == 1) {

			MenuCriarConta();

		} else if (opcao == 2) {

			SelecionarTipoDeConta();

		} else if (opcao == 3) {

			System.out.println("Encerramento ...");

		}

	}

	public void MenuCriarConta() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite uma das seguintes opções:\n" + "Opção 1: Abrir uma Conta Corrente\n"
				+ "Opção 2: Abrir uma Conta Poupanca\n" + "Opção 3: Voltar para o menu anterior\n");

		int opcao = sc.nextInt();

		if (opcao == 1 || opcao == 2) {

			GeradorDeContas.criarConta(opcao);

			MenuCriarConta();

		} else if (opcao == 3) {

			interfaceCliente();

		} else {

			System.out.println("Opçao inválida, tente novamente.\n");
			MenuCriarConta();

		}

	}

	public void SelecionarTipoDeConta() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite uma das seguintes opções:\n" + "Opção 1: Conta Corrente\n"
				+ "Opção 2: Conta Poupanca\n" + "Opção 3: Sair\n");

		int opcao = sc.nextInt();

		if (opcao == 1) {

			System.out.println("Informe o número da sua conta corrente: ");

			int numero = sc.nextInt();

			contaCorrente(numero);

		} else if (opcao == 2) {

			System.out.println("Informe o número da sua conta poupanca: ");

			int numero = sc.nextInt();

			contaPoupanca(numero);

		} else if (opcao == 3) {

			interfaceCliente();

		} else {

			System.out.println("Opcao inválida, tente novamente!\n");
			SelecionarTipoDeConta();

		}

	}

	public void contaCorrente(int numero) {

		List<ContaCorrente> contaCorrente = GeradorDeContas.getCcs();
		List<ContaPoupanca> contaPoupanca = GeradorDeContas.getCps();

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite uma das seguintes opções:\n" + "Opção 1: Exibir dados da Conta\n"
				+ "Opção 2: Exibir saldo\n" + "Opção 3: Depositar\n" + "Opção 4: Sacar\n" + "opção 5: Aplicar\n"
				+ "Opção 6: Voltar para o menu anterior\n");

		int opcao = sc.nextInt();

		if (opcao == 1) {

			System.out.println("Dados do cliente: \n");

			for (ContaCorrente cc : contaCorrente) {

				if (numero == cc.getNumero()) {
					cc.exibirDados();
				}

			}

			contaCorrente(numero);

		} else if (opcao == 2) {

			System.out.println("Saldo da conta corrente do cliente: \n");

			for (ContaCorrente cc : contaCorrente) {

				if (numero == cc.getNumero()) {
					cc.exibirSaldoDasContas();
				}

			}

			contaCorrente(numero);

		} else if (opcao == 3) {

			System.out.println("Informe o valor que deseja depositar: ");

			double valor = sc.nextDouble();

			for (ContaCorrente cc : contaCorrente) {

				if (numero == cc.getNumero()) {
					cc.depositar(valor);
				}

			}

			contaCorrente(numero);

		} else if (opcao == 4) {

			System.out.println("Informe o valor que deseja sacar: ");

			double valor = sc.nextDouble();

			for (ContaCorrente cc : contaCorrente) {

				if (numero == cc.getNumero()) {
					cc.sacarValores(valor);
					;
				}

			}

			contaCorrente(numero);

		} else if (opcao == 5) {

			System.out.println("Informe o valor que deseja aplicar: ");

			double valor = sc.nextDouble();

			System.out.println("Informe a Conta Poupança que deseja aplicar: ");

			int numeroContaPoupanca = sc.nextInt();

			for (ContaCorrente cc : contaCorrente) {

				if (numero == cc.getNumero()) {

					for (ContaPoupanca cp : contaPoupanca) {

						if (numeroContaPoupanca == cp.getNumero()) {

							cc.aplicarValores(cp, cc, valor);

						}

					}

				}

			}

			contaCorrente(numero);

		} else if (opcao == 6) {

			interfaceCliente();

		} else {

			System.out.println("Opcao inválida!\n");

			contaCorrente(numero);

		}

	}

	public void contaPoupanca(int numero) {

		List<ContaCorrente> contaCorrente = GeradorDeContas.getCcs();
		List<ContaPoupanca> contaPoupanca = GeradorDeContas.getCps();

		Scanner sc = new Scanner(System.in);

		System.out.println(
				"Digite uma das seguintes opções:\n" + "Opção 1: Exibir dados da Conta\n" + "Opção 2: Exibir saldo\n"
						+ "Opção 3: Depositar\n" + "Opção 4: Resgatar\n" + "Opção 5: Voltar para o menu anterior\n");

		int opcao = sc.nextInt();

		if (opcao == 1) {

			System.out.println("Dados do cliente: \n");

			for (ContaPoupanca cp : contaPoupanca) {

				if (numero == cp.getNumero()) {
					cp.exibirDados();
				}

			}

			contaPoupanca(numero);

		} else if (opcao == 2) {

			System.out.println("Saldo da conta poupança do cliente: \n");

			for (ContaPoupanca cp : contaPoupanca) {

				if (numero == cp.getNumero()) {
					cp.exibirSaldoDasContas();
				}

			}

			contaPoupanca(numero);

		} else if (opcao == 3) {

			System.out.println("Informe o valor que deseja depositar: ");

			double valor = sc.nextDouble();

			for (ContaPoupanca cp : contaPoupanca) {

				if (numero == cp.getNumero()) {
					cp.depositar(valor);
				}
			}

			contaPoupanca(numero);

		} else if (opcao == 4) {

			System.out.println("Informe o valor que deseja resgatar: ");

			double valor = sc.nextDouble();

			System.out.println("Informe a Conta Conrrente que deseja resgatar: ");

			int numeroContaCorrente = sc.nextInt();

			for (ContaPoupanca cp : contaPoupanca) {

				if (numero == cp.getNumero()) {

					for (ContaCorrente cc : contaCorrente) {

						if (numeroContaCorrente == cc.getNumero()) {

							cp.resgatarValores(cp, cc, valor);

						}

					}

				}

			}

			contaPoupanca(numero);

		} else if (opcao == 5) {

			interfaceCliente();

		} else {

			System.out.println("Opcao inválida!\n");
			contaPoupanca(numero);

		}

	}

}
