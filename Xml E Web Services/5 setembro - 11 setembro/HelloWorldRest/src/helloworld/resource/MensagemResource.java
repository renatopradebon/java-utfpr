package helloworld.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import helloworld.modelos.Mensagem;

@Path("mensagem")
public class MensagemResource {

	@Path("xml")
	@GET
	@Produces(MediaType.TEXT_XML + ";charset=utf-8")
	public Mensagem getMensagem(@QueryParam("de") String de, @QueryParam("para") String para,
			@QueryParam("conteudo") String conteudo) {

		Mensagem mensagem = new Mensagem();
		mensagem.setId(System.currentTimeMillis());
		mensagem.setDe(de);
		mensagem.setPara(para);
		mensagem.setConteudo(conteudo);

		return mensagem;
	}

	@Path("json")
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Mensagem getMensagemJson(@QueryParam("de") String de, @QueryParam("para") String para,
			@QueryParam("conteudo") String conteudo) {
		return getMensagem(de, para, conteudo);
	}
}
