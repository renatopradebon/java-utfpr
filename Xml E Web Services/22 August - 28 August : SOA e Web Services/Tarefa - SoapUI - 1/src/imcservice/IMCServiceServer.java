package imcservice;

import javax.xml.ws.Endpoint;

import imcservice.wsimplementation.IMCServiceImpl;

public class IMCServiceServer {

	public IMCServiceServer() {
		System.out.println("Iniciar o servico - IMCService");
		IMCServiceImpl servico = new IMCServiceImpl();
		Endpoint.publish("http://localhost:8080/IMCService", servico);
	}

	public static void main(String[] args) {
		System.out.println("Teste");

		new IMCServiceServer();

	}

}
