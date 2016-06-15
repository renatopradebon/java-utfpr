package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitymanager.Pessoa;

public class TesteFind {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");

		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();

		// managed
		Pessoa pessoa = manager.find(Pessoa.class, 2L);
		
		// verifica se retornou algum resultado
		if (pessoa != null) {
			System.out.println("ID: " + pessoa.getId());
			System.out.println("Nome: " + pessoa.getNome());
		}

		manager.close();
		factory.close();
	}
}
