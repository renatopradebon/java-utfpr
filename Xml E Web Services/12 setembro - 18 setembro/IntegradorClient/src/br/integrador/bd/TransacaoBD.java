package br.integrador.bd;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.integrador.modelo.Transacao;

@XmlRootElement(name = "transacaoes")
public class TransacaoBD {

	private static String identificador = "transacoes-log";
	
	@XmlElement(name = "transacao")
	private List<Transacao> transacao;

	public TransacaoBD() {
		this.transacao = new ArrayList<>();
	}

	public String getIdentificador() {
		return identificador;
	}

	public List<Transacao> getTransacao() {
		return transacao;
	}

	public void setTransacoes(List<Transacao> transacao) {
		this.transacao = transacao;
	}

	@Override
	public String toString() {
		return "TransacaoBD [transacao =" + transacao + "]";
	}

}
