package br.com.utfpr.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.utfpr.rest.entity.aluno.Aluno;
import br.com.utfpr.rest.entity.aluno.CalculaMediaAluno;
import br.com.utfpr.rest.entity.aluno.CalculaSituacaoAluno;
import br.com.utfpr.rest.entity.aluno.Notas;
import br.com.utfpr.rest.jpa.JpaTransaction;

@Path("/notas")
public class SituacaoAlunoService {

	Aluno aluno;
	JpaTransaction jpa;

	public SituacaoAlunoService() {
		super();
		jpa = new JpaTransaction();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Path("/cadastra-aluno")
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno addAluno(Aluno aluno) {

		aluno.setMedia(new CalculaMediaAluno(aluno).calculaMedia());
		aluno.setSituacao(new CalculaSituacaoAluno(aluno).calculaSituacao());

		setAluno(aluno);

		System.out.println(aluno.toString());

		jpa.saveAluno(aluno);

		return getAluno();

		// try {
		// } catch (Exception e) {
		// throw new WebApplicationException(500);
		// }
	}

	@Path("/lista-alunos")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Aluno> listarAlunos() {

		List<Aluno> alunos = jpa.listAlunos();

		alunos.forEach((alunoLista) -> System.out.println(alunoLista.toString()));

		return alunos;
	}

	@Path("/json-exemplo")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno jsonExemploAluno() {

		aluno = new Aluno().id(1L).nome("Renato Pradebon");

		ArrayList<Notas> notas = new ArrayList<>();

		notas.add(new Notas().nota(7.5).observacaoNota("1 trimestre").aluno(aluno));
		notas.add(new Notas().nota(8.5).observacaoNota("2 trimestre").aluno(aluno));
		notas.add(new Notas().nota(5.5).observacaoNota("3 trimestre").aluno(aluno));
		notas.add(new Notas().nota(9.5).observacaoNota("4 trimestre").aluno(aluno));

		aluno.setNotas(notas);
		aluno.setMedia(new CalculaMediaAluno(aluno).calculaMedia());
		aluno.setSituacao(new CalculaSituacaoAluno(aluno).calculaSituacao());

		System.out.println(aluno.toString());

		return aluno;
	}

	@Path("/servico-ativo")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String servicoIsAtivo() {
		return "ON";
	}

}
