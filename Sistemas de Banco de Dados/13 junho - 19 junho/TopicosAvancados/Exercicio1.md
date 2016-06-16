Exercícios
Crie um projeto no eclipse chamado TopicosAvancados. Copie a pasta lib do projeto EntityManager para o projeto TopicosAvancados. Depois selecione todos os jar’s e os adicione no classpath.
Abra o MySQL Query Browser e crie a base de dados topicos_avancados.
Copie a pasta META-INF do projeto EntityManager para dentro da pasta src do projeto TopicosAvancados. Altere o arquivo persistence.xml do projeto TopicosAvancados, modificando o nome da unidade de persistência e a base da dados.
Crie um pacote chamado modelo no projeto TopicosAvancados e adicione a seguinte classe:

@Entity
public class Produto {
@Id @GeneratedValue
private Long id;
private String nome;
private Double preco;
// GETTERS E SETTERS
}

Adicione alguns produtos no banco de dados.
Crie a seguinte classe em um pacote chamado testes no projeto TopicosAvancados.

public class PopulaBanco {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("topicos_avancados");
EntityManager manager = factory.createEntityManager();
manager.getTransaction().begin();
for (int i = 0; i < 100; i++) {
Produto p = new Produto();
p.setNome("produto " + i);
p.setPreco(i * 10.0);
manager.persist(p);
}
manager.getTransaction().commit();
manager.close();
factory.close();
}
}

Execute e verifique a tabela produto na base de dados topicos_avancados.
Faça uma operação em lote para atualizar o preço de todos os produtos de acordo com uma taxa fixa.

public class AumentaPreco {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("topicos_avancados");
EntityManager manager = factory.createEntityManager();
manager.getTransaction().begin();
Query query = manager
.createQuery("UPDATE Produto p SET p.preco = p.preco * 1.1");
query.executeUpdate();
manager.getTransaction().commit();
manager.close();
factory.close();
}
}

Execute e verifique a tabela produto na base de dados topicos_avancados.
Observe também o console. Nenhum select é realizado.
Faça uma operação em lote para remover todos os produtos com preço menor do que um valor fixo.

public class RemoveProdutos {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("topicos_avancados");
EntityManager manager = factory.createEntityManager();
manager.getTransaction().begin();
Query query = manager
.createQuery("DELETE Produto p WHERE p.preco < 50");
query.executeUpdate();
manager.getTransaction().commit();
manager.close();
factory.close();
}
}

Execute e verifique a tabela produto na base de dados topicos_avancados.
Observe também o console. Nenhum select é realizado.
