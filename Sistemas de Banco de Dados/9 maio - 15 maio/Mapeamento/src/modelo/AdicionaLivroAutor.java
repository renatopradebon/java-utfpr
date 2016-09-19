package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaLivroAutor {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		// autor
		Autor autor = new Autor();
		autor.setNome("Liliane Caroline");

		// livro
		Livro livro = new Livro();
		livro.setNome("Scrum - A arte de fazer o dobro do trabalho na metado do tempo");
		livro.getAutores().add(autor);

		manager.persist(autor);
		manager.persist(livro);

		manager.getTransaction().commit();
		manager.close();

		factory.close();
	}
}
