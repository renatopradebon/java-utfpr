Exercícios
Crie um projeto no eclipse chamado JPQL. Copie a pasta lib do projeto EntityManager para o projeto JPQL. Depois selecione todos os jar’s e os adicione no classpath.
Abra o MySQL Query Browser e crie a base de dados jpql.
Copie a pasta META-INF do projeto EntityManager para dentro da pasta src do projeto JPQL. Altere o arquivo persistence.xml do projeto JPQL, modificando o nome da unidade de persistência e a base da dados.
Crie um pacote chamado modelo no projeto JPQL e adicione as seguintes classes:

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

Carregue o banco de dados com as informações de alguns livros e autores. Adicione a seguinte classe em um novo pacote chamado testes.
public class PopulaBanco {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("jpql");
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

Teste as consultas dinâmicas com JPQL. Crie a seguinte classe no pacote testes.

public class TesteConsultaDinamicas {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("jpql");
EntityManager manager = factory.createEntityManager();
Query query = manager.createQuery("select a from Autor a");
List<Autor> autores = query.getResultList();
for (Autor autor : autores) {
System.out.println("Autor: " + autor.getNome());
Collection<Livro> livros = autor.getLivros();
for (Livro livro : livros) {
System.out.println("Livro: " + livro.getNome());
System.out.println("Preço: " + livro.getPreco());
System.out.println();
}
System.out.println();
}
manager.close();
factory.close();
}
}

Execute e observe que as consultas são realizadas aos poucos devido ao carregamento em modo LAZY

Para testar as Named Queries, acrescente a anotação @NAMEDQUERY na classe AUTOR.

@Entity
@NamedQuery(name="Autor.findAll", query="select a from Autor a")
public class Autor {
...
}


Na sequência crie um teste da Named Query definida no exercício anterior.

public class TesteNamedQuery {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("jpql");
EntityManager manager = factory.createEntityManager();
Query query = manager.createNamedQuery("Autor.findAll");
List<Autor> autores = query.getResultList();
for (Autor autor : autores) {
System.out.println("Autor: " + autor.getNome());
Collection<Livro> livros = autor.getLivros();
for (Livro livro : livros) {
System.out.println("Livro: " + livro.getNome());
System.out.println("Preço: " + livro.getPreco());
System.out.println();
}
System.out.println();
}
manager.close();
factory.close();
}
}

Execute e observe que as consultas são realizadas aos poucos devido ao carregamento em modo LAZY

Acrescente a anotação @NAMED Q UERY na classe L IVRO para definir uma consulta por preço mínimo utilizando parâmetros.

@Entity
@NamedQuery(name="Livro.findByPrecoMinimo",
query="select livro from Livro livro where livro.preco >= :preco")
public class Livro {
...
}

Na sequência crie um teste da Named Query definida no exercício anterior.

public class TesteParametros {
public static void main(String[] args) {
EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpql");
EntityManager manager = factory.createEntityManager();
Query query = manager.createNamedQuery("Livro.findByPrecoMinimo");
query.setParameter("preco", 20.0);
List<Livro> livros = query.getResultList();
for (Livro livro : livros) {
System.out.println("Nome: " + livro.getNome());
System.out.println("Preço: " + livro.getPreco());
}
manager.close();
factory.close();
}
}