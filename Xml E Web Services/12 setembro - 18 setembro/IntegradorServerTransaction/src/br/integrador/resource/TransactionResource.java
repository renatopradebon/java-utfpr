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

@Path("transaction")
public class TransactionResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transacao> getTransactions() {
		TransacaoDAO dao = new TransacaoDAO();
		return dao.getAll();
	}

	@Path("{account_number}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transacao> get(@PathParam("account_number") long acNumber) {
		TransacaoDAO dao = new TransacaoDAO();
		return dao.get(acNumber);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Transacao addTransaction(Transacao transaction) {
		TransacaoDAO dao = new TransacaoDAO();
		dao.save(transaction);
		return transaction;
	}
}
