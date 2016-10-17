package br.integrador.dao;

import java.util.ArrayList;
import java.util.List;

import br.integrador.bd.TransacaoBD;
import br.integrador.modelo.Transacao;

public class TransacaoDAO {

	private TransacaoBD transacaoBD;

	public TransacaoDAO() {
		transacaoBD = new TransacaoBD();
	}

	public Transacao criarTransacao(Transacao novaTransacao) {
		transacaoBD.getTransacoes().add(novaTransacao);
		setTransacaoXML();
		return novaTransacao;
	}

	public void setTransacaoXML() {
		TransacaoXML transacaoXML = new TransacaoXML();
		transacaoXML.setTransacaoBD(transacaoBD);
		transacaoXML.saveXML();
	}

	public List<Transacao> getTransacoes() {
		return transacaoBD.getTransacoes();
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
