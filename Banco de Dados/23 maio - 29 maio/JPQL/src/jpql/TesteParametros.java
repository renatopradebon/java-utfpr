package jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteParametros {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpql");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNamedQuery("Livro.findByPrecoMinimo");
		Double precoMinimoLivro = 18.00;

		query.setParameter("preco", precoMinimoLivro);

		List<Livro> livros = query.getResultList();

		for (Livro livro : livros) {
			System.out.println("Nome: " + livro.getNome());
			System.out.println("Preço: " + livro.getPreco());
		}

	}

}
