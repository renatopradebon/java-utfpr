package br.integrador.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.integrador.dao.TransacaoDAO;
import br.integrador.modelo.Transacao;

@Path("transacao")
public class TransacaoResource {

	TransacaoDAO transacaoDao;

	public TransacaoResource() {
		transacaoDao = new TransacaoDAO();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public List<Transacao> getTransacoes() {
		return transacaoDao.getTransacoes();
	}

	@Path("{conta_numero}")
	@GET
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public List<Transacao> getTransacao(@PathParam("conta_numero") long numConta) {
		return transacaoDao.getTransacao(numConta);
	}

	@Path("nova-transacao")
	@POST
	@Consumes(MediaType.APPLICATION_XML + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public Transacao criarTransacao(Transacao transacao) {
		transacaoDao.criarTransacao(transacao);
		return transacao;
	}
}
