package br.com.datatable;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.datatable.modelo.Aluno;

@ManagedBean
public class AlunoMB {

	private List<Aluno> lista = new ArrayList<>();

	private Aluno aluno = new Aluno();

	public AlunoMB() {
		adicionaAluno();
	}

	public List<Aluno> getLista() {
		return lista;
	}

	public void setLista(List<Aluno> lista) {
		this.lista = lista;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void adicionaAluno() {

		Aluno a = new Aluno();
		a.setCodigo(1);
		a.setNome("Joao");
		a.setSobrenome("Da Silva");
		lista.add(a);

		Aluno a1 = new Aluno();
		a1.setCodigo(2);
		a1.setNome("Bianca");
		a1.setSobrenome("Borges");
		lista.add(a1);

		Aluno a2 = new Aluno();
		a2.setCodigo(3);
		a2.setNome("Renato");
		a2.setSobrenome("Pradebon");
		lista.add(a2);
	}
}
