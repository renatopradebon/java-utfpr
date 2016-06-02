Exercícios
Teste o recurso de Typed Query utilizando a Named Query AUTOR.FINDALL.
public class TesteTypedQuery {
public static void main(String[] args) {
EntityManagerFactory factory =
Persistence.createEntityManagerFactory("jpql");
EntityManager manager = factory.createEntityManager();
TypedQuery<Autor> query = manager.createNamedQuery("Autor.findAll", Autor.class);
List<Autor> autores = query.getResultList();
for (Autor autor : autores) {
System.out.println("Autor: " + autor.getNome());
}
manager.close();
factory.close();
}
}

Observe que não há mais warnings.

Crie um teste para recuperar somente os nomes dos livros cadastrados no banco de dados. Adicione a seguinte classe no pacote testes.

public class TesteConsultaObjetosComuns {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("jpql");
EntityManager manager = factory.createEntityManager();
TypedQuery<String> query = manager.createQuery("select livro.nome from Livro livro", String.class);
List<String> nomes = query.getResultList();
for (String nome : nomes) {
System.out.println(nome);
}
manager.close();
factory.close();
}
}

Crie um teste para recuperar o valor da média dos preços dos livros. Adicione a seguinte classe no pacote testes.

public class TesteConsultaLivroPrecoMedio {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("jpql");
EntityManager manager = factory.createEntityManager();
TypedQuery<Double> query = manager.createQuery("select avg(livro.preco) from Livro livro", Double.class);
Double precoMedio = query.getSingleResult();
System.out.println("Preço médio: " + precoMedio);
manager.close();
factory.close();
}
}
