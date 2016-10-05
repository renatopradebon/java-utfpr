package helloworld.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import helloworld.modelos.Livro;

public class LivroDAO {

	List<Livro> livros;

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public LivroDAO() {
		setLivros(new ArrayList<Livro>());

		Livro livro1 = new Livro(1234, "Codigo da Vinci", "Dan Brown", 2002, 35.55);
		getLivros().add(livro1);

		Livro livro2 = new Livro(6789, "Cem Anos de Solidao", "Gabriel Garcia Marquez", 1998, 40.05);
		getLivros().add(livro2);

		Livro livro3 = new Livro(2000, "Dom Casmurro", "Machado de Assis", 1899, 22.49);
		getLivros().add(livro3);

		Livro livro4 = new Livro(2542, "Fotaleza Digital", "Dan Brown", 2002, 22.49);
		getLivros().add(livro4);
	}

	public List<Livro> getLivros() {

		return livros;
	}

	public Livro getLivro(long id) {

		for (Livro livro : getLivros()) {
			if (livro.getCodigo() == id) {
				return livro;
			}
		}

		return null;
	}

	public void salvar(Livro livro) {

		getLivros().add(livro);
	}

	public Livro atualizar(long id, Livro livro) {
		getLivro(id).setCodigo(livro.getCodigo());
		getLivro(id).setTitulo(livro.getTitulo());
		getLivro(id).setAno(livro.getAno());
		getLivro(id).setAutor(livro.getAutor());
		getLivro(id).setPreco(livro.getPreco());

		return getLivro(id);
	}

	public String apagar(long id) {
		Iterator<Livro> livro = getLivros().iterator();

		while (livro.hasNext()) {
			Livro livroBusca = livro.next();
			if (livroBusca.getCodigo() == id) {
				livro.remove();
			}
		}
		return "Removido com sucesso";
	}

}