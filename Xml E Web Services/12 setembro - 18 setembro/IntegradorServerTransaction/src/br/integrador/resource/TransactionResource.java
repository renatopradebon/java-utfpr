package br.integrador.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.integrador.dao.TransactionXmlDAO;
import br.integrador.modelo.Transaction;

@Path("transaction")
public class TransactionResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transaction> getTransactions() {
		TransactionXmlDAO dao = new TransactionXmlDAO();
		return dao.getAll();
	}

	@Path("{account_number}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transaction> get(@PathParam("account_number") long acNumber) {
		TransactionXmlDAO dao = new TransactionXmlDAO();
		return dao.get(acNumber);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction addTransaction(Transaction transaction) {
		TransactionXmlDAO dao = new TransactionXmlDAO();
		dao.save(transaction);
		return transaction;
	}
}
