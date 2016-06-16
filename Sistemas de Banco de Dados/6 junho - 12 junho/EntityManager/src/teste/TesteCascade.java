package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitymanager.Estado;
import entitymanager.Governador;

public class TesteCascade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");
		
		EntityManager manager = factory.createEntityManager();
		
		Governador governador = new Governador();		
		governador.setNome("Beto Richa");
		
		Estado estado = new Estado();
		estado.setNome("Paraná");
		
		governador.setEstado(estado);
		
		estado.setGovernador(governador);
		
		manager.getTransaction().begin();
		
		manager.persist(estado);
		manager.getTransaction().commit();
	}

}
