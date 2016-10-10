package br.integrador.servicos;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transacao {

	private long numeroConta;

	private String tipoTransacao; // criacao, saque, deposito, fechamento

	private String descricao; // descricao detalhada da transacao (com valores)

	private Date data;

	public long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
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
}
