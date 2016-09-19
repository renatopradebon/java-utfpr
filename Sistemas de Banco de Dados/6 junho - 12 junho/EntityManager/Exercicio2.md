Exercícios
Acrescente duas propriedades no arquivo de configuração do JPA (persistence.xml) para indicar ao Hibernate que desejamos ver as consultas no console.
<property name="hibernate.show_sql" value="true" />
<property name="hibernate.format_sql" value="true" />

Teste o comportamento do método de busca find(). Crie um classe chamada TesteFindEager no pacote testes.
public class TesteFindEager {
public static void main(String[] args) {
EntityManagerFactory factory =
Persistence.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
System.out.println("-----------CHAMANDO O FIND------------");
Pessoa p = manager.find(Pessoa.class, 1L);
System.out.println("-----------FEZ O SELECT---------------");
manager.close();
factory.close();
}
}

Execute e veja a saída!

Teste o comportamento do método de busca getReference(). Crie um classe chamada TesteGetReferenceLazy no pacote testes.

public class TesteGetReferenceLazy {
public static void main(String[] args) {
EntityManagerFactory factory =
Persistence.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
System.out.println("-----------CHAMANDO O GETREFERENCE----");
Pessoa p = manager.getReference(Pessoa.class, 1L);
System.out.println("-----------NAO FEZ O SELECT-----------");
manager.close();
factory.close();
}
}

Execute e veja a saída!

Teste o problema de Lazy Initialization. Crie um classe chamada TesteLazyInitialization no pacote testes.

public class TesteLazyInitialization {
public static void main(String[] args) {
EntityManagerFactory factory =
Persistence.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
// OBJETO CARREGADO EM MODO LAZY
Pessoa p = manager.getReference(Pessoa.class, 1L);
manager.close();
factory.close();
System.out.println(p.getNome());
}
}

Execute e veja a saída!

Crie duas classes para modelar governadores e estados, estabelecendo um relacionamento One to One entre essas entidades.

@Entity
public class Estado {
@Id @GeneratedValue
private Long id;
private String nome;
@OneToOne
private Governador governador;
// GETTERS AND SETTERS
}

@Entity
public class Governador {
@Id @GeneratedValue
private Long id;
private String nome;
@OneToOne(mappedBy="governador")
private Estado estado;
// GETTERS AND SETTERS
}

Adicione um governador e um estado. Crie uma classe chamada AdicionaGovernadorEstado no pacote testes.

public class AdicionaGovernadorEstado {
public static void main(String[] args) {
EntityManagerFactory factory = Persistence
.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
manager.getTransaction().begin();
Governador governador = new Governador();
governador.setNome("Rafael Cosentino");
Estado estado = new Estado();
estado.setNome("São Paulo");
governador.setEstado(estado);
estado.setGovernador(governador);
manager.persist(estado);
manager.persist(governador);
manager.getTransaction().commit();
manager.close();
factory.close();
}
}

Teste o carregamento EAGER no relacionamento One to One entre estados e governadores. Crie uma classe chamada TesteCarregamentoRelacionamento no pacote testes.

public class TesteCarregamentoRelacionamento {
public static void main(String[] args) {
EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
Estado estado = manager.find(Estado.class, 1L);
}
}

Observe a saída no console para verificar o carregamento tanto do estado quanto do governador

Altere a política padrão do carregamento do governador adicionando a propriedade FETCH na anotação @ONETOONE na classe ESTADO.

@OneToOne(fetch=FetchType.LAZY)
private Governador governador;

Execute novamente a classe TESTE CARREGAMENTO RELACIOMENTO e observe a saída do console para verificar que agora somente o estado é carregado.
Verifique o comportamento dos Entity Managers ao buscar duas vezes o mesmo objeto. Crie uma classe chamada TestePersistenceContext no pacote testes.
public class TestePersistenceContext {
public static void main(String[] args) {
EntityManagerFactory factory = Persistence
.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
System.out.println("------------------PRIMEIRO FIND-----------------");
Estado estado = manager.find(Estado.class, 1L);
System.out.println("------------------SEGUNDO FIND------------------");
estado = manager.find(Estado.class, 1L);
}
}

Execute e observe a saída no console para verificar que o provedor só realiza uma busca.
