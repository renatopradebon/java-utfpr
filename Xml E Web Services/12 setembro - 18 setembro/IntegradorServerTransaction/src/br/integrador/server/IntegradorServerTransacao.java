package br.integrador.server;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class IntegradorServerTransacao {

	public static void main(String[] args) {
		try {
			HttpServer server = HttpServerFactory.create("http://localhost:3000/");

			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
