package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitymanager.Estado;
import entitymanager.Governador;

public class AdicionaGovernadorEstado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		Governador governador = new Governador();
		governador.setNome("Rafael Cosentino");

		Estado estado = new Estado();
		estado.setNome("São Paulo");
		governador.setEstado(estado);
		estado.setGovernador(governador);

		manager.persist(estado);
		manager.persist(governador);

		Governador governador2 = new Governador();
		governador2.setNome("André Puccinelli");

		Estado estado2 = new Estado();
		estado2.setNome("Mato Grosso do Sul");
		governador2.setEstado(estado2);
		estado2.setGovernador(governador2);

		manager.persist(estado2);
		manager.persist(governador2);

		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}

}
