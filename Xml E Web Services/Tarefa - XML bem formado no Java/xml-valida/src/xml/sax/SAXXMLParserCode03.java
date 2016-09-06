package xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author andre endo
 * 
 */
public class SAXXMLParserCode03 {
    
    public static void main(String[] args) {
        try {
            File xmlfile = new File("./xml/cd_catalog.xml");
            
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();
            saxParser.parse(xmlfile, new FirstSax());
        } 
        catch (ParserConfigurationException ex) {
            Logger.getLogger(SAXXMLParserCode03.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SAXXMLParserCode03.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SAXXMLParserCode03.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}