package br.com.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.modelo.Proprietario;

public class ProprietarioDao {

	private static EntityManagerFactory entityManager = null;

	public EntityManagerFactory getFactory() {
		if (ProprietarioDao.entityManager == null) {
			ProprietarioDao.entityManager = Persistence.createEntityManagerFactory("frameworks");
		}

		return ProprietarioDao.entityManager;
	}

	public List<Proprietario> busca() {
		EntityManager entityManager = this.getFactory().createEntityManager();

		TypedQuery<Proprietario> query = entityManager.createQuery("select p from Proprietario p", Proprietario.class);

		List<Proprietario> proprietarios = query.getResultList();

		return proprietarios;
	}

	public Proprietario getProprietario(int codProprietario) {
		EntityManager entityManager = this.getFactory().createEntityManager();

		Query query = entityManager.createNamedQuery("Proprietario.findByCod");

		query.setParameter("cod_proprietario", codProprietario);

		return (Proprietario) query.getSingleResult();
	}

	public void save(Proprietario proprietario) {
		EntityManager manager = this.getFactory().createEntityManager();

		// ABRINDO A TRASACAO
		manager.getTransaction().begin();

		// OBJETO NO ESTADO MANAGED
		manager.persist(proprietario);

		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();

		manager.close();
		// factory.close();
	}

}
