package br.integrador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Conta {

	private long conta;

	private String nome;

	private double saldoInicial;

	private List<Movimentacao> movimentacao;

	public Conta(long conta, String nome, double saldoInicial) {
		super();
		this.nome = nome;
		this.saldoInicial = saldoInicial;
		this.conta = conta;
		this.movimentacao = new ArrayList<>();
	}

	public long getConta() {
		return conta;

	}

	public void setConta(long conta) {
		this.conta = conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public List<Movimentacao> getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(List<Movimentacao> movimentacao) {
		this.movimentacao = movimentacao;
	}

}
