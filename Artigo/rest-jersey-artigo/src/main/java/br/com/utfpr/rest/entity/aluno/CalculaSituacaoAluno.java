package br.com.utfpr.rest.entity.aluno;

import br.com.utfpr.rest.entity.aluno.vo.Situacao;

public class CalculaSituacaoAluno {

	private static Double MEDIA_FINAL_APROVACAO = 7.0;

	public static Situacao calculaSituacao(Aluno aluno) {
		return (aluno.getMedia() >= MEDIA_FINAL_APROVACAO) ? Situacao.APROVADO
				: ((aluno.getRealizouExame() == 1) ? Situacao.REPROVADO : Situacao.EXAME);
	}
}
