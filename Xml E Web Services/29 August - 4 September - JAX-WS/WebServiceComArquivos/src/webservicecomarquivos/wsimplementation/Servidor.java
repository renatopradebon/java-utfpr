package webservicecomarquivos.wsimplementation;

import javax.xml.ws.Endpoint;

/**
 *
 * @author andre endo
 * 
 * essa classe publica o servico cujo WSDL podera ser acessado apos
 * a sua execucao em http://localhost:3000/FileService?wsdl
 * 
 * Execute esta classe para iniciar o servidor
 */
public class Servidor 
{
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:3000/FileService", new FileServiceImpl());
        System.out.println("O servico foi publicado!");
    }
}
