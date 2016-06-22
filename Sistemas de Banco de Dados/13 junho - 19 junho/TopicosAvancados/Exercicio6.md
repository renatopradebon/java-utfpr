Exercícios
Exercícios
Testes as consultas nativas. Acrescente a seguinte classe no pacote testes.

public class TesteConsultaNativas {
public static void main(String[] args) {
String sql = "SELECT * FROM Produto";
Query nativeQuery = manager.createNativeQuery(sql, Produto.class);
List<Produto> produtos = nativeQuery.getResultList();
for (Produto p : produtos) {
System.out.println(p.getNome());
}
}
}
