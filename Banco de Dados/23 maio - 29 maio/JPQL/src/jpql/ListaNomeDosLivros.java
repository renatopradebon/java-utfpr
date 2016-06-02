package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ListaNomeDosLivros {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpql");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
	
		CriteriaQuery<String> c = cb.createQuery(String.class);
	
		Root<Livro> livro = c.from(Livro.class);
		
		c.select(livro.<String> get("nome"));
	
		TypedQuery<String> query = manager.createQuery(c);

		List<String> nomes = query.getResultList();
	
		
		for (String nome : nomes) {
			System.out.println("Livro: " + nome);
		}
		manager.close();
		factory.close();
	}
}
