package br.com.utfpr.rest.aluno;

import br.com.utfpr.rest.aluno.vo.Situacao;

public class CalculaSituacaoAluno {

	private Aluno aluno;

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
		Double mediaFinal = (somaNotas() / getAluno().getNotas().size());

		return (mediaFinal >= 7.0) ? Situacao.APROVADO
				: ((getAluno().getRealizouExame()) ? Situacao.REPROVADO : Situacao.EXAME);
	}

	private Double somaNotas() {
		Double somaTotal = 0.0;

		somaTotal = getAluno().getNotas().stream().mapToDouble(i -> i.getNota()).sum();

		return somaTotal;
	}

}
