package br.com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.modelo.Proprietario;
import br.com.modelo.dao.ProprietarioDao;

@ManagedBean
@SessionScoped
public class ProprietarioController implements Serializable {

	private static final String LISTAR_PROPRIETARIO_XHTML_FACES_REDIRECT_TRUE = "./listar-proprietario.xhtml?faces-redirect=true";
	private Proprietario proprietario;
	private Integer codProprietario;
	private List<Proprietario> listaProprietarios;
	private ProprietarioDao proprietarioDao;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void onInicializar() {
		listaProprietarios = new ArrayList<>();
		this.populalistaProprietarios();
		this.criaProprietario();
		proprietarioDao = new ProprietarioDao();
	}

	public void criaProprietario() {
		proprietario = new Proprietario();
	}

	public void populalistaProprietarios() {
		listaProprietarios = new ProprietarioDao().busca();
	}

	public Integer getCodProprietario() {
		return codProprietario;
	}

	public void setCodProprietario(Integer codProprietario) {
		this.codProprietario = codProprietario;
	}

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

	public String adicionarProprietario() {
		Integer codProprietarioCadastrado = this.proprietarioDao.save(proprietario);

		this.criaProprietario();
		this.populalistaProprietarios();

		return LISTAR_PROPRIETARIO_XHTML_FACES_REDIRECT_TRUE;
	}

	public String editarProprietario() {

		String mensagem = this.proprietarioDao.update(proprietario);

		this.criaProprietario();
		this.populalistaProprietarios();

		return LISTAR_PROPRIETARIO_XHTML_FACES_REDIRECT_TRUE;
	}

	public void resetAdd() {
		proprietario.setNome("");
	}

	public void excluirProprietario(Proprietario proprietarioExcluido) {
		this.proprietarioDao.remove(proprietarioExcluido);

		this.populalistaProprietarios();
	}

	public String editarProprietario(Proprietario proprietario) {
		this.codProprietario = proprietario.getId();
		this.proprietario = proprietario;

		return "./editar-proprietario.xhtml?faces-redirect=true";
	}

	public String cancelarAcao() {

		return LISTAR_PROPRIETARIO_XHTML_FACES_REDIRECT_TRUE;
	}

}
