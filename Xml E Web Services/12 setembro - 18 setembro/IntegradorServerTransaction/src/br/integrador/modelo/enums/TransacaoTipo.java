package br.integrador.modelo.enums;

public enum TransacaoTipo {
	CRIACAO("Abertura"), SAQUE("Saque"), DEPOSITO("Depósito"), FECHAMENTO("Encerramento");

	private TransacaoTipo(String nomeTransacao) {
		this.nomeTransacao = nomeTransacao;
	}

	private String nomeTransacao;

	public String getNomeTransacao() {
		return nomeTransacao;
	}

	public void setNomeTransacao(String nomeTransacao) {
		this.nomeTransacao = nomeTransacao;
	}
}