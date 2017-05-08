package br.com.utfpr.rest.aluno;

import java.util.ArrayList;

import br.com.utfpr.rest.aluno.vo.Situacao;

public class Aluno {

	public Aluno() {
		super();

		this.realizouExame = Boolean.FALSE;
	}

	private Long Id;

	private String nome;

	private ArrayList<Notas> notas;

	private Boolean realizouExame;

	private Situacao situacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Aluno nome(String nome) {
		this.nome = nome;
		return this;
	}

	public ArrayList<Notas> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Notas> notas) {
		this.notas = notas;
	}

	public Aluno notas(ArrayList<Notas> notas) {
		this.notas = notas;
		return this;
	}

	public Boolean getRealizouExame() {
		return realizouExame;
	}

	public void setRealizouExame(Boolean realizouExame) {
		this.realizouExame = realizouExame;
	}

	public Boolean realizouExame(Boolean realizouExame) {
		this.realizouExame = realizouExame;
		return realizouExame;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Aluno situacao(Situacao situacao) {
		this.situacao = situacao;
		return this;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Aluno id(Long id) {
		Id = id;
		return this;
	}
	
	public Aluno builder() {
		return this;
	}

	@Override
	public String toString() {
		return "Aluno [Id=" + Id + ", nome=" + nome + ", notas=" + notas + ", realizouExame=" + realizouExame
				+ ", situacao=" + situacao + "]";
	}
	
	

}
