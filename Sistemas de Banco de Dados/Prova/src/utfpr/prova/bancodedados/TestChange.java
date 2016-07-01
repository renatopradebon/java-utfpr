package utfpr.prova.bancodedados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
				
		Cargo cargo = manager.find(Cargo.class, 1L);
		cargo.setCargo("Desenvolvedor1");
//		manager.persist(cargo);
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();

		// managed
		Funcionario funcionario = manager.find(Funcionario.class, 3L);
		// altera conteudo do objeto
		funcionario.setNome("Vityor");
		funcionario.setTelefone("45-99443541");
		funcionario.setCargo(cargo);
		
		// sincronizando objeto com o banco
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}

}
