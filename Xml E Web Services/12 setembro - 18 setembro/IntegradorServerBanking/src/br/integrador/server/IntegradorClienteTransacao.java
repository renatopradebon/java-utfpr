package br.integrador.server;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.integrador.modelo.Transacao;

public class IntegradorClienteTransacao {

	public void adicionaTransacao(Transacao transacao) {

		Client cliente = Client.create();

		WebResource resource = cliente.resource("http://localhost:3000/transacao/nova-transacao");

		resource.type(MediaType.APPLICATION_XML);

		Transacao novaTransacao = resource.post(Transacao.class, transacao);

		System.out.println(novaTransacao.getTransacaoTipo().getNomeTransacao() + " "
				+ novaTransacao.getTransacaoTipo().getTipoOperacaoString() + " conta de número "
				+ novaTransacao.getNumConta() + " realizado em " + novaTransacao.getData() + ".");

	}

}
