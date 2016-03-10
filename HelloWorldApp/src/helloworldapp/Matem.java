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
public class Matem {

    public static void main(String arg[]) {
        double f = 2;
        double g = 1.34;
        double h = 9;
        System.out.println("\nO seno da var 'f' eh: " + Math.sin(f));
        System.out.println("\nO cosseno da var 'f' eh: " + Math.cos(f));
        System.out.println("\nA tangente da var 'f' eh: " + Math.tan(f));
        System.out.println("\nO valor mínimo entre as vars 'f' 'g' eh: " + Math.min(f, g));
        System.out.println("\nO valor máximo entre as vars 'f' 'g' eh: " + Math.max(f, g));
        System.out.println("\nO valor arredondado da var 'g'(1.434) eh: " + Math.round(g));
        System.out.println("\nO valor arredondado para cima da var 'g'(1.434) eh: " + Math.ceil(g));
        System.out.println("\nO valor arredondado para baixo da var 'g'(1.434) eh: " + Math.floor(g));
        System.out.println("\nA raiz da var 'h' eh: " + Math.sqrt(h));
        System.out.println("\nA var 'f' elevada a var 'h' eh: " + Math.pow(f, h));
        System.out.println("\nO valor absoluto da var 'g'(1.434) eh: " + Math.abs(g));
        System.out.println("\nO valor do 'PI' eh: " + Math.PI);
        System.out.println("\nGerar um valor aleatório ente 0 e 1: " + Math.random());
        System.out.println("\n\nA próxima linha não faz parte da classe Math, trata-se do operador 'Módulo'");
        System.out.println("\nO resto da divisão entre as vars 'h' e 'f' eh: " + (f % h));
    }
}
