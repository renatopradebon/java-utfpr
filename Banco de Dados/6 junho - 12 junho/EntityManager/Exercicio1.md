Exercícios

Crie um projeto no chamado EntityManager. Copie a pasta lib do projeto JPA2-Hibernate para o projeto EnityManager. Depois selecione todos os jar’s e os adicione no classpath.
Abra o MySQL Query Browser e crie a base de dados entity_manager.
Copie a pasta META-INF do projeto JPA2-Hibernate para dentro da pasta src do projeto EntityManager. Altere o arquivo persistence.xml do projeto EntityManager, modificando o nome da unidade de persistência e a base da dados.


Crie um pacote chamado modelo no projeto EntityManager e adicione a seguinte classe:
@Entity
public class Pessoa {
@Id @GeneratedValue
private Long id;
private String nome;
// GETTERS E SETTERS
}
Teste persistir objetos através de um Entity Manager. Crie uma classe chamada TestePersist dentro de um pacote chamado testes.

public class TestePersist {
public static void main(String[] args) {
EntityManagerFactory factory =
Persistence.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
// ABRINDO A TRASACAO
manager.getTransaction().begin();
// OBJETO NO ESTADO NEW
Pessoa p = new Pessoa();
p.setNome("Rafael Cosentino");
// OBJETO NO ESTADO MANAGED
manager.persist(p);
// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
manager.getTransaction().commit();
System.out.println("Pessoa id: " + p.getId());
manager.close();
factory.close();
}
}

Execute e consulte o banco de dados!

Teste buscar objetos através de um Entity Manager dado a identidade dos objetos. Crie uma classe chamada TesteFind dentro de um pacote testes.
public class TesteFind {
public static void main(String[] args) {
EntityManagerFactory factory =
Persistence.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
// OBJETO NO ESTADO MANAGED
Pessoa p = manager.find(Pessoa.class, 1L);
System.out.println("Id: " + p.getId());
System.out.println("Nome: " + p.getNome());
manager.close();
factory.close();
}
}

Execute e consulte o banco de dados!

Teste alterar objetos no estado managed e depois faça um sincronização com o banco de dados através de uma chamada ao método COMMIT (). Crie uma classe chamada TesteManaged dentro de um pacote testes.
public class TesteManaged {
public static void main(String[] args) {
EntityManagerFactory factory =
Persistence.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
manager.getTransaction().begin();
// OBJETO NO ESTADO MANAGED
Pessoa p = manager.find(Pessoa.class, 1L);
// ALTERANDO O CONTEUDO DO OBJETO
p.setNome("Marcelo Martins");
// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
manager.getTransaction().commit();
manager.close();
factory.close();
}
}

Execute e consulte o banco de dados!

Teste alterar objetos no estado detached e depois faça um sincronização com o banco de dados através de uma chamada ao método COMMIT (). Crie uma classe chamada TesteDetached dentro de um pacote testes.

public class TesteDetached {
public static void main(String[] args) {
EntityManagerFactory factory =
Persistence.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
manager.getTransaction().begin();
// OBJETO NO ESTADO MANAGED
Pessoa p = manager.find(Pessoa.class, 1L);
// OBJETO NO ESTADO DETACHED
manager.detach(p);
// ALTERANDO O CONTEUDO DO OBJETO
p.setNome("Marcelo Martins");
// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
manager.getTransaction().commit();
manager.close();
factory.close();
}
}

Execute e consulte o banco de dados!
