/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.atividade2.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Renato Pradebon
 */
public class Chat {

    private static Socket socket;

    private static DataInputStream entrada;
    private static DataOutputStream saida;
    private static String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void main(String[] args) {
        try {
            Integer contador = 0;
            while (true) {
                socket = new Socket("127.0.0.1", 50000);

                entrada = new DataInputStream(socket.getInputStream());
                saida = new DataOutputStream(socket.getOutputStream());

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String mensagem = "";
                String mensagemEnviada;

                if (contador == 0) {
                    System.out.print("Digite seu nome: ");
                    nome = br.readLine().trim();
                    mensagemEnviada = "O usuário " + nome + " entrou no bate-papo.";
                } else {
                    System.out.print("Digite a mensagem: ");
                    mensagem = br.readLine().trim();
                    mensagemEnviada = nome + " diz: " + mensagem;
                }

                if (mensagem.toLowerCase().equals("sair")) {
                    saida.writeUTF("O usuário " + nome + " saiu do bate-papo.");
                    socket.close();
                }

                // envia ao servidor a mensagem
                saida.writeUTF(mensagemEnviada);

                // mostra a data e hora da conexão do servidor
                if (contador == 0) {
                    System.out.println(entrada.readUTF());
                }

                contador++;
            }
        } catch (SocketException ex) {
            System.err.println(ex);// + "Sinto muito, mas o servidor está fora do ar."
        } catch (Exception e) {
            System.err.println(e);//"Sinto muito, mas ocorreu um problema com a sua conexão."
        }
    }
}
