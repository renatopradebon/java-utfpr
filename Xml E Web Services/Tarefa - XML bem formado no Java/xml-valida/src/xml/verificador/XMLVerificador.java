package xml.verificador;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLVerificador {

	private boolean retorno;
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;

	public boolean verificaXml(File arquivoXmlParse) throws ParserConfigurationException {
		retorno = false;

		iniciaVariaveis();

		try {
			dBuilder.parse(arquivoXmlParse);

			retorno = true;
		} catch (SAXException ex) {
			System.out.println("SAXException");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("IOException");
			ex.printStackTrace();
		}

		return retorno;

	}

	public boolean verificaXml(InputSource stringXmlParse) throws ParserConfigurationException {
		retorno = false;

		iniciaVariaveis();

		try {
			dBuilder.parse(stringXmlParse);

			retorno = true;
		} catch (SAXException ex) {
			System.out.println("SAXException");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("IOException");
			ex.printStackTrace();
		}

		return retorno;

	}

	public void iniciaVariaveis() throws ParserConfigurationException {
		try {
			dbFactory = DocumentBuilderFactory.newInstance();

			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException ex) {
			System.out.println("ParserConfigurationException");
			ex.printStackTrace();
		}
	}
}
