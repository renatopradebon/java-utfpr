package br.integrador.modelo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import br.integrador.modelo.enums.TransacaoTipo;

@XmlRootElement
public class Transacao {

	private long numConta;
	private String descricao;
	private Date data;
	private TransacaoTipo transacaoTipo;

//	public Transacao() {
//		this.numConta = 0l;
//		this.descricao = "";
//		this.data = Calendar.getInstance().getTime();
//	}

	public long getNumConta() {
		return numConta;
	}

	public void setNumConta(long numConta) {
		this.numConta = numConta;
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

	public TransacaoTipo getTransacaoTipo() {
		return transacaoTipo;
	}

	public void setTransacaoTipo(TransacaoTipo transacaoTipo) {
		this.transacaoTipo = transacaoTipo;
	}

	@Override
	public String toString() {
		return "Transacao [numConta=" + numConta + ", descricao=" + descricao + ", data=" + data + ", transacaoTipo="
				+ transacaoTipo + "]";
	}

}
