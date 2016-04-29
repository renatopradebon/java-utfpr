/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author renatopradebon
 */
public class TestDiv {

    public static void main(String arg[]) {
        Leitura l = new Leitura();

        boolean digitouValorErrado = true;

        while (digitouValorErrado) {
            try {
                int numero = Integer.parseInt(l.inData("\nEntre com um numero: "));
                int divisor = Integer.parseInt(l.inData("\nEntre com Divisor: "));
                System.out.println("\n O resultador da divisão eh: " + numero / divisor);
                digitouValorErrado = false;
            } catch (ArithmeticException er_Div) {
                System.err.println("\n Não existe divisão por zero: erro => " + er_Div);
            } catch (NumberFormatException er_Num) {
                System.err.println("\n Os valores devem obrigatoriamente ser NUMEROS => " + er_Num);
            }
        }
    }
}
