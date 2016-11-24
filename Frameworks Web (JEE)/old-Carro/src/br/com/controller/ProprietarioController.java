package br.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.modelo.Proprietario;

@ManagedBean
@SessionScoped
public class ProprietarioController implements Serializable {

	private Proprietario proprietario;
	private List<Proprietario> listaProprietarios;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public List<Proprietario> getListaProprietarios() {
		return listaProprietarios;
	}

	public void setListaProprietarios(List<Proprietario> listaProprietario) {
		this.listaProprietarios = listaProprietario;
	}

}
