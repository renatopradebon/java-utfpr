package br.com.controller;

import java.util.List;

import javax.annotation.ManagedBean;

import br.com.modelo.Carro;

@ManagedBean
public class CarroController {

	private Carro carro;
	private List<Carro> listaCarros;

//	public List<Carro> getListarLivros() {
//		List<Carro> lista = new LivroDaoImp().list();
//		listaLivros = new ListDataModel(lista);
//		return listaLivros;
//	}

	public Livro getLivro() {
		return carro;
	}

	public void setLivro(Livro livro) {
		this.carro = livro;
	}

	public String prepararAdicionarLivro() {
		carro = new Livro();
		return "gerenciarLivro";
	}

	public String prepararAlterarLivro() {
		carro = (Livro) (listaLivros.getRowData());
		return "gerenciarLivro";
	}

	public String excluirLivro() {
		Livro livroTemp = (Livro) (listaLivros.getRowData());
		LivroDao dao = new LivroDaoImp();
		dao.remove(livroTemp);
		return "index";
	}

	public String adicionarLivro() {
		LivroDao dao = new LivroDaoImp();
		dao.save(carro);
		return "index";
	}

	public String alterarLivro() {
		LivroDao dao = new LivroDaoImp();
		dao.update(carro);
		return "index";
	}

}
