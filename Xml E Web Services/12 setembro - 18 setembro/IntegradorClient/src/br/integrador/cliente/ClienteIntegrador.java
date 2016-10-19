package br.integrador.cliente;

import java.rmi.RemoteException;
import java.text.DecimalFormat;

import javax.xml.rpc.ServiceException;

import br.integrador.bd.TransacaoBD;
import br.integrador.cliente.indata.InData;
import br.integrador.cliente.transacao.IntegradorClienteTransacao;
import br.integrador.implementacoes.BancarioServiceImplements;
import br.integrador.implementacoes.BancarioServiceImplementsServiceLocator;
import br.integrador.implementacoes.Exception;
import br.integrador.modelo.Transacao;

public class ClienteIntegrador {

	private static String LISTA_TRANSACOES_VAZIA = "Não existem dados de transações.";
	private static String LISTA_TRANSACOES_CONTA_VAZIA = "Não existem dados de transações para a conta ";
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
				ListarTransacoesConta();
				break;
			case 7:
				ListarTransacoes();
				break;
			case 8:
				Sair();

				break;

			default:
				System.out.println("Outras Opções (Valor fora da escala do menu)..: " + opcao);
				break;
			}
		}
	}

	private void Sair() {
		System.out.println("Obrigado por utilizar os nossos serviços.");

		System.exit(0);
	}

	private void ListarTransacoes() throws Exception {

		IntegradorClienteTransacao integradorCliente = new IntegradorClienteTransacao();

		TransacaoBD transacaoBD = integradorCliente.recuperaTransacoes();

		if (!transacaoBD.getTransacao().isEmpty()) {

			System.out.println("Listando todas as transações");
			for (Transacao transacao : transacaoBD.getTransacao()) {
				System.out.println(transacao.toString());
			}
		} else {
			System.out.println(LISTA_TRANSACOES_VAZIA);
		}

	}

	private void ListarTransacoesConta() throws Exception {

		long numConta = recebeNumeroConta();

		IntegradorClienteTransacao integradorCliente = new IntegradorClienteTransacao();
		integradorCliente.setNumConta(numConta);

		TransacaoBD transacaoBD = integradorCliente.recuperaTransacoes();

		if (!transacaoBD.getTransacao().isEmpty()) {

			System.out.println("Listando todas as transações da conta " + numConta + ".");

			for (Transacao transacao : transacaoBD.getTransacao()) {
				System.out.println(transacao.toString());
			}
		} else {
			System.out.println(LISTA_TRANSACOES_CONTA_VAZIA + numConta + ".");
		}
	}

	private void fecharConta() throws Exception, RemoteException {
		long numConta = recebeNumeroConta();

		System.out.println(servico.fecharConta(numConta));

	}

	private void efetuarSaque() throws Exception, RemoteException {
		long numConta = recebeNumeroConta();

		double valorSaque = Double.parseDouble(in.entra("\nValor do saque: "));

		System.out.println(servico.efetuarSaque(numConta, valorSaque));

	}

	private long recebeNumeroConta() {

		Boolean testaInt = true;
		long conta = (long) 0;
		while (testaInt) {
			try {
				conta = Long.parseLong(in.entra("\nEntre com os dados da conta: "));
				testaInt = false;
			} catch (NumberFormatException erro) {
				System.out.println("\nA opção deve ser numérico!");
			}
		}
		
		System.out.println("");

		return conta;
	}

	private void efetuarDeposito() throws Exception, RemoteException {
		long numConta = recebeNumeroConta();

		double valorDeposito = Double.parseDouble(in.entra("\nValor do depósito: "));

		System.out.println(servico.efetuarDeposito(numConta, valorDeposito));

	}

	private void consultarSaldoConta() throws Exception, RemoteException {
		long numConta = recebeNumeroConta();

		System.out.println(
				"O saldo da conta de número " + numConta + " é de " + cifrao(servico.consultarSaldo(numConta)) + ".");

	}

	public static void main(String[] args) throws ServiceException, Exception, RemoteException {
		ClienteIntegrador cliente = new ClienteIntegrador();
		cliente.iniciaCliente();
	}

	private void cadastrarConta() throws Exception, RemoteException {
		System.out.println("Entre com os dados da conta:");

		String nome = in.entra("\nNome do cliente: ");
		double saldoInicial = Double.parseDouble(in.entra("\nSaldo inicial da conta: "));

		long numConta = servico.criarConta(nome, saldoInicial);

		System.out.println("Conta de número " + numConta + " cadastrada com sucesso!");

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
