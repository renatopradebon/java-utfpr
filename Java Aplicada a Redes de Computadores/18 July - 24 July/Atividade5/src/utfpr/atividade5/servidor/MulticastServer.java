package utfpr.atividade5.servidor;

public class MulticastServer {
	
	MulticastServerPiadas piadas;
	MulticastServerCpf cpf;
	
	public MulticastServer() {
		Boolean imprimirLogs = true;
		
		// Inicia servidor de Piadas 
		piadas = new MulticastServerPiadas(imprimirLogs);
		piadas.run();
		
		// inicia servidor do CPF
//		cpf = new MulticastServerCpf(imprimirLogs);
//		cpf.run();
		
	}

	public static void main(String[] args) {
		// Inicia Servidores
		new MulticastServer();
	}

}
