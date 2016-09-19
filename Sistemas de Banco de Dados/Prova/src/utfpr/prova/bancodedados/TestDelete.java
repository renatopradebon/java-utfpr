package utfpr.prova.bancodedados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestDelete {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");

		EntityManager manager = factory.createEntityManager();

		Cargo cargo = manager.find(Cargo.class, 3L);
		
		manager.getTransaction().begin();
		manager.remove(cargo);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}

}
