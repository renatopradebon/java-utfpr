/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author renatopradebon
 */
public class EntDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Entre com um valor: ");
        InputStreamReader c = new InputStreamReader(System.in);
        BufferedReader cd = new BufferedReader(c);
        String s = "";
        try {
            s = cd.readLine();
        } catch (IOException e) {
            System.out.println("Erro de entrada");
        }

        int w = Integer.parseInt(s);

        System.out.println("O valor de entradada foi: " + w);
    }

}