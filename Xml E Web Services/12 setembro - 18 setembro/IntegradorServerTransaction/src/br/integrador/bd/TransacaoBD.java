package br.integrador.bd;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.integrador.modelo.Transacao;

@XmlRootElement
public class TransacaoBD {

	private static String identificador = "transacao-log";
	private List<Transacao> transacao;

	public TransacaoBD() {
		this.transacao = new ArrayList<>();
	}

	public String getIdentificador() {
		return identificador;
	}

	public List<Transacao> getTransacoes() {
		return transacao;
	}

	public void setTransacoes(List<Transacao> transacao) {
		this.transacao = transacao;
	}

}
