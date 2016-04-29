
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author renatopradebon
 */
public class Leitura {

    public static String inData(String label) {
        InputStreamReader c = new InputStreamReader(System.in);
        
        BufferedReader cd = new BufferedReader(c);
        
        System.out.print(label);
        
        String s = "";
        
        try {
            s = cd.readLine();
        } catch (IOException e) {
            System.out.println("Erro de entrada");
        }
        
        return s;
    }

}
