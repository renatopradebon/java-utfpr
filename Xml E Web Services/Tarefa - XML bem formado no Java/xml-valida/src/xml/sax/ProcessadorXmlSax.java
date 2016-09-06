
package xml.sax;

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

			DefaultHandler handler = new DefaultHandler();
//			UserHandler userhandler = new UserHandler();

			saxParser.parse("./public/NFe-assinada.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// chamado quando o parser atinge o inicio do documento
	@Override
	public void startDocument() throws SAXException {

	}

	// chamado quando o parser atinge o final do documento
	@Override
	public void endDocument() throws SAXException {
		// System.out.println(cdMaior);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("CNPJ")) {
			CNPJ = true;
		}

		if (qName.equalsIgnoreCase("vCOFINS")) {
			vCOFINS = true;
		}
	}

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

	public static void main(String argv[]) throws SAXException {
		ProcessadorXmlSax processador = new ProcessadorXmlSax();
		processador.startDocument();
	}
}
