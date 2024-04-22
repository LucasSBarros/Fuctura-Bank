package views;

import java.util.Scanner;

import controller.GeradorDeContas;

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
			
			System.out.println("Informe o ID da sua conta corrente: ");

			int id = sc.nextInt();

			contaCorrente(id);

		} else if (opcao == 2) {
			
			System.out.println("Informe o ID da sua conta poupanca: ");

			int id = sc.nextInt();

			contaPoupanca(id);

		} else if (opcao == 3) {

			interfaceCliente();

		} else {

			System.out.println("Opcao inválida, tente novamente!\n");
			SelecionarTipoDeConta();

		}

	}

	public void contaCorrente(int id) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite uma das seguintes opções:\n" + "Opção 1: Exibir dados da Conta\n"
				+ "Opção 2: Exibir saldo\n" + "Opção 3: Depositar\n" + "Opção 4: Sacar\n" + "opção 5: Aplicar\n"
				+ "Opção 6: Voltar para o menu anterior\n");

		int opcao = sc.nextInt();

		if (opcao == 1) {

			System.out.println("Dados do cliente: \n");

			GeradorDeContas.getCcs().get(id).exibirDados();

			contaCorrente(id);

		} else if (opcao == 2) {

			System.out.println("Saldo da conta corrente do cliente: \n");

			GeradorDeContas.getCcs().get(id).exibirSaldoDasContas();

			contaCorrente(id);

		} else if (opcao == 3) {

			System.out.println("Informe o valor que deseja depositar: ");

			double valor = sc.nextDouble();

			GeradorDeContas.getCcs().get(id).depositar(valor);

			contaCorrente(id);

		} else if (opcao == 4) {

			System.out.println("Informe o valor que deseja sacar: ");

			double valor = sc.nextDouble();

			GeradorDeContas.getCcs().get(id).sacarValores(valor);

			contaCorrente(id);

		} else if (opcao == 5) {

			System.out.println("Informe o valor que deseja aplicar: ");

			double valor = sc.nextDouble();

			GeradorDeContas.getCcs().get(id).aplicarValores(GeradorDeContas.getCps().get(id),
					GeradorDeContas.getCcs().get(id), valor);

			contaCorrente(id);

		} else if (opcao == 6) {

			interfaceCliente();

		} else {

			System.out.println("Opcao inválida!\n");
			contaCorrente(id);

		}

	}

	public void contaPoupanca(int id) {

		Scanner sc = new Scanner(System.in);

		System.out.println(
				"Digite uma das seguintes opções:\n" + "Opção 1: Exibir dados da Conta\n" + "Opção 2: Exibir saldo\n"
						+ "Opção 3: Depositar\n" + "Opção 4: Resgatar\n" + "Opção 5: Voltar para o menu anterior\n");

		int opcao = sc.nextInt();

		if (opcao == 1) {

			System.out.println("Dados do cliente: \n");

			GeradorDeContas.getCps().get(id).exibirDados();

			contaPoupanca(id);

		} else if (opcao == 2) {

			System.out.println("Saldo da conta poupança do cliente: \n");

			GeradorDeContas.getCps().get(id).exibirSaldoDasContas();

			contaPoupanca(id);

		} else if (opcao == 3) {

			System.out.println("Informe o valor que deseja depositar: ");

			double valor = sc.nextDouble();

			GeradorDeContas.getCps().get(id).depositar(valor);

			contaPoupanca(id);

		} else if (opcao == 4) {

			System.out.println("Informe o valor que deseja resgatar: ");

			double valor = sc.nextDouble();

			GeradorDeContas.getCps().get(id).resgatarValores(GeradorDeContas.getCps().get(id),
					GeradorDeContas.getCcs().get(id), valor);

			contaPoupanca(id);

		} else if (opcao == 5) {

			interfaceCliente();

		} else {

			System.out.println("Opcao inválida!\n");
			contaPoupanca(id);

		}

	}

}
