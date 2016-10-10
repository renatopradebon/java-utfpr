package br.integrador.modelo;

import br.integrador.modelo.enums.TipoTransacao;

public class Movimentacao {

	private TipoTransacao tipoTransacao;
	private double valor;
	private long conta;

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
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
