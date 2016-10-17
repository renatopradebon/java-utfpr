package br.integrador.modelo;

import br.integrador.modelo.enums.TipoOperacao;

public class Movimentacao {

	private TipoOperacao tipoOperacao;
	private double valor;
	private long conta;

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getConta() {
		return conta;
	}

	public void setConta(long conta) {
		this.conta = conta;
	}
}
