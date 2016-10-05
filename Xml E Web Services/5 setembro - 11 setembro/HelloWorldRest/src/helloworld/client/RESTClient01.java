package helloworld.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RESTClient01 {

	public static void main(String[] args) {
		Client cliente = Client.create();
		
		WebResource resource = cliente.resource("http://localhost:3000/hello");		
		String string = resource.get(String.class);		
		System.out.println("Resultado => " + string);
		
		String lingua = "/pt-br";
		resource = cliente.resource("http://localhost:3000/hello" + lingua);
		string = resource.get(String.class);		
		System.out.println("Resultado => " + string);

	}

}
