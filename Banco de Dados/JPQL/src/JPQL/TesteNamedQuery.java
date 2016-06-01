package JPQL;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteNamedQuery {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpql");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("Autor.findAll");

		List<Autor> autores = query.getResultList();

		for (Autor autor : autores) {
			System.out.println("Autor: " + autor.getNome());
			Collection<Livro> livros = autor.getLivros();
			for (Livro livro : livros) {
				System.out.println("Livro: " + livro.getNome());
				System.out.println("Preço: " + livro.getPreco());
				System.out.println();
			}
			System.out.println();
		}

		manager.close();
		factory.close();
	}
}
