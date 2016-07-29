package utfpr.atividade5.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClientPiadas {

	public static void main(String[] args) {

		MulticastSocket socket = null;
		DatagramPacket datagram = null;

		byte[] buffer = new byte[256];

		String resposta;
		boolean continua = true;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Digite seu nome por favor: ");
			String nome = br.readLine();

			socket = new MulticastSocket(8888);

			InetAddress endereco = InetAddress.getByName("224.2.2.3");

			socket.joinGroup(endereco);

			while (continua) {
				datagram = new DatagramPacket(buffer, buffer.length);

				socket.receive(datagram);

				String msg = new String(buffer, 0, datagram.getLength());

				System.out.println(nome + ", a piada escolhida para você é: ");

				System.out.println(msg);

				System.out.println("Deseja receber uma nova piada? Qualquer caractere - Sim / N - Não: ");
				resposta = br.readLine();

				if ("N".equals(resposta.toUpperCase())) {
					continua = false;
				}
			}

			System.out.println("E isso é tudo pessoal!");
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}
