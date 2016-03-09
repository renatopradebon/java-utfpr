/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldapp;

/**
 *
 * @author renatopradebon
 */
public class HelloWorldApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		String[] frases1 = new String[6];
		frases1[5] = ";-)";
		frases1[0] = "Caro amigo, ";
		frases1[2] = "a programar em Java";
		frases1[4] = "Java na UTFPR";
		frases1[1] = "condido você a aprender";
		frases1[3] = "Faça especialização";
		
		int i;
		for(i = 0; i < frases1.length; i++)
			System.out.println(frases1[i]);	
    }
}
