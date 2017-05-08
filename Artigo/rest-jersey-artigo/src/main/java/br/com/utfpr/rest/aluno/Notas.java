package br.com.utfpr.rest.aluno;

public class Notas {

	private Double nota;

	private String observacaoNota;

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

}
