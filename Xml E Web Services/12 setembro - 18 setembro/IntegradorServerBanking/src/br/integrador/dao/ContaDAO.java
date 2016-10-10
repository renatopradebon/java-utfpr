package br.integrador.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.integrador.modelo.Conta;
import br.integrador.modelo.Movimentacao;
import br.integrador.modelo.enums.TipoTransacao;

public class ContaDAO {

	private List<Conta> contas;
	private Conta contaUtilizada;
	private Random geradorNumConta;

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

	public String setValoresTransacao(long numConta, double valor, TipoTransacao tipoTransacao) {
		contaUtilizada = recuperaConta(numConta);
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(numConta);
		movimentacao.setTipoTransacao(tipoTransacao);
		movimentacao.setValor(valor);
		contaUtilizada.getMovimentacao().add(movimentacao);

		return tipoTransacao.getNomeOperacao() + " no valor de " + cifrao(valor) + " foi realizado para o(a) Sr(a). "
				+ contaUtilizada.getNome() + ".";
	}

	public Conta recuperaConta(long numConta) {
		for (Conta conta : contas) {
			if (conta.getConta() == numConta) {
				return conta;
			}
		}

		return null;
	}

	public double consultarSaldoDAO(long numConta) {
		contaUtilizada = recuperaConta(numConta);
		double saldo = contaUtilizada.getSaldoInicial();

		for (Movimentacao movimentacao : contaUtilizada.getMovimentacao()) {
			saldo = saldo + (movimentacao.getValor() * movimentacao.getTipoTransacao().getOperacaoFinanceira());
		}

		return saldo;
	}

	public String efetuarDepositoDAO(long numConta, double valor) {
		return setValoresTransacao(numConta, valor, TipoTransacao.DEPOSITO);
	}

	public String efetuarSaqueDAO(long numConta, double valor) {
		return setValoresTransacao(numConta, valor, TipoTransacao.SAQUE);
	}

	private String cifrao(double valor) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
		return "R$ " + decimalFormat.format(valor);
	}

}
