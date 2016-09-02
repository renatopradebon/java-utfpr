package xml.gerador;

import java.io.File;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author andre endo
 *
 */
public class XMLCreateCode01 {
    
    /**
     * 
     * @param document - objeto que representa o documento a ser escrito
     * @param fileLocation - localizacao do arquivo onde o XML sera gravado.
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerConfigurationException 
     * 
     * Este metodo estatico salva o documento XML em memoria em um arquivo texto
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
     * @param document - objeto que representa o documento
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerConfigurationException 
     * 
     * Este metodo estatico retorna uma String representando o documento XML 
     * em memoria
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

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document document = dBuilder.newDocument();
            Element catalogo = document.createElement("catalogo");
            document.appendChild(catalogo);
            Element cd1 = document.createElement("cd");
            cd1.setAttribute("codigo", "01");
            cd1.setTextContent("Red Hot Chili Peppers");
            catalogo.appendChild(cd1);
            Element cd2 = document.createElement("cd");
            cd2.setAttribute("codigo", "02");
            cd2.setTextContent("Paralamas do Sucesso");
            catalogo.appendChild(cd2);
            //CDATA section
            CDATASection cdataSec = document.createCDATASection("meus comentarios <b>aqui</b>. Nao mexer!!!");
            Element comentario = document.createElement("comentario");
            comentario.appendChild(cdataSec);
            catalogo.appendChild(comentario);

            //salvar em arquivo
            transformDomToFile(document, "./public/saida.xml");
            //salvar como string
            System.out.println(transformDomToString(document));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
