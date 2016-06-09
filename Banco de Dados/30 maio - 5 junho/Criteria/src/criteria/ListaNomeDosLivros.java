package criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author Renato Pradebon
*
*/
public class ListaNomeDosLivros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("criteria");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder criteriabuilder = manager.getCriteriaBuilder();
		CriteriaQuery<String> criteria = criteriabuilder.createQuery(String.class);
		
		Root<Livro> livro = criteria.from(Livro.class);
		criteria.select(livro.<String> get("nome"));
		
		TypedQuery<String> query = manager.createQuery(criteria);
		List<String> livros = query.getResultList();
		
		for (String livroLista : livros) {
			System.out.println("Livro: " + livroLista);
		}
		
		manager.close();
		factory.close();
	}
}
