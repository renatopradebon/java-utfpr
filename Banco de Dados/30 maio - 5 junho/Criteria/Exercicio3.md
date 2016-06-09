Exercícios
Teste a Criteria API criando uma consulta para recuperar todos os livros cadastrados no banco de dados. Crie a seguinte classe no pacote testes.

public class TestePredicate {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("criteria");
EntityManager manager = factory.createEntityManager();
CriteriaBuilder cb = manager.getCriteriaBuilder();
CriteriaQuery<Livro> c = cb.createQuery(Livro.class);
Root<Livro> l = c.from(Livro.class);
c.select(l);
Predicate predicate = cb.equal(l.get("nome"), "The Battle for Your Mind");
c.where(predicate);
TypedQuery<Livro> query = manager.createQuery(c);
List<Livro> livros = query.getResultList();
for (Livro livro : livros) {
System.out.println(livro.getId());
System.out.println(livro.getNome());
System.out.println(livro.getPreco());
}
}
}
