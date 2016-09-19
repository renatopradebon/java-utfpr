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
public class TesteCriteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("criteria");
		EntityManager manager = factory.createEntityManager();

		CriteriaBuilder criteriabuilder = manager.getCriteriaBuilder();

		CriteriaQuery<Livro> criteria = criteriabuilder.createQuery(Livro.class);

		Root<Livro> livro = criteria.from(Livro.class);

		criteria.select(livro);

		TypedQuery<Livro> query = manager.createQuery(criteria);

		List<Livro> livros = query.getResultList();

		for (Livro livroLista : livros) {
			System.out.println(livroLista.getNome());
		}
	}
}
