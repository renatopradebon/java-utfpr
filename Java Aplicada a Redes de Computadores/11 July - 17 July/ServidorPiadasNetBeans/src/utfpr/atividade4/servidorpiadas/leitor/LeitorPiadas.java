/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.atividade4.servidorpiadas.leitor;

/**
 *
 * @author renatopradebon
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorPiadas {

    private final Scanner leitor;

    public LeitorPiadas(String caminho) throws FileNotFoundException {
        this.leitor = new Scanner(new File(caminho));
    }

    public String getProximaPiada() {
        return leitor.nextLine();
    }

    // public static void main(String[] args) throws FileNotFoundException {
    //
    // LeitorPiadas leitor = new LeitorPiadas("./public/piadas.txt");
    //
    // System.out.println(leitor.getProximaPiada());
    // System.out.println(leitor.getProximaPiada());
    // System.out.println(leitor.getProximaPiada());
    // System.out.println(leitor.getProximaPiada());
    //
    // }
}
