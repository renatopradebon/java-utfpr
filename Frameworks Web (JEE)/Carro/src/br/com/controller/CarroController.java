package br.com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.modelo.Carro;
import br.com.modelo.dao.CarroDao;

@ManagedBean
@ViewScoped
public class CarroController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Carro carro;
	private Integer codCarro;
	private List<Carro> listaCarros;

	@PostConstruct
	public void onInicializar(){
		listaCarros = new ArrayList<>();
		carro = new Carro();
		carro.setPlaca("nnnnn");
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
		CarroDao carroNovoDao = new CarroDao();
		carroNovoDao.save(carro);

		return "Carro cadastrado com sucesso!";

	}

	public String resetAdd() {
		carro.setPlaca("");
		carro.setProprietario(null);
		return "Dados limpos";

	}
}
