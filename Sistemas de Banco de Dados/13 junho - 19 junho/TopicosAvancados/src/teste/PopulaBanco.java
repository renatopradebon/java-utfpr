package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import topicosavancados.Produto;

public class PopulaBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("topicos_avancados");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		for (int i = 0; i < 100; i++) {
			Produto p = new Produto();
			
			p.setNome("produto " + i);
			p.setPreco(i * 10.0);
			
			manager.persist(p);
		}

		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}

}
