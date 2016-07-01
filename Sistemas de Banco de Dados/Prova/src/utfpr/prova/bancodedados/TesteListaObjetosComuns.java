package utfpr.prova.bancodedados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteListaObjetosComuns {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");
		EntityManager manager = factory.createEntityManager();

		TypedQuery<String> query = manager.createQuery("select funcionario.Nome from Funcionario funcionario", String.class);

		List<String> nomes = query.getResultList();

		for (String nome : nomes) {
			System.out.println(nome);
		}

		manager.close();
		factory.close();
	}

}
