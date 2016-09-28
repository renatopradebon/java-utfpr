package abccontratacao.wsimplementation;

import javax.xml.ws.Endpoint;

public class ABCServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Iniciar o servico");
		ABCContratacaoServiceImpl servico = new ABCContratacaoServiceImpl();
		Endpoint.publish("http://localhost:3000/ABCContratacaoService", servico);

	}

}
