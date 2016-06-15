package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitymanager.Pessoa;

public class TesteDetached {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		// managed
		Pessoa pessoa = manager.find(Pessoa.class, 2L);

		// detached
		manager.detach(pessoa);

		pessoa.setNome("Renato S. Pradebon");

		manager.getTransaction().commit();

		manager.close();
		factory.close(); 
	}
}