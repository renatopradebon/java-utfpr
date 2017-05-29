package br.com.utfpr.rest.entity.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.utfpr.rest.jpa.JpaTransaction;

public class CalculaMediaAluno {

	public static Double calculaMedia(Aluno aluno, JpaTransaction jpa) {
		return somaEDivideNotas(aluno, jpa);
	}

	protected static Double somaEDivideNotas(Aluno aluno, JpaTransaction jpa) {
		Double somaTotalNotasAnteriores = 0.0, somaTotal = 0.0;
		Integer qtdeNotas = 1, qtdeNotasBanco = 0;

		List<Notas> notasAluno = new ArrayList<>();
		somaTotal = aluno.getNotas().stream().mapToDouble(i -> i.getNota()).sum();
		qtdeNotas = aluno.getNotas().size();

		try {
			if (aluno.getId() != null) {
				notasAluno = jpa.listNotas(aluno.getId());
				qtdeNotasBanco = notasAluno.size();
				somaTotalNotasAnteriores = notasAluno.stream().mapToDouble(nota -> nota.getNota()).sum();
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		return ((somaTotal + somaTotalNotasAnteriores) / (qtdeNotas + qtdeNotasBanco));
	}

}
