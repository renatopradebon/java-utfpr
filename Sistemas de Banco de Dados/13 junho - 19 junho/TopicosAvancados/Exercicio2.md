Exercícios
Acrescente no pacote modelo uma classe para definir contas bancárias.

@Entity
public class Conta {
@Id
@GeneratedValue
private Long id;
private double saldo;
// GETTERS AND SETTERS
}

Adicione uma classe no pacote testes para cadastrar uma conta no banco de dados.

public class AdicionaConta {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("topicos_avancados");
EntityManager manager = factory.createEntityManager();
manager.getTransaction().begin();
Conta c = new Conta();
c.setSaldo(2000);
manager.persist(c);
manager.getTransaction().commit();
manager.close();
factory.close();
}
}

Execute e verifique a tabela Conta

Simule o problema de concorrência entre Entity Managers adicionando a seguinte classe no pacote testes.

public class TestaAcessoConcorrente {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("topicos_avancados");
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
factory.close();
}
}

Execute e verifique que o saldo da conta com identificador 1 termina com 1500 sendo que o correto seria 2000.
