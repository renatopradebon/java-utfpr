package br.com.utfpr.rest.entity.aluno;

import br.com.utfpr.rest.jpa.JpaTransaction;

public class CalculaMediaAluno {

	private Aluno aluno;

	JpaTransaction jpa = new JpaTransaction();;

	public CalculaMediaAluno(Aluno aluno) {
		super();
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Double calculaMedia() {
		return (somaNotas() / getAluno().getNotas().size());
	}

	private Double somaNotas() {
		Double somaTotal = 0.0;

		somaTotal = (getAluno().getNotas().stream().mapToDouble(i -> i.getNota()).sum())
				+ (jpa.listNotas(aluno.getId()).stream().mapToDouble(i -> i.getNota()).sum());

		return somaTotal;
	}
}
