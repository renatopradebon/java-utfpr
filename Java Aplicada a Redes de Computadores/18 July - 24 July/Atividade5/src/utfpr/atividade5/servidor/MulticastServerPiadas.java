package utfpr.atividade5.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import utfpr.atividade5.servidor.leitor.LeitorPiadas;

/**
 * @author Renato Pradebon
 *
 */
public class MulticastServerPiadas extends Thread {
	private static LeitorPiadas leitor;

	public static void main(String[] args) {

		DatagramSocket socket = null;
		DatagramPacket datagram = null;

		String enderecoInet = "224.2.2.3";

		byte[] buffer;
		final int porta = 8888;

		try {
			socket = new DatagramSocket();
			long contador = 0;
			String piada;
			leitor = new LeitorPiadas();

			while (true) {
				piada = leitor.getProximaPiada();

				buffer = piada.getBytes();

				InetAddress endereco = InetAddress.getByName(enderecoInet);
				datagram = new DatagramPacket(buffer, buffer.length, endereco, porta);

				socket.send(datagram);

				System.out.println("A piada de número " + contador + " é: " + piada);
				contador++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
					System.err.println("Erro => " + ie);
				}
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}
