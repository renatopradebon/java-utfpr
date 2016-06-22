Exercícios
Exercícios

Acrescente dois métodos de callback na classe PRODUTO.

@Entity
public class Produto {
@Id @GeneratedValue
private Long id;
private String nome;
private Double preco;
@PrePersist
public void prePersist(){
System.out.println("Persistindo....");
}
@PostPersist
public void postPersist(){
System.out.println("Já persistiu....");
}
// GETTERS E SETTERS
}

Execute a classe P OPULA BANCO novamente e observe o console.
(Opcional) Teste os outros callbacks.
