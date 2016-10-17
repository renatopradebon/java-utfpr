package br.integrador.dao;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.integrador.bd.TransacaoBD;

public class TransacaoXML {

	private static final String PATH_XML = "./public/transacoesBD.xml";

	private TransacaoBD transacaoBD;
	private TransacaoBD transacoesAtuais;
	private List<TransacaoBD> transacoesBD;

	public TransacaoBD getTransacaoBD() {
		return transacaoBD;
	}

	public void setTransacaoBD(TransacaoBD transacaoBD) {
		this.transacaoBD = transacaoBD;
	}

	public TransacaoXML() {
		transacoesBD = new ArrayList<>();

		try {
			JAXBContext context = JAXBContext.newInstance(TransacaoBD.class);
			Unmarshaller um = context.createUnmarshaller();
			transacoesAtuais = (TransacaoBD) um.unmarshal(new FileReader(PATH_XML));
			// adiciona transacoes ja efetuadas
			transacoesBD.add(transacoesAtuais);
		} catch (Exception erro) {
			System.out.println("Erro no XML => " + erro);
		}

		// adiciona nova transacao
		transacoesBD.add(transacaoBD);
	}

	public void saveXML() {
		try {
			JAXBContext context = JAXBContext.newInstance(TransacaoBD.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(transacoesBD, new File(PATH_XML));
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}
}
