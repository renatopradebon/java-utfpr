package utfpr.prova.bancodedados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TesteTypedQuerie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");
		EntityManager manager = factory.createEntityManager();

		CriteriaBuilder criteriabuilder = manager.getCriteriaBuilder();

		CriteriaQuery<Funcionario> criteria = criteriabuilder.createQuery(Funcionario.class);

		Root<Funcionario> funcionario = criteria.from(Funcionario.class);

		criteria.select(funcionario);

		TypedQuery<Funcionario> query = manager.createQuery(criteria);

		List<Funcionario> funcionarios = query.getResultList();

		for (Funcionario funcionarioLista : funcionarios) {
			System.out.println(funcionarioLista);
		}
	}

}
