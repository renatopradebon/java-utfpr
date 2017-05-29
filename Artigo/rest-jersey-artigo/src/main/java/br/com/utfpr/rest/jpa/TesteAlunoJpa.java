package br.com.utfpr.rest.jpa;

import java.util.ArrayList;
import java.util.List;

import br.com.utfpr.rest.entity.aluno.Aluno;
import br.com.utfpr.rest.entity.aluno.CalculaMediaAluno;
import br.com.utfpr.rest.entity.aluno.CalculaSituacaoAluno;
import br.com.utfpr.rest.entity.aluno.Notas;
import br.com.utfpr.rest.entity.aluno.vo.Situacao;

public class TesteAlunoJpa {

	JpaTransaction jpa;

	public TesteAlunoJpa() {
		super();
		jpa = new JpaTransaction();
	}

	public static void main(String[] args) {

		TesteAlunoJpa testeAlunoJpa = new TesteAlunoJpa();

		Long idAluno = testeAlunoJpa.insereAluno();

		TesteAlunoJpa testeAlunoJpa2 = new TesteAlunoJpa();
		testeAlunoJpa2.insereAluno2();

		TesteAlunoJpa testeAlunoJpa3 = new TesteAlunoJpa();
		testeAlunoJpa3.insereAluno3();

		TesteAlunoJpa testeAlunoJpa4 = new TesteAlunoJpa();
		testeAlunoJpa4.atualizaNotasAluno(idAluno);

		TesteAlunoJpa testeAlunoJpa5 = new TesteAlunoJpa();
		testeAlunoJpa5.listAlunoEspecifico(idAluno);

		TesteAlunoJpa testeAlunoJpa6 = new TesteAlunoJpa();
		testeAlunoJpa6.listAlunos();

		TesteAlunoJpa testeAlunoJpa7 = new TesteAlunoJpa();
		testeAlunoJpa7.deletaAluno(idAluno);

	}

	public Long insereAluno() {
		Aluno aluno = new Aluno().nome("Renato Pradebon").realizouExame(0).id(1L);

		ArrayList<Notas> notas = new ArrayList<Notas>();

		notas.add(new Notas().nota(8.5).observacaoNota("Primeiro bimestre").aluno(aluno));
		notas.add(new Notas().nota(7.5).observacaoNota("Segundo bimestre").aluno(aluno));
		notas.add(new Notas().nota(9.5).observacaoNota("Terceiro bimestre").aluno(aluno));
		notas.add(new Notas().nota(10.0).observacaoNota("Quarto bimestre").aluno(aluno));

		aluno.setNotas(notas);

		Double media = CalculaMediaAluno.calculaMedia(aluno, jpa);
		aluno.setMedia(media);

		Situacao situacao = CalculaSituacaoAluno.calculaSituacao(aluno);
		aluno.setSituacao(situacao);

		Aluno alunoSalvo = jpa.saveAluno(aluno);

		System.out.println("insereAluno => ");
		System.out.println(alunoSalvo.toString());

		return alunoSalvo.getId();

	}

	public void insereAluno2() {
		Aluno aluno = new Aluno().nome("Adriano Pereira").realizouExame(0).id(2L);

		ArrayList<Notas> notas = new ArrayList<Notas>();

		notas.add(new Notas().nota(6.5).observacaoNota("Primeiro bimestre").aluno(aluno));
		notas.add(new Notas().nota(8.5).observacaoNota("Segundo bimestre").aluno(aluno));
		notas.add(new Notas().nota(6.5).observacaoNota("Terceiro bimestre").aluno(aluno));
		notas.add(new Notas().nota(6.0).observacaoNota("Quarto bimestre").aluno(aluno));

		aluno.setNotas(notas);

		Double media = CalculaMediaAluno.calculaMedia(aluno, jpa);
		aluno.setMedia(media);

		Situacao situacao = CalculaSituacaoAluno.calculaSituacao(aluno);
		aluno.setSituacao(situacao);

		Aluno alunoSalvo = jpa.saveAluno(aluno);

		System.out.println("insereAluno2 => ");
		System.out.println(alunoSalvo.toString());
	}

	public void insereAluno3() {
		Aluno aluno = new Aluno().nome("Joni Nunes").realizouExame(1).id(3L);

		ArrayList<Notas> notas = new ArrayList<Notas>();

		notas.add(new Notas().nota(5.5).observacaoNota("Primeiro bimestre").aluno(aluno));
		notas.add(new Notas().nota(7.5).observacaoNota("Segundo bimestre").aluno(aluno));
		notas.add(new Notas().nota(6.5).observacaoNota("Terceiro bimestre").aluno(aluno));
		notas.add(new Notas().nota(4.0).observacaoNota("Quarto bimestre").aluno(aluno));
		notas.add(new Notas().nota(6.0).observacaoNota("Exame").aluno(aluno));

		aluno.setNotas(notas);

		Double media = CalculaMediaAluno.calculaMedia(aluno, jpa);
		aluno.setMedia(media);

		Situacao situacao = CalculaSituacaoAluno.calculaSituacao(aluno);
		aluno.setSituacao(situacao);

		Aluno alunoSalvo = jpa.saveAluno(aluno);

		System.out.println("insereAluno3 => ");
		System.out.println(alunoSalvo.toString());
	}

	public void atualizaNotasAluno(Long idAluno) {

		Aluno aluno = jpa.getAluno(idAluno);

		aluno.getNotas().add(new Notas().nota(4.0).observacaoNota("exame").aluno(aluno));
		aluno.setRealizouExame(1);
		aluno.setMedia(CalculaMediaAluno.calculaMedia(aluno, jpa));
		aluno.setSituacao(CalculaSituacaoAluno.calculaSituacao(aluno));

		Aluno alunoSalvo = jpa.updateAluno(aluno);

		System.out.println("atualizaNotasAluno => ");
		System.out.println(alunoSalvo.toString());
	}

	public void listAlunos() {

		List<Aluno> alunos = jpa.listAlunos();

		System.out.println("listAlunos => ");
		alunos.forEach((k) -> System.out.println(k.toString()));
	}

	public void listAlunoEspecifico(Long idAluno) {
		Aluno aluno = jpa.getAluno(idAluno);

		System.out.println("listAlunoEspecifico => " + aluno.toString());
	}

	public void deletaAluno(Long idAluno) {
		String removido = jpa.deleteAluno(idAluno);
		System.out.println("deletaAluno => ");
		System.out.println(removido);
	}

}
