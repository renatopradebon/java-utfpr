/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciojavaii;

import java.util.Scanner;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public class TamanhoPathTest {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um endereço de Path válido para consulta: ");
        String caminho = entrada.nextLine();

        new TamanhoPath().calculaTamanhoPath(caminho);
    }

}
