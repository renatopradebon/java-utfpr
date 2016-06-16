package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteBuscaPagina {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpql");
		EntityManager manager = factory.createEntityManager();
		
		TypedQuery<Livro> query = manager.createQuery("select livro from Livro livro", Livro.class);
		
		query.setFirstResult(2);
		query.setMaxResults(3);
		
		List<Livro> livros = query.getResultList();
		
		for (Livro livro : livros) {
			System.out.println("Livro: " + livro.getNome());
		}
		
		manager.close();
		factory.close();
	}
}
