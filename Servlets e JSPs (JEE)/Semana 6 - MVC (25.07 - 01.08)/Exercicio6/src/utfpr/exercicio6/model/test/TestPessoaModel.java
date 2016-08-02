package utfpr.exercicio6.model.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utfpr.exercicio6.model.Pessoa;

public class TestPessoaModel {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("servlet");
		EntityManager manager = factory.createEntityManager();

		// ABRINDO A TRASACAO
		manager.getTransaction().begin();

		// OBJETO NO ESTADO NEW
		Pessoa p = new Pessoa();
		p.setNome("Rafael Cosentino");
		p.setIdade(25);
		p.setSexo("M");
		// OBJETO NO ESTADO MANAGED
		manager.persist(p);

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Renato Pradebon");
		pessoa2.setIdade(27);
		pessoa2.setSexo("M");
		manager.persist(pessoa2);

		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();

		System.out.println("Pessoa id: " + p.getId());

		manager.close();
		factory.close();

	}

}
