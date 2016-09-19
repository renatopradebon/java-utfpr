/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.exercicio;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Renato Pradebon
 */
public class TesteValidaCpf {
    
    private static Socket socket;
    
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {

        try {            
            socket = new Socket("127.0.0.1", 50000);
            
            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Entre com o CPF: ");
            String cpf = br.readLine();
            
            saida.writeUTF(cpf);
            
            String isValidCpf = entrada.readUTF();
//            boolean isValidCpf = entrada.readUTF();
            
            System.out.println(isValidCpf);
            
            socket.close();
            
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}
