package helloworld.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import helloworld.modelos.Livro;

public class RESTClient05 {

	private static Client cliente;
	private static String path;

	public static void iniciaParametros() {
		cliente = Client.create();
		path = "http://localhost:3000/livro";
	}

	public static void main(String[] args) {
		RESTClient05.iniciaParametros();

		String idLivro = "/1234";
		RESTClient05.deleteResource(path + idLivro);

		insereLivro();

	}

	private static void deleteResource(String pathCompleto) {
		WebResource resource = cliente.resource(pathCompleto);
		String mensagem = resource.delete(String.class);
		System.out.println("Resultado => " + mensagem);
	}

	private static void insereLivro() {
		Livro livro = new Livro();

		livro.setAno(1988);
		livro.setAutor("Roger S. Pressman");
		livro.setCodigo(1877);
		livro.setPreco(125.98);
		livro.setTitulo("Engenharia de Software");

		WebResource resource = cliente.resource(path);
		resource.type(MediaType.APPLICATION_XML);
		Livro livroRetorno = resource.post(Livro.class, livro);
		System.out.println("Resultado => " + livroRetorno.getCodigo());
	}
}
