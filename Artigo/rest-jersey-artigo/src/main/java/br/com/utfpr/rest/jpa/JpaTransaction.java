package br.com.utfpr.rest.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.utfpr.rest.entity.aluno.Aluno;
import br.com.utfpr.rest.entity.aluno.Notas;

public class JpaTransaction {

	private JpaEntityManager jpa;
	private EntityManager entityManager;

	public JpaTransaction() {
		this.jpa = new JpaEntityManager();
		this.entityManager = jpa.getEntityManager();
	}

	public Aluno saveAluno(Aluno aluno) {

		try {
			entityManager.getTransaction().begin();

			if (aluno.getId() != null) {
				entityManager.merge(aluno);
			} else {
				entityManager.persist(aluno);
			}

			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		return aluno;
	}

	public Aluno updateAluno(Aluno aluno) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(aluno);
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return aluno;
	}

	public Aluno getAluno(Long idAluno) {
		Aluno aluno = new Aluno();

		try {
			aluno = entityManager.find(Aluno.class, idAluno);
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		return aluno;
	}

	public String deleteAluno(Long idAluno) {
		try {
			Aluno aluno = getAluno(idAluno);
			entityManager.getTransaction().begin();
			entityManager.remove(aluno);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return "REMOVED";
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return "ERROR";
		}
	}

	public List<Aluno> listAlunos() {
		List<Aluno> alunos = new ArrayList<>();

		try {
			String query = "select a from Aluno a";
			alunos = entityManager.createQuery(query, Aluno.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return alunos;
	}

	public List<Notas> listNotas(Long idAluno) {
		List<Notas> notas = new ArrayList<>();

		try {
			notas = getAluno(idAluno).getNotas();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		return notas;
	}
}
