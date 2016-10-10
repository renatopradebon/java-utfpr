package br.integrador.modelo.enums;

public enum TipoTransacao {

	SAQUE("Saque", -1), DEPOSITO("Depósito", 1);

	private int operacaoFinanceira;
	private String nomeOperacao;

	TipoTransacao(String nomeOperacao, int operacaoFinanceira) {
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
