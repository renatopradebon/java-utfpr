Exercícios
Recupere uma listagem com os nomes dos livros cadastrados no banco de dados. Adicione a seguinte classe no pacote testes.

public class ListaNomesDosLivros {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("criteria");
EntityManager manager = factory.createEntityManager();
CriteriaBuilder cb = manager.getCriteriaBuilder();
CriteriaQuery<String> c = cb.createQuery(String.class);
Root<Livro> livro = c.from(Livro.class);
c.select(livro.<String>get("nome"));
TypedQuery<String> query = manager.createQuery(c);
List<String> nomes = query.getResultList();
for (String nome : nomes) {
System.out.println("Livro: " + nome);
}
manager.close();
factory.close();
}
}

Recupere a média dos valores dos livros cadastrados no banco de dados. Adicione a seguinte classe no pacote testes.
public class CalculaMediaDosPrecosDosLivros {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("criteria");
EntityManager manager = factory.createEntityManager();
CriteriaBuilder cb = manager.getCriteriaBuilder();
CriteriaQuery<Double> c = cb.createQuery(Double.class);
Root<Livro> l = c.from(Livro.class);
c.select(cb.avg(l.<Double>get("preco")));
TypedQuery<Double> query = manager.createQuery(c);
Double media = query.getSingleResult();
System.out.println("Média: " + media);
manager.close();
factory.close();
}
}

Recupere os nomes e os preços dos livros cadastrados no banco de dados. Adicione a seguinte classe no pacote testes.

public class ConsultaNomePrecoDosLivros {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("criteria");
EntityManager manager = factory.createEntityManager();
CriteriaBuilder cb = manager.getCriteriaBuilder();
CriteriaQuery<Tuple> c = cb.createQuery(Tuple.class);
Root<Livro> l = c.from(Livro.class);
c.multiselect(l.<String>get("nome").alias("livro.nome"), l.<Double>get("preco").alias("livro.preco"));
TypedQuery<Tuple> query = manager.createQuery(c);
List<Tuple> resultado = query.getResultList();
for (Tuple registro : resultado) {
System.out.println("Livro: " + registro.get("livro.nome"));
System.out.println("Preço: " + registro.get("livro.preco"));
}
manager.close();
factory.close();
}
}
