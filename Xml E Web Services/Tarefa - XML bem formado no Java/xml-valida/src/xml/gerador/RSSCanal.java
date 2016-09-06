package xml.gerador;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RSSCanal {

	private static String path = "./public/";
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document document;
	private Element elementoRss;
	private Element elementoChannel;

	public RSSCanal() throws ParserConfigurationException {
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		document = dBuilder.newDocument();
	}

	public void criaCanalRSS() {
		try {

			elementoRss = document.createElement("rss");
			elementoRss.setAttribute("version", "2.0");
			document.appendChild(elementoRss);

			elementoChannel = document.createElement("channel");
			elementoRss.appendChild(elementoChannel);

			Element title = document.createElement("title");
			title.setTextContent("Exemplo de Canal RSS");
			elementoChannel.appendChild(title);

			Element link = document.createElement("link");
			link.setTextContent("https://twitter.com/renatopradebon");
			elementoChannel.appendChild(link);

			Element description = document.createElement("description");
			description.setTextContent("Twitter - Renato Pradebon");
			elementoChannel.appendChild(description);

			criaVariosItens();

			imprimir(document);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void criaVariosItens() {

		for (int i = 1; i <= 10; i++) {
			Item item = new Item();

			item.setDescription("Descrição Item " + i);
			item.setLink("http://www.link" + i + ".com.br");
			item.setTitle("Titulo " + i);

			adicionarItem(item);
		}
	}

	public void adicionarItem(Item item) {

		Element itemNo = document.createElement("item");
		elementoChannel.appendChild(itemNo);

		Element title = document.createElement("title");
		title.setTextContent(item.getTitle());
		itemNo.appendChild(title);

		Element link = document.createElement("link");
		link.setTextContent(item.getLink());
		itemNo.appendChild(link);

		Element description = document.createElement("description");
		description.setTextContent(item.getDescription());
		itemNo.appendChild(description);

	}

	public void imprimir(Document document)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException {
		// salvar em arquivo
		transformDomToFile(document, path + "docXmlCriado.xml");
		// salvar como string
		System.out.println(transformDomToString(document));
	}

	/**
	 * 
	 * @param document
	 *            - objeto que representa o documento a ser escrito
	 * @param fileLocation
	 *            - localizacao do arquivo onde o XML sera gravado.
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 * 
	 *             Este metodo estatico salva o documento XML em memoria em um
	 *             arquivo texto
	 */
	public static void transformDomToFile(Document document, String fileLocation)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException {
		//
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domsource = new DOMSource(document);

		StreamResult streamResult = new StreamResult(new File(fileLocation));
		try {
			transformer.transform(domsource, streamResult);
		} catch (TransformerException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param document
	 *            - objeto que representa o documento
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerConfigurationException
	 * 
	 *             Este metodo estatico retorna uma String representando o
	 *             documento XML em memoria
	 */
	public static String transformDomToString(Document document) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domsource = new DOMSource(document);

			StringWriter stringWriter = new StringWriter();
			transformer.transform(domsource, new StreamResult(stringWriter));
			return stringWriter.toString();
		} catch (TransformerConfigurationException ex) {
			return "error";
		} catch (TransformerException ex) {
			return "error";
		}
	}

	public static void main(String[] args) throws ParserConfigurationException {

		RSSCanal canal = new RSSCanal();

		canal.criaCanalRSS();
	}
}
