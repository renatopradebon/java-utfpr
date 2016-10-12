package br.integrador.dao;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.integrador.modelo.Transacao;

@XmlRootElement
public class TransacaoDB {

	private String nome;
	private List<Transacao> transacaoDB;

	public String getName() {
		return nome;
	}

	public List<Transacao> getTransacaoList() {
		return transacaoDB;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public void setTransacaoList(List<Transacao> transacaoDB) {
		this.transacaoDB = transacaoDB;
	}
}
