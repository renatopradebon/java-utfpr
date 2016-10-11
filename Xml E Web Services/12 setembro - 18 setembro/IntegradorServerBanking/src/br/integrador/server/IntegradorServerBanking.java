package br.integrador.server;

import javax.xml.ws.Endpoint;

import br.integrador.implementacoes.BancarioServiceImplements;

public class IntegradorServerBanking {

	public static void main(String[] args) {

		System.out.println("Serviço iniciado - IntegradorServerBanking");
		BancarioServiceImplements servico = new BancarioServiceImplements();
		Endpoint.publish("http://localhost:8080/bancarioservice", servico);

	}

}
