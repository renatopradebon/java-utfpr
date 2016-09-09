
package xml.sax.exercicio;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProcessadorXmlSax extends DefaultHandler {

	boolean CNPJ = false;
	boolean vCOFINS = false;

	public ProcessadorXmlSax() {

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			UserHandler handler = new UserHandler();

			saxParser.parse("./public/NFe-assinada.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	class UserHandler extends DefaultHandler {

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {

			if (qName.equalsIgnoreCase("CNPJ")) {
				CNPJ = true;
			}

			if (qName.equalsIgnoreCase("vCOFINS")) {
				vCOFINS = true;
			}
		}

		@Override
		public void characters(char ch[], int start, int length) throws SAXException {

			if (CNPJ) {
				System.out.println("CNPJ : " + new String(ch, start, length));
				CNPJ = false;
			}

			if (vCOFINS) {
				System.out.println("vCOFINS : " + new String(ch, start, length));
				vCOFINS = false;
			}
		}
	}

	public static void main(String argv[]) throws SAXException {
		// Inicia o processamento
		new ProcessadorXmlSax();
	}
}
