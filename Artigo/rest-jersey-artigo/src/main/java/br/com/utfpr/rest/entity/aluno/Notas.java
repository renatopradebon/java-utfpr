package br.com.utfpr.rest.entity.aluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Notas {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long Id;
	@Column
	private Double nota;

	@Column
	private String observacaoNota;

	@ManyToOne(targetEntity = Aluno.class)
	@JoinColumn(name = "aluno_Id", referencedColumnName = "Id")
	@JsonIgnore
	private Aluno aluno;

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Notas nota(Double nota) {
		this.nota = nota;
		return this;
	}

	public String getObservacaoNota() {
		return observacaoNota;
	}

	public void setObservacaoNota(String observacaoNota) {
		this.observacaoNota = observacaoNota;
	}

	public Notas observacaoNota(String observacaoNota) {
		this.observacaoNota = observacaoNota;
		return this;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Notas id(Long id) {
		this.Id = id;
		return this;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Notas aluno(Aluno aluno) {
		this.aluno = aluno;
		return this;
	}

	@Override
	public String toString() {
		return "Notas [Id=" + Id + ", nota=" + nota + ", observacaoNota=" + observacaoNota + ", aluno=" + aluno + "]";
	}

}
