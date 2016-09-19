package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteConsultaLivroPrecoMedio {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpql");
		EntityManager manager = factory.createEntityManager();
		
		TypedQuery<Double> query = manager.createQuery("select avg(livro.preco) from Livro livro", Double.class);
		
		Double precoMedio = query.getSingleResult();
		
		System.out.println("Preço médio: " + precoMedio);
		manager.close();
		factory.close();
	}
}
