package br.com.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.modelo.Carro;
import br.com.modelo.dao.CarroDao;

@ManagedBean
@SessionScoped
public class CarroController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Carro carro;
	private Integer codCarro;
	private List<Carro> listaCarros;
	private CarroDao carroDao;

	@PostConstruct
	public void onInicializar() {
		listaCarros = new ArrayList<>();
		this.populaListaCarros();
		this.criaCarro();
		carroDao = new CarroDao();
	}

	public void criaCarro() {
		carro = new Carro();
	}

	public void populaListaCarros() {
		listaCarros = new CarroDao().busca();
	}

	public Integer getCodCarro() {
		return codCarro;
	}

	public void setCodCarro(Integer codCarro) {
		this.codCarro = codCarro;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Carro> getListaCarros() {
		return listaCarros;
	}

	public void setListaCarros(List<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}

	public String adicionarCarro() {
		Integer codCarroCadastrado = this.carroDao.save(carro);

		this.criaCarro();
		this.populaListaCarros();

		return "./listar-carro.xhtml?faces-redirect=true";
	}
	
	public String editarCarro() {
		
		String mensagem = this.carroDao.update(carro);

		this.criaCarro();
		this.populaListaCarros();
		
		return "./listar-carro.xhtml?faces-redirect=true";
	}

	public void resetAdd() {
		carro.setPlaca("");
		carro.setProprietario(null);
	}

	public void excluirCarro(Carro caroExcluido) {
		this.carroDao.remove(caroExcluido);

		this.populaListaCarros();
	}

	public String editarCarro(Carro carro) {
		this.codCarro = carro.getId();
		this.carro = carro;

		return "./editar-carro.xhtml?faces-redirect=true";
	}

	public String cancelarAcao() throws IOException {

		return "./listar-carro.xhtml?faces-redirect=true";
	}

}
