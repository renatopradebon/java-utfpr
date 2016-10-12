package br.integrador.modelo;

import br.integrador.modelo.enums.TipoOperacao;

public class Movimentacao {

	private TipoOperacao tipoTransacao;
	private double valor;
	private long conta;

	public TipoOperacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoOperacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
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
