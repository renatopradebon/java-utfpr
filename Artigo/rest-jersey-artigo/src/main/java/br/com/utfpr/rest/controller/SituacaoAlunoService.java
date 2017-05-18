package br.com.utfpr.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import br.com.utfpr.rest.entity.aluno.Aluno;
import br.com.utfpr.rest.entity.aluno.CalculaMediaAluno;
import br.com.utfpr.rest.entity.aluno.CalculaSituacaoAluno;
import br.com.utfpr.rest.entity.aluno.Notas;
import br.com.utfpr.rest.jpa.JpaTransaction;

@Path("/notas")
public class SituacaoAlunoService {

	JpaTransaction jpa;

	public SituacaoAlunoService() {
		super();
		jpa = new JpaTransaction();
	}

	@Path("/cadastra-aluno")
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno addAluno(Aluno aluno) {
		return trataDadosAluno(aluno);
	}

	@Path("/edita-aluno")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno editAluno(Aluno aluno) {
		return trataDadosAluno(aluno);
	}

	public Aluno trataDadosAluno(Aluno aluno) {
		aluno.setMedia(new CalculaMediaAluno(aluno).calculaMedia());
		aluno.setSituacao(new CalculaSituacaoAluno(aluno).calculaSituacao());

		List<Notas> notaLista = aluno.getNotas();

		for (Notas nota : notaLista) {
			nota.setAluno(aluno);
		}

		jpa.saveAluno(aluno);

		return aluno;
	}

	@Path("/deleta-aluno")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String deletaAluno(Long idAluno, @Context final HttpServletResponse response) {

		// set HTTP code to "201 Created"
		response.setStatus(HttpServletResponse.SC_CREATED);

		try {
			response.flushBuffer();
			jpa.deleteAluno(idAluno);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return response.toString();
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

		Aluno aluno = new Aluno().id(1L).nome("Renato Pradebon");

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
