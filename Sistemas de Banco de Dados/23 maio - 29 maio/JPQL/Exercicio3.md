Teste o recurso de paginação das consultas. Adicione a seguinte classe no pacote testes.
public class TesteBuscaPaginada {
public static void main(String[] args) {
EntityManagerFactory factory = 
Persistence.createEntityManagerFactory("K21_jpql");
EntityManager manager = factory.createEntityManager();
TypedQuery<Livro> query = manager.createQuery("select livro from Livro livro",Livro.class);
query.setFirstResult(2);
query.setMaxResults(3);
List<Livro> livros = query.getResultList();
for (Livro livro : livros) {
System.out.println("Livro: " + livro.getNome());
}
manager.close();
factory.close();
}
}
