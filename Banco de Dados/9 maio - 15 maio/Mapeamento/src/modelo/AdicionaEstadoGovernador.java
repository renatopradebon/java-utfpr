package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaEstadoGovernador {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		// governador
		Governador governador = new Governador();		
		governador.setNome("André Puccinelli");
		
		// estado
		Estado estado = new Estado();
		estado.setNome("Mato Grosso do Sul");
		estado.setGovernador(governador);
		
		manager.persist(governador);
		manager.persist(estado);		
		
		manager.getTransaction().commit();
		manager.close();

		factory.close();
	}

}
