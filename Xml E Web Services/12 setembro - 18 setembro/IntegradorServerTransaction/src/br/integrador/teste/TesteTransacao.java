package br.integrador.teste;

import java.util.Calendar;

import br.integrador.dao.TransacaoDAO;
import br.integrador.modelo.Transacao;
import br.integrador.modelo.enums.TransacaoTipo;

public class TesteTransacao {

	public static void main(String[] args) {

		TransacaoDAO transacaDao = new TransacaoDAO();

		Transacao transacao1 = new Transacao();
		transacao1.setNumConta(1022);
		transacao1.setTransacaoTipo(TransacaoTipo.CRIACAO);
		String descricao = TransacaoTipo.CRIACAO.getNomeTransacao() + " "
				+ TransacaoTipo.CRIACAO.getTipoOperacaoString()
				+ " conta de número 1022 com saldo inicial de R$ 1500,00.";
		transacao1.setDescricao(descricao);
		transacao1.setData(Calendar.getInstance().getTime());

		transacaDao.criarTransacao(transacao1);

		Transacao transacao2 = new Transacao();
		transacao2.setNumConta(1022);
		transacao2.setTransacaoTipo(TransacaoTipo.SAQUE);
		descricao = TransacaoTipo.SAQUE.getNomeTransacao() + " " + TransacaoTipo.SAQUE.getTipoOperacaoString()
				+ " conta de número 1022 no valor de R$ 500,00";
		transacao2.setDescricao(descricao);
		transacao2.setData(Calendar.getInstance().getTime());

		transacaDao.criarTransacao(transacao2);

		Transacao transacao3 = new Transacao();
		transacao3.setNumConta(1022);
		transacao3.setTransacaoTipo(TransacaoTipo.DEPOSITO);
		descricao = TransacaoTipo.DEPOSITO.getNomeTransacao() + " " + TransacaoTipo.DEPOSITO.getTipoOperacaoString()
				+ " conta de número 1022 no valor de R$ 1500,00";
		transacao3.setDescricao(descricao);
		transacao3.setData(Calendar.getInstance().getTime());

		transacaDao.criarTransacao(transacao3);

		transacaDao.criarTransacao(transacao2);

		Transacao transacao4 = new Transacao();
		transacao4.setNumConta(1022);
		transacao4.setTransacaoTipo(TransacaoTipo.FECHAMENTO);
		descricao = TransacaoTipo.FECHAMENTO.getNomeTransacao() + " " + TransacaoTipo.FECHAMENTO.getTipoOperacaoString()
				+ " conta de número 1022.";
		transacao4.setDescricao(descricao);
		transacao4.setData(Calendar.getInstance().getTime());

		transacaDao.criarTransacao(transacao4);

		Transacao transacao5 = new Transacao();
		transacao5.setNumConta(1023);
		transacao5.setTransacaoTipo(TransacaoTipo.SAQUE);
		descricao = TransacaoTipo.SAQUE.getNomeTransacao() + " " + TransacaoTipo.SAQUE.getTipoOperacaoString()
				+ " conta de número 1022  no valor de R$ 250,00.";
		transacao5.setDescricao(descricao);
		transacao5.setData(Calendar.getInstance().getTime());

		transacaDao.criarTransacao(transacao5);

		for (Transacao transacao : transacaDao.getTransacoes()) {
			System.out.println("Todas as transacoes => " + transacao.toString());
		}

		System.out.println("Dados da conta 1023 => " + transacaDao.getTransacao(1023).toString());

	}

}
