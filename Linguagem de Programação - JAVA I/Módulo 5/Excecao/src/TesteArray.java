/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author renatopradebon
 */
public class TesteArray {

    public static void main(String arg[]) {
        Leitura leitura = new Leitura();
        int vetor[] = new int[5];
        boolean digitouValorErrado = true;

        while (digitouValorErrado) {
            try {
                int valor = Integer.parseInt(leitura.inData("\nInforme o valor: "));
                int endereco = Integer.parseInt(leitura.inData("\nInforme o endereço do vetor: "));
                vetor[endereco] = valor;
                System.out.println("\n Valor " + vetor[endereco] + " no endereço " + endereco + ".");
                digitouValorErrado = false;
            } catch (ArrayIndexOutOfBoundsException er_Array) {
                System.err.println("Posição inválida para o array => " + er_Array);
            } catch (NumberFormatException er_Num) {
                System.err.println("Permitido somente números => " + er_Num.getLocalizedMessage());
            }
        }
    }
}
