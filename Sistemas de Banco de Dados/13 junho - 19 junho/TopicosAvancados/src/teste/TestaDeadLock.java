package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import modelo.Produto;

public class TestaDeadLock {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("topicos_avancados");
		
		EntityManager manager1 = factory.createEntityManager();
		EntityManager manager2 = factory.createEntityManager();
		
		manager1.getTransaction().begin();
		manager2.getTransaction().begin();
		
		manager1.find(Produto.class, 100L, LockModeType.PESSIMISTIC_WRITE);
		manager2.find(Produto.class, 100L, LockModeType.PESSIMISTIC_WRITE);
		
		manager1.getTransaction().commit();
		manager2.getTransaction().commit();
		
		manager1.close();
		manager2.close();
		
		factory.close();
	}
}