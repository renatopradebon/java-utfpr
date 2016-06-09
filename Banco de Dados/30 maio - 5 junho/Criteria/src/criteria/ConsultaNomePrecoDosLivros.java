package criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author Renato Pradebon
 *
 */
public class ConsultaNomePrecoDosLivros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("criteria");
		EntityManager manager = factory.createEntityManager();

		CriteriaBuilder criteriabuilder = manager.getCriteriaBuilder();

		CriteriaQuery<Tuple> criteria = criteriabuilder.createQuery(Tuple.class);

		Root<Livro> livro = criteria.from(Livro.class);

		criteria.multiselect(livro.<String> get("nome").alias("livro.nome"),
				livro.<Double> get("preco").alias("livro.preco"));

		TypedQuery<Tuple> query = manager.createQuery(criteria);
		List<Tuple> livros = query.getResultList();

		for (Tuple registro : livros) {
			System.out.println("Livro: " + registro.get("livro.nome"));
			System.out.println("Preço: " + registro.get("livro.preco"));
			System.out.println("--------------------------------------");
		}

		manager.close();
		factory.close();
	}
}
