package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitymanager.Estado;

public class TestePersistenceContext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");

		EntityManager manager = factory.createEntityManager();

		System.out.println("------------------PRIMEIRO FIND-----------------");
		
		Estado estado = manager.find(Estado.class, 2L);
		
		System.out.println("------------------SEGUNDO FIND------------------");
		
		estado = manager.find(Estado.class, 2L);		

//		manager.close();
//		factory.close();

	}

}
