package br.integrador.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.integrador.dao.exception.ContaNaoEncontrada;
import br.integrador.modelo.Conta;
import br.integrador.modelo.Movimentacao;
import br.integrador.modelo.enums.TipoOperacao;

public class ContaDAO {

	private List<Conta> contas;
	private Conta contaUtilizada;
	private Random geradorNumConta;
	private static String CONTA_NAO_ENCONTRADA = "Conta não encontrada!";

	public ContaDAO() {
		contas = new ArrayList<>();
		geradorNumConta = new Random(999);
	}

	public long criarContaDAO(String nome, double saldo) {
		long numConta = Math.abs(geradorNumConta.nextLong());
		Conta novaConta = new Conta(numConta, nome, saldo);
		contas.add(novaConta);
		return novaConta.getConta();
	}

	public String setValoresTransacao(long numConta, double valor, TipoOperacao tipoTransacao)
			throws ContaNaoEncontrada {
		try {
			contaUtilizada = recuperaConta(numConta);
			if (contaUtilizada.getConta() != 0) {
				Movimentacao movimentacao = new Movimentacao();
				movimentacao.setConta(numConta);
				movimentacao.setTipoTransacao(tipoTransacao);
				movimentacao.setValor(valor);
				contaUtilizada.getMovimentacao().add(movimentacao);

				return tipoTransacao.getNomeOperacao() + " no valor de " + cifrao(valor)
						+ " foi realizado para o(a) Sr(a). " + contaUtilizada.getNome() + " na conta de número "
						+ contaUtilizada.getConta() + ".";
			}
		} catch (ContaNaoEncontrada erro) {
			System.err.println(erro);
		}

		return CONTA_NAO_ENCONTRADA;
	}

	public Conta recuperaConta(long numConta) throws ContaNaoEncontrada {
		int contador = 0;
		for (Conta conta : contas) {
			if (conta.getConta() == numConta) {
				contador++;
				return conta;
			}
		}
		if (contador == 0) {
			throw new ContaNaoEncontrada(numConta);
		}
		return null;
	}

	public double consultarSaldoDAO(long numConta) throws ContaNaoEncontrada {
		try {
			contaUtilizada = recuperaConta(numConta);
			if (contaUtilizada.getConta() != 0) {
				double saldo = contaUtilizada.getSaldoInicial();

				for (Movimentacao movimentacao : contaUtilizada.getMovimentacao()) {
					saldo = saldo + (movimentacao.getValor() * movimentacao.getTipoTransacao().getOperacaoFinanceira());
				}

				return saldo;
			}
		} catch (ContaNaoEncontrada erro) {
			System.err.println(erro);
		}

		return 0;
	}

	public String efetuarDepositoDAO(long numConta, double valor) throws ContaNaoEncontrada {
		return setValoresTransacao(numConta, valor, TipoOperacao.DEPOSITO);
	}

	public String efetuarSaqueDAO(long numConta, double valor) throws ContaNaoEncontrada {
		return setValoresTransacao(numConta, valor, TipoOperacao.SAQUE);
	}

	private String cifrao(double valor) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
		return "R$ " + decimalFormat.format(valor);
	}

	public String fecharContaDAO(long numConta) {
		for (Conta conta : contas) {
			if (conta.getConta() == numConta) {
				contas.remove(conta);
				return "Conta de número " + numConta + " removida com sucesso!";
			}
		}

		return CONTA_NAO_ENCONTRADA;
	}

}
