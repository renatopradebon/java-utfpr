/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.log;

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

/**
 *
 * @author Machado
 */
@Path("log")
public class TransacaoResource {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Transacao> getTransactions() {
    	TransacaoDAO dao = new TransacaoDAO();
    	return dao.getTodasTransacoes();
    }    
    
    @Path("{numConta}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Transacao> get(@PathParam("numConta") long numConta) {
    	TransacaoDAO dao = new TransacaoDAO();
    	return dao.getTransacao(numConta);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Transacao addTransaction(Transacao transacao) {
    	TransacaoDAO dao = new TransacaoDAO();
    	dao.save(transacao);
    	return transacao;
    }    
}
