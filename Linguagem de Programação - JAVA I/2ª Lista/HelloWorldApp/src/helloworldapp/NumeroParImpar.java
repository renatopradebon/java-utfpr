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
public class NumeroParImpar {
    public static void main(String arg[]) {
        try {
            System.out.println("Entre com valor: ");
            InputStreamReader c = new InputStreamReader(System.in);
            BufferedReader cd = new BufferedReader(c);
            String primeiroValor = cd.readLine();
            double parseDouble = Double.parseDouble(primeiroValor);
            
            System.out.println("O número digitado é " + (parseDouble % 2 == 0 ? "par" : "impar"));

        } catch (IOException e) {
            System.out.println("Erro de entrada");
        }        
        
        
    }
}
