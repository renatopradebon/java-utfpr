Exercícios
Tente adicionar um governador e um estado. Crie uma classe chamada TesteCascade no pacote testes.

public class TesteCascade {
public static void main(String[] args) {
EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");
EntityManager manager = factory.createEntityManager();
Governador governador = new Governador();
governador.setNome("Rafael Cosentino");
Estado estado = new Estado();
estado.setNome("São Paulo");
governador.setEstado(estado);
estado.setGovernador(governador);
manager.getTransaction().begin();
manager.persist(estado);
manager.getTransaction().commit();
}
}

Execute e observe o erro


Modifique a classe Estado para configurar a propriedade cascade no relacionamento com governadores.
@Entity
public class Estado {
@Id @GeneratedValue
private Long id;
private String nome;
@OneToOne(cascade=CascadeType.PERSIST)
private Governador governador;
// GETTERS AND SETTERS
}

Execute a classe TesteCascade e observe que não ocorre o mesmo erro que aconteceu anteriormente.
