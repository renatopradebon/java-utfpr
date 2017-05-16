package br.com.utfpr.rest.entity.aluno;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Notas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private Double nota;

	private String observacaoNota;

	@ManyToOne(targetEntity = Aluno.class)
	@JoinColumn(name = "aluno_Id", referencedColumnName = "Id")
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

}
