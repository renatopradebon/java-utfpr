package br.com.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.modelo.Carro;

public class CarroDao {

	private static EntityManagerFactory entityManager = null;

	public EntityManagerFactory getFactory() {
		if (CarroDao.entityManager == null) {
			CarroDao.entityManager = Persistence.createEntityManagerFactory("frameworks");
		}

		return CarroDao.entityManager;
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

	public Integer save(Carro carro) {
		try {
			EntityManager manager = this.getFactory().createEntityManager();

			// ABRINDO A TRASACAO
			manager.getTransaction().begin();

			// OBJETO NO ESTADO MANAGED
			manager.persist(carro);

			// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
			manager.getTransaction().commit();

			// System.out.println("Pessoa id: " + carro.getCodCarro());

			manager.close();

			return carro.getId();
			// factory.close();
		} catch (Exception e) {
			System.err.println("Erro no banco = " + e);
		}
		return null;
	}

	public String remove(Carro carro) {
		try {
			EntityManager manager = this.getFactory().createEntityManager();

			Carro carroRemove = manager.find(Carro.class, carro.getCodCarro());

			manager.getTransaction().begin();

			manager.remove(manager.contains(carroRemove) ? carroRemove : manager.merge(carroRemove));

			manager.getTransaction().commit();

			manager.close();

			return "Carro removido com sucesso!";
			// factory.close();
		} catch (Exception e) {
			System.err.println("Erro no banco = " + e);
		}
		return null;
	}

	public String update(Carro carro) {

		try {
			EntityManager manager = this.getFactory().createEntityManager();

			Carro carroUpdate = manager.find(Carro.class, carro.getCodCarro());

			manager.getTransaction().begin();

			carroUpdate.setPlaca(carro.getPlaca());
			carroUpdate.setProprietario(carro.getProprietario());

			manager.getTransaction().commit();

			manager.close();

			return "Carro removido com sucesso!";
			// factory.close();
		} catch (Exception e) {
			System.err.println("Erro no banco = " + e);
		}
		return null;
	}

}
