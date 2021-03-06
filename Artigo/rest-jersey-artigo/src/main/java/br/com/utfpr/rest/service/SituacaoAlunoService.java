package br.com.utfpr.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
		aluno = trataNotasAluno(aluno);

		jpa.saveAluno(aluno);

		return aluno;
	}

	@Path("/edita-aluno")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno editAluno(Aluno aluno) {
		aluno = trataNotasAluno(aluno);

		jpa.updateAluno(aluno);

		return aluno;
	}

	@Path("/deleta-aluno/{idAluno}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String deletaAluno(@PathParam("idAluno") Long idAluno) {
		String retorno = jpa.deleteAluno(idAluno);

		return "{\"status\": \"" + retorno + "\"}";
	}

	@Path("/lista-alunos")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Aluno> listarAlunos() {
		List<Aluno> alunos = jpa.listAlunos();

		alunos.forEach((alunoLista) -> System.out.println(alunoLista.toString()));

		return alunos;
	}

	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno trataNotasAluno(Aluno aluno) {

		aluno.setMedia(CalculaMediaAluno.calculaMedia(aluno, jpa));
		aluno.setSituacao(CalculaSituacaoAluno.calculaSituacao(aluno));

		List<Notas> notaLista = aluno.getNotas();

		for (Notas nota : notaLista) {
			nota.setAluno(aluno);
		}

		aluno.toString();

		return aluno;
	}

	@Path("/aluno/{idAluno}")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno getAluno(@PathParam("idAluno") Long idAluno) {
		return jpa.getAluno(idAluno);
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
		aluno.setMedia(CalculaMediaAluno.calculaMedia(aluno, jpa));
		aluno.setSituacao(CalculaSituacaoAluno.calculaSituacao(aluno));

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
