package br.com.utfpr.rest.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.utfpr.rest.entity.aluno.Aluno;

public class JpaTransaction {

	private JpaEntityManager jpa;
	private EntityManager entityManager;

	public JpaTransaction() {
		this.jpa = new JpaEntityManager();
		this.entityManager = jpa.getEntityManager();
	}

	public void saveAluno(Aluno aluno) {

		entityManager.getTransaction().begin();
		
//		if (aluno.getId() != null) {
//			entityManager.merge(aluno);
//		} else {
//			entityManager.persist(aluno);
//		}
		
		entityManager.merge(aluno);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void updateAluno(Aluno aluno) {
		saveAluno(aluno);
	}

	public void deleteAluno(Long idAluno) {

		Aluno aluno = entityManager.find(Aluno.class, idAluno);

		entityManager.getTransaction().begin();
		entityManager.remove(aluno);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public List<Aluno> listAlunos() {

		String query = "select a from Aluno a";

		List<Aluno> alunos = entityManager.createQuery(query, Aluno.class).getResultList();

		entityManager.close();

		return alunos;
	}
}
