package br.com.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.modelo.Carro;

public class CarroDAO {

	private static EntityManagerFactory entityManager = null;

	public EntityManagerFactory getFactory() {
		if (CarroDAO.entityManager == null) {
			CarroDAO.entityManager = Persistence.createEntityManagerFactory("frameworks");
		}

		return CarroDAO.entityManager;
	}

	public List<Carro> busca() {
		EntityManager entityManager = this.getFactory().createEntityManager();

		TypedQuery<Carro> query = entityManager.createQuery("select carro from Carro carro", Carro.class);

		List<Carro> livros = query.getResultList();

		return livros;
	}

	public Carro getCarro(int codCarro) {
		EntityManager entityManager = this.getFactory().createEntityManager();

		Query query = entityManager.createNamedQuery("Carro.findByCod");

		query.setParameter("cod_carro", codCarro);

		return (Carro) query.getSingleResult();
	}

	public void save(Carro carro) {
		EntityManager manager = this.getFactory().createEntityManager();

		// ABRINDO A TRASACAO
		manager.getTransaction().begin();

		// OBJETO NO ESTADO MANAGED
		manager.persist(carro);

		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();

		// System.out.println("Pessoa id: " + carro.getCodCarro());

		manager.close();
		// factory.close();
	}

}
