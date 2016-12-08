package br.com.prova;

public class Pessoa {

	private String nome;
	private Integer idade;
	private String cidade;

	public Pessoa(String nome, Integer idade, String cidade) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
	}
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
