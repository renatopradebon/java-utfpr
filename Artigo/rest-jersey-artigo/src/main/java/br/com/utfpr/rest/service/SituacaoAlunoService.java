package br.com.utfpr.rest.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.utfpr.rest.aluno.Aluno;
import br.com.utfpr.rest.aluno.CalculaSituacaoAluno;
import br.com.utfpr.rest.aluno.Notas;

@Path("/notas")
public class SituacaoAlunoService {

	Aluno aluno;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Path("/adiciona-nota")
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno recuperaSituacaoAluno(Aluno aluno) {
		CalculaSituacaoAluno calculaSituacaoAluno = new CalculaSituacaoAluno(aluno);

		aluno.setSituacao(calculaSituacaoAluno.calculaSituacao());

		setAluno(aluno);

		return getAluno();
	}

	@Path("/situacao")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String getSituacaoAluno() {
		return getAluno().getSituacao().getSituacaoDesc();
	}

	@Path("/jsonaluno")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno addAluno() {

		ArrayList<Notas> notas = new ArrayList<>();

		notas.add(new Notas().nota(7.5).observacaoNota("1 trimestre"));
		notas.add(new Notas().nota(8.5).observacaoNota("2 trimestre"));
		notas.add(new Notas().nota(5.5).observacaoNota("3 trimestre"));

		Aluno novoAluno = new Aluno().id(1L).nome("Renato Pradebon").notas(notas);

		novoAluno.situacao(new CalculaSituacaoAluno(novoAluno).calculaSituacao());

		return novoAluno;
	}

}
