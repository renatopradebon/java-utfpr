package xml.verificador.teste;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class VerifyFileXsd {

	private static String path = "./public/";

	public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {

		try {
			File xmlFile = new File(path + "livros.xml");

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

			File xsdFile = new File(path + "livro.xsd");

			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

			Schema schema = schemaFactory.newSchema(xsdFile);

			documentBuilderFactory.setSchema(schema);

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			documentBuilder.setErrorHandler(new ErrorHandler() {
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					throw new UnsupportedOperationException("warning: Not supported yet.");
				}

				@Override
				public void error(SAXParseException exception) throws SAXException {
					throw new UnsupportedOperationException("error: Not supported yet.");
				}

				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					throw new UnsupportedOperationException("fatalError: Not supported yet.");
				}
			});

			documentBuilder.parse(xmlFile);
			System.out.println("Parse OK");

		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
