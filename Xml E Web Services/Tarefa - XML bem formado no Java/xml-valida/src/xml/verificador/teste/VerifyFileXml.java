package xml.verificador.teste;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import xml.verificador.XMLVerificadorFile;

public class VerifyFileXml {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		String arquivoXml = "./public/teste.xml";

		XMLVerificadorFile verificaArquivo = new XMLVerificadorFile(arquivoXml);

		boolean xmlVerificado = verificaArquivo.verificaXml(verificaArquivo.getArquivoXml());

		if (xmlVerificado) {
			System.out.println("O documento XML foi processado corretamente (bem-formado)");
		}

	}

}
