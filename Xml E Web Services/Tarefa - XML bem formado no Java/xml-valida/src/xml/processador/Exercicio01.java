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
 *         seus dados. Estude a estrutura do arquivo XML e utilize os metodos da
 *         classe Node.
 * 
 */
public class Exercicio01 {

	private Element raiz;
	private static String path = "./public/";

	Exercicio01(Element raiz) {
		this.setRaiz(raiz);
	}

	public Element getRaiz() {
		return raiz;
	}

	public void setRaiz(Element raiz) {
		this.raiz = raiz;
	}

	public void imprimirMaisCaro() {
		float preco = 0;
		float maiorPreco = 0;
		Node noMaiorPreco = null;
		
		NodeList lista = getRaiz().getChildNodes();

		for (int i = 0; i < lista.getLength(); i++) {
			Node cdLista = lista.item(i);

			if (cdLista.getNodeType() == Node.ELEMENT_NODE) {
				preco = getPreco(cdLista);
//				System.out.println(no.getNodeName());
				
				if (preco > maiorPreco) {
					maiorPreco = preco;
					noMaiorPreco = cdLista;
				}
			}
		}

		System.out.println("Informações do CD mais caro => " + noMaiorPreco.getTextContent().trim());
	}

	private float getPreco(Node itemNo) {
		float precoNo = 0;
		NodeList listaFilho = itemNo.getChildNodes();

		for (int i = 0; i < listaFilho.getLength(); i++) {
			Node itemFilho = listaFilho.item(i);

			if ((itemFilho.getNodeType() == Node.ELEMENT_NODE) && (itemFilho.getNodeName().equals("PRICE"))) {
//				System.out.println(itemFilho.getTextContent());
				return Float.valueOf(itemFilho.getTextContent());
			}
		}
		return precoNo;
	}

	public static void main(String[] args) {
		try {
			File xmlfile = new File(path + "cd_catalog.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document document = dBuilder.parse(xmlfile);
			document.normalize();
			Element raiz = document.getDocumentElement();

			Exercicio01 ex1 = new Exercicio01(raiz);
			ex1.imprimirMaisCaro();
		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}