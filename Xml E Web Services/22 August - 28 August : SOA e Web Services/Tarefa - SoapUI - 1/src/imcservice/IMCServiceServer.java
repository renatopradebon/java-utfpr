package imcservice;

import imcservice.wsimplementation.IMCServiceImpl;
import javax.xml.ws.Endpoint;

/**
 *
 * @author andre endo
 */
public class IMCServiceServer {

    public static void main(String[] args) {
        System.out.println("Iniciar o servico - IMCService");
        IMCServiceImpl servico = new IMCServiceImpl();
        Endpoint.publish("http://localhost:8080/IMCService", servico);
    }
    
}