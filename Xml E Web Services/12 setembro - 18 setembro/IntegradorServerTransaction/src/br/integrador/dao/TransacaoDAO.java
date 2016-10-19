package br.integrador.dao;

import java.util.List;

import br.integrador.modelo.Transacao;

public class TransacaoDAO {

	private TransacaoXML transacaoXML;

	public TransacaoDAO() {
		transacaoXML = new TransacaoXML();
	}

	public Transacao criarTransacao(Transacao novaTransacao) {
		setTransacaoXML(novaTransacao);
		return novaTransacao;
	}

	public void setTransacaoXML(Transacao transacao) {
		transacaoXML.setTransacao(transacao);
		transacaoXML.saveXML();
	}

	public List<Transacao> getTransacoes() {

		return transacaoXML.getTransacoesAtuais();
	}

	public List<Transacao> getTransacao(long numConta) {

		return transacaoXML.getTransacoesAtuais(numConta);
	}

}
