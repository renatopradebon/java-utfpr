package br.com.utfpr.rest.jpa;

import java.util.ArrayList;

import br.com.utfpr.rest.entity.aluno.Aluno;
import br.com.utfpr.rest.entity.aluno.CalculaMediaAluno;
import br.com.utfpr.rest.entity.aluno.CalculaSituacaoAluno;
import br.com.utfpr.rest.entity.aluno.Notas;

public class TesteAlunoJpa {

	JpaTransaction jpa;

	public TesteAlunoJpa() {
		super();
		jpa = new JpaTransaction();
	}

	public static void main(String[] args) {

		TesteAlunoJpa testeAlunoJpa = new TesteAlunoJpa();
		testeAlunoJpa.insereAluno();

	}

	public void insereAluno() {
		Aluno aluno = new Aluno().nome("Renato Pradebon").realizouExame(0);

		ArrayList<Notas> notas = new ArrayList<Notas>();

		notas.add(new Notas().nota(8.5).observacaoNota("Primeiro bimestre"));
		notas.add(new Notas().nota(7.5).observacaoNota("Segundo bimestre"));
		notas.add(new Notas().nota(9.5).observacaoNota("Terceiro bimestre"));
		notas.add(new Notas().nota(10.0).observacaoNota("Quarto bimestre"));

		aluno.setNotas(notas);
		aluno.setMedia(new CalculaMediaAluno(aluno).calculaMedia());
		aluno.setSituacao(new CalculaSituacaoAluno(aluno).calculaSituacao());

		jpa.saveAluno(aluno);
	}

}
