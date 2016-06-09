package criteria;

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
public class CalculaMediaDosPrecosDosLivros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("criteria");
		EntityManager manager = factory.createEntityManager();

		CriteriaBuilder criteriabuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Double> criteria = criteriabuilder.createQuery(Double.class);

		Root<Livro> livro = criteria.from(Livro.class);

		criteria.select(criteriabuilder.avg(livro.<Double> get("preco")));

		TypedQuery<Double> query = manager.createQuery(criteria);

		Double media = query.getSingleResult();
		System.out.println("Média: " + media);

		manager.close();
		factory.close();
	}
}
