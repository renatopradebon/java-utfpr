/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.exercicio;

/**
 *
 * @author Renato Pradebon
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

    private Socket socket;

    public Servidor(Socket conexao) {
        this.socket = conexao;
    }

    @Override
    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            String cpf = entrada.readUTF();
            ValidaCpf valida = new ValidaCpf();
            Boolean cpfValido = valida.validaCpf(cpf);

            String isValidoCpf = cpfValido ? "CPF Válido" : "CPF Inválido";

            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());

//            saida.writeUTF(String.valueOf(cpfValido));
            saida.writeUTF(isValidoCpf);
            
            socket.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        int contador = 1;
        try {
            ServerSocket server = new ServerSocket(50000);

            while (true) {

                Socket conexao = server.accept();
                Servidor sThread = new Servidor(conexao);

                System.out.println("Consulta de CPF número " + contador);

                contador += 1;
                sThread.start();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
