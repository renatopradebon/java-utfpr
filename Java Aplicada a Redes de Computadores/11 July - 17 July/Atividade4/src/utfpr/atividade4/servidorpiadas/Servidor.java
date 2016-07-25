package utfpr.atividade4.servidorpiadas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import utfpr.atividade4.servidorpiadas.leitor.LeitorPiadas;

public class Servidor extends Thread {

	private Socket socket;

	private static LeitorPiadas leitor;

	public Servidor(Socket conexao) throws FileNotFoundException {
		this.socket = conexao;
	}

	@Override
	public void run() {
		try {

			DataInputStream entrada = new DataInputStream(socket.getInputStream());

			String nome = entrada.readUTF();

			DataOutputStream saida = new DataOutputStream(socket.getOutputStream());

			saida.writeUTF(leitor.getProximaPiada());

			System.out.println(nome + " solicitou uma nova piada.");

			socket.close();

		} catch (Exception e) {
			System.err.println("erro => " + e);
		}
	}

	public static void main(String[] args) throws IOException {
		int contador = 1;
		
		leitor = new LeitorPiadas();

		try {
			ServerSocket server = new ServerSocket(50000);

			while (true) {

				Socket conexao = server.accept();
				Servidor sThread = new Servidor(conexao);

				System.out.println("Piada número " + contador + " gerada. ");

				contador += 1;
				sThread.start();
			}
		} catch (Exception e) {
			System.err.println("erro main => " + e);
		}
	}

}
