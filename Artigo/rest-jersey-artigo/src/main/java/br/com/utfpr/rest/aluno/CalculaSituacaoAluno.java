package br.com.utfpr.rest.aluno;

import br.com.utfpr.rest.aluno.vo.Situacao;

public class CalculaSituacaoAluno {

	private Aluno aluno;
	
	private static Double mediaFinalAprovacao = 7.0;

	public CalculaSituacaoAluno(Aluno aluno) {
		super();
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Situacao calculaSituacao() {
		return (getAluno().getMedia() >= mediaFinalAprovacao) ? Situacao.APROVADO
				: ((getAluno().getRealizouExame()) ? Situacao.REPROVADO : Situacao.EXAME);
	}
}
