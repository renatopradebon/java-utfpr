package br.integrador.dao;

import java.util.ArrayList;
import java.util.List;

import br.integrador.modelo.Transacao;

public class TransacaoDAO {
	private static final String PATH_XML = "./public/transacoesDB.xml";

	private List<Transacao> transacoes;

	public TransacaoDAO() {
		transacoes = new ArrayList<>();
	}

	public void criarTransacao(Transacao novaTransacao) {
		transacoes.add(novaTransacao);
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public List<Transacao> getTransacao(long numConta) {

		List<Transacao> transacoesConta = new ArrayList<>();

		for (Transacao transacao : getTransacoes()) {
			if (transacao.getNumConta() == numConta) {
				transacoesConta.add(transacao);
			}
		}

		return transacoesConta.size() > 0 ? transacoesConta : null;
	}

}
