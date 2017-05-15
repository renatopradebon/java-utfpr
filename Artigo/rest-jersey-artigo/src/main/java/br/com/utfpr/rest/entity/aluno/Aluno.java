package br.com.utfpr.rest.entity.aluno;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.utfpr.rest.entity.aluno.vo.Situacao;

@Entity
public class Aluno {

	public Aluno() {
		super();

		this.realizouExame = 1;
	}

	@Id
	@GeneratedValue
	private Long Id;

	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Notas> notas;
	
	/*
	 * 1 => SIM
	 * 0 => NAO
	 * */
	private Integer realizouExame;

	private Situacao situacao;

	private Double media;

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

	public List<Notas> getNotas() {
		return notas;
	}

	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}

	public Aluno notas(List<Notas> notas) {
		this.notas = notas;
		return this;
	}

	public Integer getRealizouExame() {
		return realizouExame;
	}

	public void setRealizouExame(Integer realizouExame) {
		this.realizouExame = realizouExame;
	}

	public Aluno realizouExame(Integer realizouExame) {
		this.realizouExame = realizouExame;
		return this;
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

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public Aluno media(Double media) {
		this.media = media;
		return this;
	}

	@Override
	public String toString() {
		return "Aluno [Id=" + Id + ", nome=" + nome + ", notas=" + notas + ", realizouExame=" + realizouExame
				+ ", situacao=" + situacao + ", media=" + media + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
