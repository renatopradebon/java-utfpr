package utfpr.exercicio7.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaModel {

	private static EntityManagerFactory entityManager = null;

	public EntityManagerFactory getFactory() {
		if (PessoaModel.entityManager == null) {
			PessoaModel.entityManager = Persistence.createEntityManagerFactory("servlet");
		}

		return PessoaModel.entityManager;
	}

	public List<Pessoa> busca(String nome) {
		EntityManager entityManager = this.getFactory().createEntityManager();

		List<Pessoa> resultList = entityManager.createQuery("select P from Pessoa P where P.nome like :nome")
				.setParameter("nome", nome + "%").getResultList();

		return resultList;
	}

	public void save(Pessoa pessoa) {
		EntityManager manager = this.getFactory().createEntityManager();

		// ABRINDO A TRASACAO
		manager.getTransaction().begin();

		// OBJETO NO ESTADO MANAGED
		manager.persist(pessoa);

		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();

		System.out.println("Pessoa id: " + pessoa.getId());

		manager.close();
		// factory.close();
	}
}