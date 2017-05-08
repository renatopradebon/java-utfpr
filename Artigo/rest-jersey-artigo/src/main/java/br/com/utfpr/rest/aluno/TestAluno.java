package br.com.utfpr.rest.aluno;

import java.util.ArrayList;

public class TestAluno {
	
	public static void main (String args[]) {
		ArrayList<Notas> notas = new ArrayList<>();

		notas.add(new Notas().nota(7.5).observacaoNota("1 trimestre"));
		notas.add(new Notas().nota(8.5).observacaoNota("2 trimestre"));
		notas.add(new Notas().nota(5.5).observacaoNota("3 trimestre"));
		
		
		Aluno novAluno = new Aluno().id(1L).nome("Renato Pradebon").notas(notas);
		
		novAluno.situacao(new CalculaSituacaoAluno(novAluno).calculaSituacao());
		
		System.out.println("ASluno + " + novAluno.toString());
		
		
		
	}
	
	
}
