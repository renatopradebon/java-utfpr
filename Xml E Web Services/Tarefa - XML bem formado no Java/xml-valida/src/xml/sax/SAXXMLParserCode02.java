package xml.sax;

import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author andre endo
 * 
 * Exemplo de como verificar se um documento XML eh bem formado
 * Documento XML esta em um arquivo (usando SAX)
 */
public class SAXXMLParserCode02 {
    
    public static void main(String[] args) {
        try {
            //o documento XML a ser processado esta em uma String
            String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                "<livros>\n" +
                                "    <livro>\n" +
                                "        <id>01</id>\n" +
                                "        <titulo>Cem anos de solidão</titulo>\n" +
                                "        <autor>Gabriel Garcia Marquez</autor>\n" +
                                "    </livro>\n" +
                                "</livros>";           
            
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();
            InputSource is = new InputSource(new StringReader(xmlString));
            saxParser.parse(is, new DefaultHandler());
            System.out.println("Documento XML na String processado.");
        } 
        catch (ParserConfigurationException ex) {
            Logger.getLogger(SAXXMLParserCode02.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SAXXMLParserCode02.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SAXXMLParserCode02.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}