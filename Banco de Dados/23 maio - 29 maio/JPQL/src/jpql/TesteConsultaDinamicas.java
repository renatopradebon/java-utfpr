package jpql;

import java.util.List;
import java.util.Collection;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConsultaDinamicas {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpql");
		EntityManager manager = factory.createEntityManager();
		
		String sql = "select a from Autor a";

		Query query = manager.createQuery(sql);
		
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
