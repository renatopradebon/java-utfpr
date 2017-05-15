package br.com.utfpr.rest.entity.aluno;

import br.com.utfpr.rest.entity.aluno.vo.Situacao;

public class CalculaSituacaoAluno {

	private Aluno aluno;

	private static Double MEDIA_FINAL_APROVACAO = 7.0;

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
		return (getAluno().getMedia() >= MEDIA_FINAL_APROVACAO) ? Situacao.APROVADO
				: ((getAluno().getRealizouExame() == 1) ? Situacao.REPROVADO : Situacao.EXAME);
	}
}
