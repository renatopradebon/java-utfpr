package br.integrador.cliente;

import java.rmi.RemoteException;
import java.text.DecimalFormat;

import javax.xml.rpc.ServiceException;

import br.integrador.cliente.indata.InData;
import br.integrador.implementacoes.BancarioServiceImplements;
import br.integrador.implementacoes.BancarioServiceImplementsServiceLocator;
import br.integrador.implementacoes.Exception;

public class ClienteIntegrador {

	private BancarioServiceImplementsServiceLocator acessor;
	private BancarioServiceImplements servico;
	private static InData in;

	public ClienteIntegrador() throws ServiceException {
		acessor = new BancarioServiceImplementsServiceLocator();
		servico = acessor.getBancarioServiceImplementsPort();

		// Entrada de dados
		in = new InData();
	}

	public void iniciaCliente() throws Exception, RemoteException {

		int opcao = 0;

		boolean vai = true;
		boolean testaInt;

		while (vai) {
			mostraMenu();

			testaInt = true;
			while (testaInt) {
				try {
					opcao = Integer.parseInt(in.entra(("\nDigite o NUMERO da opção: ")));
					testaInt = false;
				} catch (NumberFormatException erro) {
					System.out.println("\nA opção deve ser numérico!");
				}
			}

			switch (opcao) {
			case 1:
				cadastrarConta();
				break;
			case 2:
				consultarSaldoConta();
				break;
			case 3:
				efetuarDeposito();
				break;
			case 4:
				efetuarSaque();
				break;
			case 5:
				fecharConta();
				break;
			case 6:

				break;
			case 7:

				break;
			case 8:
				System.exit(0);

				break;

			default:
				System.out.println("Outras Opções (Valor fora da escala do menu)..: " + opcao);
				break;
			}
		}
	}

	private void fecharConta() throws Exception, RemoteException {
		long contaNumero = recebeNumeroConta();

		System.out.println(servico.fecharConta(contaNumero));

	}

	private void efetuarSaque() throws Exception, RemoteException {
		long contaNumero = recebeNumeroConta();

		double valorSaque = Double.parseDouble(in.entra("\nValor do saque: "));

		System.out.println(servico.efetuarSaque(contaNumero, valorSaque));

	}

	private long recebeNumeroConta() {
		System.out.println("Entre com os dados da conta:");

		return Long.parseLong(in.entra("\nNúmero da conta: "));
	}

	private void efetuarDeposito() throws Exception, RemoteException {
		long contaNumero = recebeNumeroConta();

		double valorDeposito = Double.parseDouble(in.entra("\nValor do depósito: "));

		System.out.println(servico.efetuarDeposito(contaNumero, valorDeposito));

	}

	private void consultarSaldoConta() throws Exception, RemoteException {
		long contaNumero = recebeNumeroConta();

		System.out.println("O saldo da conta de número " + contaNumero + " é de "
				+ cifrao(servico.consultarSaldo(contaNumero)) + ".");

	}

	public static void main(String[] args) throws ServiceException, Exception, RemoteException {
		ClienteIntegrador cliente = new ClienteIntegrador();
		cliente.iniciaCliente();
	}

	private void cadastrarConta() throws Exception, RemoteException {
		System.out.println("Entre com os dados da conta:");

		String nome = in.entra("\nNome do cliente: ");
		double saldoInicial = Double.parseDouble(in.entra("\nSaldo inicial da conta: "));

		long contaNumero = servico.criarConta(nome, saldoInicial);

		System.out.println("Conta de número " + contaNumero + " cadastrada com sucesso!");

	}

	public static void mostraMenu() {
		System.out.println("\n---------------- Menu de Opções ----------------------");
		System.out.println("( 1 ) - Criar nova conta");
		System.out.println("( 2 ) - Consultar saldo da conta");
		System.out.println("( 3 ) - Efetuar depósito na conta");
		System.out.println("( 4 ) - Efetuar saque na conta");
		System.out.println("( 5 ) - Fechar conta");
		System.out.println("( 6 ) - Listar todas as transações da conta");
		System.out.println("( 7 ) - Listar todas as transações");
		System.out.println("( 8 ) - Sair do Sistema");
	}

	private String cifrao(double valor) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
		return "R$ " + decimalFormat.format(valor);
	}

}
