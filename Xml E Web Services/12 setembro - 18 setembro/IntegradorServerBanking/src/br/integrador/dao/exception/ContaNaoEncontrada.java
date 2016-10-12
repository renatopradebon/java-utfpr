package br.integrador.dao.exception;

public class ContaNaoEncontrada extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaNaoEncontrada(long numConta) {
		System.err.println("Conta não encontrada => " + numConta + ".");
	}

}
