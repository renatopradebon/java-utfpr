Exercícios
Exercícios

Teste o problema de deadlock quando é utilizado o locking pessimista. Adicione a seguinte classe no pacote testes.

public class TestaDeadLock {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("K21_topicos_avancados");
EntityManager manager1 = factory.createEntityManager();
EntityManager manager2 = factory.createEntityManager();
manager1.getTransaction().begin();
manager2.getTransaction().begin();
manager1.find(Produto.class, 100L, LockModeType.PESSIMISTIC_WRITE);
manager2.find(Produto.class, 100L, LockModeType.PESSIMISTIC_WRITE);
manager1.getTransaction().commit();
manager2.getTransaction().commit();
manager1.close();
manager2.close();
factory.close();
}
}

Execute e aguarde até ocorrer uma exception.
