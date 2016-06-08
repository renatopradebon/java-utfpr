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
public class TesteCriteriaAutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("criteria");
		EntityManager manager = factory.createEntityManager();

		CriteriaBuilder criteriabuilder = manager.getCriteriaBuilder();

		CriteriaQuery<Autor> criteria = criteriabuilder.createQuery(Autor.class);

		Root<Autor> autor = criteria.from(Autor.class);

		criteria.select(autor);

		TypedQuery<Autor> query = manager.createQuery(criteria);

		List<Autor> autores = query.getResultList();

		for (Autor autorLista : autores) {
			System.out.println(autorLista.getNome());
		}
	}

}
