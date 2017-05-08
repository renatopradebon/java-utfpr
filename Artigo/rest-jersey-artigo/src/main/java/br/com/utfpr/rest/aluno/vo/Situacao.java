package br.com.utfpr.rest.aluno.vo;

public enum Situacao {

	APROVADO("Aprovado"), REPROVADO("Reprovado"), EXAME("Exame");

	private Situacao(String situacaoDesc) {
		this.situacaoDesc = situacaoDesc;
	}

	private String situacaoDesc;

	public String getSituacaoDesc() {
		return situacaoDesc;
	}

}
