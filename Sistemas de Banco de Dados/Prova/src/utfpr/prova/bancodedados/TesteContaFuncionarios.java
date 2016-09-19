package utfpr.prova.bancodedados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteContaFuncionarios {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");
		EntityManager manager = factory.createEntityManager();

		TypedQuery<Long> query = manager.createQuery("select count(funcionario.id) from Funcionario funcionario", Long.class);

		Long totalFuncionarios = query.getSingleResult();

		System.out.println("Total de Funcionários: " + totalFuncionarios);
		manager.close();
		factory.close();
	}

}
