package xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author andre endo
 */
public class FirstSax extends DefaultHandler {

    boolean bPrice = false;
    Cd cdMaior = null;
    Cd cdAtual = null;
    String noAtual = null;
    
    //chamado quando o parser atinge o inicio do documento
    @Override
    public void startDocument() throws SAXException {
        
    }
    
    //chamado quando o parser atinge o final do documento
    @Override
    public void endDocument() throws SAXException {
        System.out.println(cdMaior);
    }
    
    //Metodo chamado quando uma tag inicial eh encontrada
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("CD"))
            cdAtual = new Cd();

        noAtual = qName;
    }

    //Metodo chamado quando uma tag final eh encontrada
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        noAtual = "";
        if(qName.equals("CD")){
            if(cdMaior == null)
                cdMaior = cdAtual;
            
            if(cdAtual.getPrice() > cdMaior.getPrice())
                cdMaior = cdAtual;
        }
            
    }

    //retorna os caracteres lidos depois que eu elemento eh iniciado
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if(content.isEmpty())
            return;
        switch (noAtual) {
            case "PRICE":
                float price = Float.valueOf(content);
                cdAtual.setPrice(price);
                break;
            case "TITLE":
                cdAtual.setTitle(content);
                break;
            case "ARTIST":
                cdAtual.setArtist(content);
                break;
            case "COUNTRY":
                cdAtual.setCountry(content);
                break;
            case "COMPANY":
                cdAtual.setCompany(content);
                break;
            case "YEAR":
                cdAtual.setYear(Integer.valueOf(content));
                break;
        }
    }    
}
