package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteTypedQuery {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpql");
		EntityManager manager = factory.createEntityManager();
		
		TypedQuery<Autor> query = manager.createNamedQuery("Autor.findAll", Autor.class);
		
		List<Autor> autores = query.getResultList();
		
		for (Autor autor : autores) {
			System.out.println("Autor: " + autor.getNome());
		}
		
		manager.close();
		factory.close();
	}
}
