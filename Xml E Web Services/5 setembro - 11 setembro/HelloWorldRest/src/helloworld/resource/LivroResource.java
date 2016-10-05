package helloworld.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import helloworld.dao.LivroDAO;
import helloworld.modelos.Livro;

@Path("livro")
public class LivroResource {

	LivroDAO livro;

	public LivroResource() {
		setLivro(new LivroDAO());
	}

	public LivroDAO getLivro() {
		return livro;
	}

	public void setLivro(LivroDAO livro) {
		this.livro = livro;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public List<Livro> getTodosLivros() {
		return getLivro().getLivros();
	}

	@Path("{idLivro}")
	@GET
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public Livro getLivroById(@PathParam("idLivro") long id) {
		System.out.println("Teste => " + id);
		return getLivro().getLivro(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public Livro addLivro(Livro livro) {

		getLivro().salvar(livro);
		return livro;
	}

	@Path("{idLivro}")
	@PUT
	@Consumes(MediaType.APPLICATION_XML + ";charset=utf-8")
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public Livro atualizarLivro(@PathParam("idLivro") long id, Livro livro) {

		return getLivro().atualizar(id, livro);
	}

	@Path("{idLivro}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
	public String apagarLivro(@PathParam("idLivro") long id) {
		return getLivro().apagar(id);
	}
}
