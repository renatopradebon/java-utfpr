package br.integrador.modelo.enums;

public enum TipoOperacao {

	SAQUE("Saque", -1), DEPOSITO("Depósito", 1);

	private int operacaoFinanceira;
	private String nomeOperacao;

	TipoOperacao(String nomeOperacao, int operacaoFinanceira) {
		this.nomeOperacao = nomeOperacao;
		this.operacaoFinanceira = operacaoFinanceira;
	}

	public String getNomeOperacao() {
		return this.nomeOperacao;
	}

	public int getOperacaoFinanceira() {
		return operacaoFinanceira;
	}

}
