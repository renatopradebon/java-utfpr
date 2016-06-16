package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitymanager.Pessoa;

public class TesteLazyInicialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");

		EntityManager manager = factory.createEntityManager();
		
//		System.out.println("-----------CHAMANDO O FIND------------");
		// objeto carregado em modo lazy
		Pessoa pessoa = manager.find(Pessoa.class, 2L);
//		System.out.println("----------- fez o select ------------");
		
		manager.close();
		factory.close();
		
		System.out.println(pessoa.getNome());
	}

}
