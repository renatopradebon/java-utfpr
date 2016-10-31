package br.com.testbean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TestBean {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String retornaNavegacao() {
		return getNome().equals("3") ? "third" : "second";
	}

	@Override
	public String toString() {
		return "TestBean [nome=" + nome + "]";
	}

}
