package br.com.utfpr.rest.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManager {

	private final EntityManagerFactory factory;
	private final EntityManager em;

	public JpaEntityManager() {
		super();
		this.factory = Persistence.createEntityManagerFactory("utfpr_notas");
		this.em = factory.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return em;
	}
}