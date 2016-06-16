package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitymanager.Pessoa;

public class TesteManaged {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");

		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();

		// managed
		Pessoa pessoa = manager.find(Pessoa.class, 2L);
		// altera conteudo do objeto
		pessoa.setNome("Renato Sotolani Pradebon");
		//sincronizando objeto com o banco
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
	}

}
