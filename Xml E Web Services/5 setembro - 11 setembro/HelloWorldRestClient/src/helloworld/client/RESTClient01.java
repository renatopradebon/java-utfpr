package helloworld.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RESTClient01 {

	private static Client cliente;
	private static String path;

	public static void iniciaParametros() {
		cliente = Client.create();
		path = "http://localhost:3000/hello";
	}

	public static void main(String[] args) {
		RESTClient01.iniciaParametros();
		RESTClient01.impimeResource(path);

		String lingua = "/pt-br";
		RESTClient01.impimeResource(path + lingua);
	}

	private static void impimeResource(String pathCompleto) {
		WebResource resource = cliente.resource(pathCompleto);
		String string = resource.get(String.class);
		System.out.println("Resultado => " + string);
	}

}
