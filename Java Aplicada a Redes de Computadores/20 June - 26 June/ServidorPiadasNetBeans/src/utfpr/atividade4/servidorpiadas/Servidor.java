/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.atividade4.servidorpiadas;

/**
 *
 * @author renatopradebon
 */
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import utfpr.atividade4.servidorpiadas.leitor.LeitorPiadas;

public class Servidor extends Thread {

    private Socket socket;

    public Servidor(Socket conexao) {
        this.socket = conexao;
    }

    @Override
    public void run() {
        try {
            String caminho = "./public/piadas.txt";
            LeitorPiadas leitor = new LeitorPiadas(caminho);

            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());

            saida.writeUTF(leitor.getProximaPiada());

            System.out.println("cara novo");

            socket.close();

        } catch (Exception e) {
            System.err.println("erro => " + e);
        }
    }

    public static void main(String[] args) throws SocketException {
        int contador = 1;

        try {
            while (true) {
                ServerSocket server = new ServerSocket(48000);

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
