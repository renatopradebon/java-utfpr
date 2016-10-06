package helloworld.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RESTClient02 {

	private static Client cliente;
	private static String path;

	public static void iniciaParametros() {
		cliente = Client.create();
		path = "http://localhost:3000/livro";
	}

	public static void main(String[] args) {
		RESTClient02.iniciaParametros();
		RESTClient02.impimeResource(path);

		String idLivro = "/1234";
		RESTClient02.impimeResource(path + idLivro);
	}

	private static void impimeResource(String pathCompleto) {
		WebResource resource = cliente.resource(pathCompleto);
		String string = resource.get(String.class);
		System.out.println("Resultado => " + string);
	}
}
