package helloworld.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import helloworld.modelos.Livro;

public class RESTClient04 {

	private static Client cliente;
	private static String path;

	public static void iniciaParametros() {
		cliente = Client.create();
		path = "http://localhost:3000/livro";
	}

	public static void main(String[] args) {
		RESTClient04.iniciaParametros();

		String idLivro = "/1234";
		RESTClient04.atualizaLivro(path + idLivro);
	}

	private static void atualizaLivro(String pathCompleto) {
		WebResource resource = cliente.resource(pathCompleto);
		Livro livro = resource.get(Livro.class);

		livro.setAutor("Renato Pradebon");
		Livro retornoLivro = resource.put(Livro.class, livro);
		System.out.println("Resultado => " + retornoLivro.getAutor());
	}

}
