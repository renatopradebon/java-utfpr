/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.atividade4.clientepiadas;

/**
 *
 * @author renatopradebon
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

public class Cliente {

    private static Socket socket;
    private static DataInputStream entrada;

    public static void main(String[] args) {
        String resposta;
        boolean continua = true;
        try {
            while (continua) {
                socket = new Socket("127.0.0.1", 50000);

                entrada = new DataInputStream(socket.getInputStream());

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("A piada da vez é: ");

                // Recebe-se o resultado do servidor
                String resultado = entrada.readUTF();

                // Mostra o resultado na tela
                System.out.println(resultado);

                socket.close();
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
