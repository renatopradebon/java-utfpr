package xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import xml.proj01.parsing.sax.FirstSax;

/**
 *
 * @author andre endo
 * 
 * Exemplo de como verificar se um documento XML eh bem formado
 * Documento XML esta em um arquivo (usando SAX)
 */
public class SAXXMLParserCode01 {
    
    public static void main(String[] args) {
        try {
            File xmlfile = new File("./xml/arquivo01.xml");
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();
            saxParser.parse(xmlfile, new DefaultHandler());
            System.out.println("O documento XML foi processado corretamente (bem-formado)");
        } 
        catch (ParserConfigurationException ex) {
            Logger.getLogger(SAXXMLParserCode01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SAXXMLParserCode01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SAXXMLParserCode01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}