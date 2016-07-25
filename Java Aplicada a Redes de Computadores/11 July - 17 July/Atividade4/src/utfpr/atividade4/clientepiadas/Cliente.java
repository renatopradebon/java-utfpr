package utfpr.atividade4.clientepiadas;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

public class Cliente {

	private static Socket socket;
	private static DataInputStream entrada;
	private static DataOutputStream saida;

	public static void main(String[] args) {
		String resposta;
		boolean continua = true;
		try {
			// Recebe do usuário algum valor
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Digite seu nome por favor: ");
			String nome = br.readLine();

			while (continua) {

				socket = new Socket("127.0.0.1", 50000);

				entrada = new DataInputStream(socket.getInputStream());
				saida = new DataOutputStream(socket.getOutputStream());

				// O valor é enviado ao servidor
				saida.writeUTF(nome);

				System.out.println(nome + ", a piada escolhida para você é: ");

				// Recebe-se o resultado do servidor
				String resultado = entrada.readUTF();

				// Mostra o resultado na tela
				System.out.println(resultado);

				socket.close();
				
				if("Sem mais piadas para enviar".equals(resultado)) {
					break;
				}

				System.out.println("Deseja receber uma nova piada? Qualquer caractere - Sim / N - Não: ");
				resposta = br.readLine();

				if ("N".equals(resposta.toUpperCase())) {
					continua = false;
				}
			}

		} catch (ConnectException ex) {
			System.err.println("Sinto muito, mas o servidor está fora do ar.");
		} catch (IOException ex) {
			System.err.println("Sinto muito, mas houve um erro de E/S.");
		}
	}

}
