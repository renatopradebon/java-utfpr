package utfpr.atividade5.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import utfpr.atividade5.servidor.cpf.ValidaCpf;

public class MulticastServerCpf extends Thread implements Runnable {

	private static ValidaCpf valida;
	private Boolean imprimeCpfVerificados;

	public MulticastServerCpf(Boolean imprimeCpfVerificados) {
		this.imprimeCpfVerificados = imprimeCpfVerificados;
		System.out.println("Servidor de Verificação de CPF iniciado.");
	}

	@Override
	public void run() {

		DatagramSocket socket = null;
		DatagramPacket datagram = null;

		String enderecoInet = "224.2.2.3";

		byte[] buffer;
		// porta servidor de CPF
		final int porta = 8889;

		try {
			socket = new DatagramSocket();
			String cpf;
			Boolean cpfValido;
			String isValidoCpf;
			valida = new ValidaCpf();
			InetAddress endereco;

			while (true) {
				cpf = "";
				ValidaCpf valida = new ValidaCpf();
				cpfValido = valida.validaCpf(cpf);

				isValidoCpf = cpfValido ? "válido" : "inválido";

				buffer = isValidoCpf.getBytes();

				endereco = InetAddress.getByName(enderecoInet);
				datagram = new DatagramPacket(buffer, buffer.length, endereco, porta);

				socket.send(datagram);

				if (imprimeCpfVerificados) {
					System.out.println("O CPF " + cpf + " é " + isValidoCpf);
				}				
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}
