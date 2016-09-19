package xml.processador;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author andre endo
 * 
 *         Encontre o CD mais caro no arquivo cd_catalog.xml e imprima todos
 *         seus dados. Estude a estrutura do arquivo XML e utilize o metodo
 *         "getElementsByTagName()".
 * 
 */
public class Exercicio02 {

	private Element raiz;
	private static String path = "./public/";

	Exercicio02(Element raiz) {
		this.setRaiz(raiz);
	}

	public Element getRaiz() {
		return raiz;
	}

	public void setRaiz(Element raiz) {
		this.raiz = raiz;
	}

	public void imprimirMaisCaro() {

		Node noMaiorPreco = null;
		float preco = 0;
		float maiorPreco = 0;

		NodeList lista = getRaiz().getElementsByTagName("PRICE");

		for (int i = 0; i < lista.getLength(); i++) {

			Node itemLista = lista.item(i);

			// System.out.println(itemLista.getTextContent());

			preco = Float.valueOf(itemLista.getTextContent());

			if (preco > maiorPreco) {
				maiorPreco = preco;
				noMaiorPreco = itemLista;
			}
		}
		Node paiLista = noMaiorPreco.getParentNode();
		System.out.println("Informações do CD mais caro => " + paiLista.getTextContent().trim());
	}

	public static void main(String[] args) {
		try {
			File xmlfile = new File(path + "cd_catalog.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document document = dBuilder.parse(xmlfile);
			document.normalize();
			Element raiz = document.getDocumentElement();

			Exercicio02 ex2 = new Exercicio02(raiz);
			ex2.imprimirMaisCaro();
		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}