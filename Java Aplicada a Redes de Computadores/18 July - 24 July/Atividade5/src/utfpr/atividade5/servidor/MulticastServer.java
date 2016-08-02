package utfpr.atividade5.servidor;

public class MulticastServer {
	
	MulticastServerPiadas piadas;
	
	public MulticastServer() {
		Boolean imprimirLogs = true;
		
		// Inicia servidor de Piadas 
		piadas = new MulticastServerPiadas(imprimirLogs);
		piadas.run();
		
		
		
	}

	public static void main(String[] args) {
		// Inicia Servidores
		new MulticastServer();
	}

}
