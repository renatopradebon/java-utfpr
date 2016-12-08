package br.com.prova.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.prova.Pessoa;

@ManagedBean(name = "dtPaginatorView")
//@ViewScoped
public class PaginatorView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Pessoa> pessoas = new ArrayList<>();

	@PostConstruct
	public void init() {
		
		adicionaPessoas();
	}

	private void adicionaPessoas() {
		// TODO Auto-generated method stub
		/*
		 * Nome Idade Cidade João 27 Londrina Pedro 45 Brasilia Luana 32 Belo
		 * Horizonte
		 */

		Pessoa pessoa1 = new Pessoa("João", 27, "Londrina");
		Pessoa pessoa2 = new Pessoa("Pedro", 45, "Brasília");
		Pessoa pessoa3 = new Pessoa("Luana", 32, "Belo Horizonte");

		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		System.out.println(pessoas);

	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

}