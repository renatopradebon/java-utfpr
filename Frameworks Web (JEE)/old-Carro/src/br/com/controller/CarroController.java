package br.com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.modelo.Carro;
import br.com.modelo.Proprietario;
import br.com.modelo.dao.ProprietarioDao;

@ManagedBean
@SessionScoped
public class CarroController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Carro carro;
	private List<Carro> listaCarros;
	private List<Proprietario> listaProprietarios;

	public CarroController() {
		listaCarros = new ArrayList<>();		
		
		listaProprietarios = new ProprietarioDao().busca();
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

	public List<Proprietario> getListaProprietarios() {				
		return listaProprietarios;
	}

	public void setListaProprietarios(List<Proprietario> listaProprietarios) {
		this.listaProprietarios = listaProprietarios;
	}
	
	public void adicionarCarro() {
		
	}
}
