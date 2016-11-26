package br.com.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.modelo.Carro;
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

	public Integer save(Proprietario proprietario) {
		try {
			EntityManager manager = this.getFactory().createEntityManager();

			// ABRINDO A TRASACAO
			manager.getTransaction().begin();

			// OBJETO NO ESTADO MANAGED
			manager.persist(proprietario);

			// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
			manager.getTransaction().commit();

			manager.close();

			return proprietario.getId();
			// factory.close();
		} catch (Exception e) {
			System.err.println("Erro no banco = " + e);
		}
		return null;
	}

	public String remove(Proprietario proprietario) {
		try {
			EntityManager manager = this.getFactory().createEntityManager();

			Proprietario proprietarioRemove = manager.find(Proprietario.class, proprietario.getCodProprietario());

			manager.getTransaction().begin();

			manager.remove(manager.contains(proprietarioRemove) ? proprietarioRemove : manager.merge(proprietarioRemove));

			manager.getTransaction().commit();

			manager.close();

			return "Proprietário removido com sucesso!";
			// factory.close();
		} catch (Exception e) {
			System.err.println("Erro no banco = " + e);
		}
		return null;
	}

	public String update(Proprietario proprietario) {

		try {
			EntityManager manager = this.getFactory().createEntityManager();

			Proprietario proprietarioUpdate = manager.find(Proprietario.class, proprietario.getCodProprietario());

			manager.getTransaction().begin();

			proprietarioUpdate.setNome(proprietario.getNome());			

			manager.getTransaction().commit();

			manager.close();

			return "Proprietário atualizado com sucesso!";
			// factory.close();
		} catch (Exception e) {
			System.err.println("Erro no banco = " + e);
		}
		return null;
	}

}
