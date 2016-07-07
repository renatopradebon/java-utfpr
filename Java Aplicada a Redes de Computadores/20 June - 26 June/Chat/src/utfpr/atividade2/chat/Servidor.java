/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.atividade2.chat;

/**
 *
 * @author Renato Pradebon
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor extends Thread {

    private Socket socket;

    public Servidor(Socket conexao) {
        this.socket = conexao;
    }

    @Override
    public void run() {
        try {
            Date sysDate = new Date();
            SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy 'as' HH:mm:ss");
            String dataFormatada = dt.format(sysDate);
            
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            String mensagem = entrada.readUTF();

            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            
            String DataHoraConexao = "Conectado em " + dataFormatada;

            saida.writeUTF(DataHoraConexao);

            System.out.println(dataFormatada + " => "+ mensagem);

            socket.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(50000);
            while (true) {

                Socket conexao = server.accept();
                Servidor sThread = new Servidor(conexao);

                sThread.start();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
