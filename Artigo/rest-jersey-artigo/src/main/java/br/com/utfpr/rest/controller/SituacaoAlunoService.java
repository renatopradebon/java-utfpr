package br.com.utfpr.rest.controller;

import java.util.ArrayList;

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

	// @PersistenceContext(unitName = "utfpr_notas")
	// private EntityManager em;

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

	@Path("/media-aluno")
	@POST
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno recuperaSituacaoAluno(Aluno aluno) {

		aluno.setMedia(new CalculaMediaAluno(aluno).calculaMedia());
		aluno.setSituacao(new CalculaSituacaoAluno(aluno).calculaSituacao());

		setAluno(aluno);

		System.out.println(aluno.toString());

		// em.persist(aluno);
		jpa.saveAluno(aluno);

		return getAluno();

		// try {
		//
		// } catch (Exception e) {
		// throw new WebApplicationException(500);
		// }

	}

	@Path("/json-exemplo")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Aluno addAluno() {

		ArrayList<Notas> notas = new ArrayList<>();

		notas.add(new Notas().nota(7.5).observacaoNota("1 trimestre"));
		notas.add(new Notas().nota(8.5).observacaoNota("2 trimestre"));
		notas.add(new Notas().nota(5.5).observacaoNota("3 trimestre"));
		notas.add(new Notas().nota(9.5).observacaoNota("4 trimestre"));

		aluno = new Aluno().id(1L).nome("Renato Pradebon").notas(notas);

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
