package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Conta;

public class TestaAcessoConcorrente {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("topicos_avancados");
		
		EntityManager manager1 = factory.createEntityManager();
		EntityManager manager2 = factory.createEntityManager();
		
		manager1.getTransaction().begin();
		manager2.getTransaction().begin();
		
		Conta conta1 = manager1.find(Conta.class, 1L);
		conta1.setSaldo(conta1.getSaldo() + 500);
		
		Conta conta2 = manager2.find(Conta.class, 1L);
		conta2.setSaldo(conta2.getSaldo() - 500);
		
		manager1.getTransaction().commit();
		manager2.getTransaction().commit();
		
		manager1.close();
//		manager2.close();
		factory.close();
	}
}
