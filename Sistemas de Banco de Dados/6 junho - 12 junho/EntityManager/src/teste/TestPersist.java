package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitymanager.Pessoa;

public class TestPersist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");
		EntityManager manager = factory.createEntityManager();

		// ABRINDO A TRASACAO
		manager.getTransaction().begin();

		// OBJETO NO ESTADO NEW
		Pessoa p = new Pessoa();
		p.setNome("Rafael Cosentino");
		// OBJETO NO ESTADO MANAGED
		manager.persist(p);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Renato Pradebon");
		manager.persist(pessoa2);

		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();

		System.out.println("Pessoa id: " + p.getId());

		manager.close();
		factory.close();
	}
}
