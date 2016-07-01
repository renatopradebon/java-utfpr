package utfpr.prova.bancodedados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteNamedQuerie {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("Cargo.findAll");

		List<Cargo> cargos = query.getResultList();

		for (Cargo cargo : cargos) {
			System.out.println("Cargo: " + cargo.getCargo());			
		}

		manager.close();
		factory.close();
	}
}