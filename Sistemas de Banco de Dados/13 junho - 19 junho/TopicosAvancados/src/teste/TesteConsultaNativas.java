package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Produto;

public class TesteConsultaNativas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("topicos_avancados");

		EntityManager manager = factory.createEntityManager();

		String sql = "SELECT * FROM produto ORDER BY produto.id";

		Query nativeQuery = manager.createNativeQuery(sql, Produto.class);

		List<Produto> produtos = nativeQuery.getResultList();

		for (Produto p : produtos) {
			System.out.println(p.getNome());
		}

		manager.close();

		factory.close();
	}
}