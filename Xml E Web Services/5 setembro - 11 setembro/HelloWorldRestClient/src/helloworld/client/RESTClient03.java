package helloworld.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import helloworld.modelos.Livro;

public class RESTClient03 {

	private static Client cliente;
	private static String path;

	public static void iniciaParametros() {
		cliente = Client.create();
		path = "http://localhost:3000/livro";
	}

	public static void main(String[] args) {
		RESTClient03.iniciaParametros();

		String idLivro = "/1234";
		RESTClient03.impimeResource(path + idLivro);
		
		RESTClient03.imprimeResourceCompleto(path);
	}

	private static void impimeResource(String pathCompleto) {
		WebResource resource = cliente.resource(pathCompleto);
		Livro livro = resource.get(Livro.class);
		System.out.println("Resultado => " + livro.toString());
	}
	
	private static void imprimeResourceCompleto(String pathCompleto) {
		WebResource resource = cliente.resource(pathCompleto);
		Livro[] livros = resource.get(Livro[].class);
		System.out.println("Resultado => " + livros.length);
	}
}
