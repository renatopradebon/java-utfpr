package xml.verificador.teste;

import javax.xml.parsers.ParserConfigurationException;

import xml.verificador.XMLVerificadorString;

public class VerifyStringXml {

	public static void main(String[] args) throws ParserConfigurationException {
		String stringXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
	            "<livros>\n" + 
				" <livro>\n" + 
				" <id>01</id>\n" + 
				" <titulo>Cem anos de solidão</titulo>\n" + 
				" <autor>Gabriel Garcia Marquez</autor>\n" + 
				" </livro>\n" + 
				"</livros>";

		XMLVerificadorString verificaString = new XMLVerificadorString(stringXml);

		boolean xmlVerificado = verificaString.verificaXml(verificaString.getStringXml());

		if (xmlVerificado) {
			System.out.println("O documento XML foi processado corretamente (bem-formado)");
		}
	}

}
