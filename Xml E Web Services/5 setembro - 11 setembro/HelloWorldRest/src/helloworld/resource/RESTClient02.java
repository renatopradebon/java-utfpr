package helloworld.resource;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RESTClient02 {

	public static void main(String[] args) {
		String path = "http://localhost:3000/livro";

		Client client = Client.create();

		WebResource resource = client.resource(path);
		String string = resource.get(String.class);
		System.out.println("Resultado => " + string);

		String idLivro = "/1234";
		resource = client.resource(path + idLivro);
		string = resource.get(String.class);
		System.out.println("Resultado => " + string);
	}

}
