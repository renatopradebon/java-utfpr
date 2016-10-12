package br.integrador.modelo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import br.integrador.modelo.enums.TransacaoTipo;

@XmlRootElement
public class Transacao {

	private long conta;
	private String descricao;
	private Date data;
	private TransacaoTipo transactionType;

	public Transacao() {
		this.conta = 0l;
		this.descricao = "";
	}

	public long getConta() {
		return conta;
	}

	public void setConta(long conta) {
		this.conta = conta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TransacaoTipo getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransacaoTipo transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transacao [conta=" + conta + ", descricao=" + descricao + ", data=" + data + ", transactionType="
				+ transactionType + "]";
	}

}
