package helloworld.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	public String getHello() {
		return "Hello World!!";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	@Path("pt-br")
	public String getHelloPortugues() {
		return "Olá mundo!!";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	@Path("de")
	public String getHelloAlemano() {
		return "Hallo Welt!!";
	}
	
}
