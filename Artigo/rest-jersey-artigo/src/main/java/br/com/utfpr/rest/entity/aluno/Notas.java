package br.com.utfpr.rest.entity.aluno;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notas {

	@Id
	@GeneratedValue
	private Long Id;
	
	private Double nota;

	private String observacaoNota;
	
	@ManyToOne(fetch=FetchType.LAZY)
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
