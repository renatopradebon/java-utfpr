Exercícios
Exercícios

Crie um projeto no eclipse chamado Criteria. Copie a pasta lib do projeto EntityManager para o projeto Criteria. Depois selecione todos os jar’s e os adicione no classpath.
Abra o MySQL Query Browser e crie a base de dados criteria.
Copie a pasta META-INF do projeto EntityManager para dentro da pasta src do projeto Criteria. Altere o arquivo persistence.xml do projeto Criteria, modificando o nome da unidade de persistência e a base da dados.
Crie um pacote chamado modelo no projeto Criteria e adicione as seguintes classes:

@Entity
public class Autor {
@Id @GeneratedValue
private Long id;
private String nome;
@ManyToMany
private Collection<Livro> livros = new ArrayList<Livro>();
// GETTERS E SETTERS
}

@Entity
public class Livro {
@Id @GeneratedValue
private Long id;
private String nome;
private Double preco;
// GETTERS E SETTERS
}

Carregue o banco de dados com as informações de alguns livros e autores. Adicione a seguinte classe em um novo pacote chamado testes. Você pode copiar a classe PopulaBanco criada no projeto JPQL e alterar a unidade de persistência.
public class PopulaBanco {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("K21_criteria");
EntityManager manager = factory.createEntityManager();
manager.getTransaction().begin();
Livro livro1 = new Livro();
livro1.setNome("The Battle for Your Mind");
livro1.setPreco(20.6);
manager.persist(livro1);
Livro livro2 = new Livro();
livro2.setNome("Differentiate or Die");
livro2.setPreco(15.8);
manager.persist(livro2);
Livro livro3 = new Livro();
livro3.setNome("How to Transform Your Ideas");
livro3.setPreco(32.7);
manager.persist(livro3);
Livro livro4 = new Livro();
livro4.setNome("Digital Fortress");
livro4.setPreco(12.9);
manager.persist(livro4);
Livro livro5 = new Livro();
livro5.setNome("Marketing in an Era of Competition, Change and Crisis");
livro5.setPreco(26.8);
manager.persist(livro5);
Autor autor1 = new Autor();
autor1.setNome("Patrick Cullen");
autor1.getLivros().add(livro2);
autor1.getLivros().add(livro4);
manager.persist(autor1);
Autor autor2 = new Autor();
autor2.setNome("Fraser Seitel");
autor2.getLivros().add(livro3);
manager.persist(autor2);
Autor autor3 = new Autor();
autor3.setNome("Al Ries");
autor3.getLivros().add(livro1);
manager.persist(autor3);
Autor autor4 = new Autor();
autor4.setNome("Jack Trout");
autor4.getLivros().add(livro1);
autor4.getLivros().add(livro2);
autor4.getLivros().add(livro5);
manager.persist(autor4);
Autor autor5 = new Autor();
autor5.setNome("Steve Rivkin");
autor5.getLivros().add(livro2);
autor5.getLivros().add(livro3);
autor5.getLivros().add(livro5);
manager.persist(autor5);
manager.getTransaction().commit();
manager.close();
factory.close();
}
}

Teste a Criteria API criando uma consulta para recuperar todos os livros cadastrados no banco de dados. Crie a seguinte classe no pacote testes.
public class TesteCriteria {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("criteria");
EntityManager manager = factory.createEntityManager();
CriteriaBuilder cb = manager.getCriteriaBuilder();
CriteriaQuery<Livro> c = cb.createQuery(Livro.class);
Root<Livro> l = c.from(Livro.class);
c.select(l);
TypedQuery<Livro> query = manager.createQuery(c);
List<Livro> livros = query.getResultList();
for (Livro livro : livros) {
System.out.println(livro.getNome());
}
}
}

(Opcional) Crie uma consulta utilizando a Criteria API para recuperar todos os autores.
