package helloworld.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cotacao")
public class CotacaoResource {

	@Path("{moeda1}/{moeda2}")
	@GET
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	public String cotacao(@PathParam("moeda1") String m1, @PathParam("moeda2") String m2) {
		String retorno = "Deve retornar a cotação de " + m1 + " para " + m2;

		return retorno;
	}
}
