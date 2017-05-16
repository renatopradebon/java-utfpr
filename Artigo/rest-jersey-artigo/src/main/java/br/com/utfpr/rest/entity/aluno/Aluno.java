package br.com.utfpr.rest.entity.aluno;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String nome;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "aluno", targetEntity = Notas.class)
	private List<Notas> notas;

	/*
	 * 1 => SIM 0 => NAO
	 */
	private Integer realizouExame;

	@Enumerated(EnumType.STRING)
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
		int hash = 0;
		hash += (Id != null ? Id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Aluno)) {
			return false;
		}
		Aluno other = (Aluno) object;
		if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
			return false;
		}
		return true;
	}

}
