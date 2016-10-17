package br.integrador.modelo.enums;

public enum TransacaoTipo {
	CRIACAO("Abertura", "da"), SAQUE("Saque", "na"), DEPOSITO("Depósito", "na"), FECHAMENTO("Encerramento", "na");

	private TransacaoTipo(String nomeTransacao, String tipoOperacaoString) {
		this.nomeTransacao = nomeTransacao;
		
		// utilizado na montagem da string
		this.tipoOperacaoString = tipoOperacaoString;
	}

	private String nomeTransacao;
	private String tipoOperacaoString;

	public String getNomeTransacao() {
		return nomeTransacao;
	}

	public void setNomeTransacao(String nomeTransacao) {
		this.nomeTransacao = nomeTransacao;
	}

	public String getTipoOperacaoString() {
		return tipoOperacaoString;
	}

	public void setTipoOperacaoString(String tipoOperacaoString) {
		this.tipoOperacaoString = tipoOperacaoString;
	}
}