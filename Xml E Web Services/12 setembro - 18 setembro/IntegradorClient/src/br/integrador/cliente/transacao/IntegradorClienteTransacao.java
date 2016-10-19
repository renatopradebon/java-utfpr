package br.integrador.cliente.transacao;

import java.io.StringReader;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.integrador.bd.TransacaoBD;

public class IntegradorClienteTransacao {
	
	private static String pat_html = "http://localhost:3000/transacao";

	private long numConta;

	public IntegradorClienteTransacao() {
		numConta = 0;
	}

	public long getNumConta() {
		return numConta;
	}

	public void setNumConta(long numConta) {
		this.numConta = numConta;
	}

	public TransacaoBD transformaXML(String xml) throws javax.xml.bind.UnmarshalException, JAXBException {
		try {

			JAXBContext context = JAXBContext.newInstance(TransacaoBD.class);
			Unmarshaller um = context.createUnmarshaller();

			StringReader reader = new StringReader(xml);
			TransacaoBD transacoes = (TransacaoBD) um.unmarshal(reader);

			return transacoes;
		} catch (Exception erro) {
			System.out.println("Erro no XML => " + erro);
		}

		return null;
	}

	public TransacaoBD recuperaTransacoes() {
		try {

			Client cliente = Client.create();

			String idConta = getNumConta() > 0 ? "/" + String.valueOf(getNumConta()) : "";

			WebResource resource = cliente.resource(pat_html + idConta);

			ClientResponse response = resource.accept("application/xml").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			resource.type(MediaType.APPLICATION_XML);

			String resourceTeste = resource.get(String.class);

			TransacaoBD transacoes = transformaXML(resourceTeste);

			return transacoes;
		} catch (Exception erro) {
			System.out.println("Erro no resource => " + erro);
		}
		return null;

	}

}
