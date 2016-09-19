package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitymanager.Pessoa;

public class TesteGetReferenceLazy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");

		EntityManager manager = factory.createEntityManager();

		System.out.println("-----------CHAMANDO O getReference------------");
		// managed
		Pessoa pessoa = manager.getReference(Pessoa.class, 2L);
		System.out.println("----------- não fez o select ------------");

		manager.close();
		factory.close();

	}

}
