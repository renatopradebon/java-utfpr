package br.integrador.dao;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.integrador.bd.TransacaoBD;
import br.integrador.modelo.Transacao;

public class TransacaoXML {

	private static final String PATH_XML = "./public/transacoesBD.xml";

	private Transacao transacao;
	private TransacaoBD transacoesAtuais;

	public TransacaoXML() {

		try {
			JAXBContext context = JAXBContext.newInstance(TransacaoBD.class);
			Unmarshaller um = context.createUnmarshaller();
			transacoesAtuais = (TransacaoBD) um.unmarshal(new FileReader(PATH_XML));
		} catch (Exception erro) {
			System.out.println("Erro no XML => " + erro);
			transacoesAtuais = new TransacaoBD();
		}
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public List<Transacao> getTransacoesAtuais() {
		return transacoesAtuais.getTransacao();
	}

	public List<Transacao> getTransacoesAtuais(long numConta) {
		List<Transacao> transacoesConta = new ArrayList<>();

		for (Transacao transacao : getTransacoesAtuais()) {
			if (transacao.getNumConta() == numConta) {
				transacoesConta.add(transacao);
			}
		}

		return transacoesConta.size() > 0 ? transacoesConta : null;
	}

	public void saveXML() {
		try {
			// adiciona transacoes ja efetuadas
			getTransacoesAtuais().add(transacao);

			JAXBContext context = JAXBContext.newInstance(TransacaoBD.class);

			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(transacoesAtuais, new File(PATH_XML));
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}
}
