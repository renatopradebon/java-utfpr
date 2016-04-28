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
public class ExercicioG1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String primeiroValor;
        String segundoValor;
        String opEscolhida;
        String opEscolhidaExtenso = "";

        Integer primeiroValorInteger;
        Integer segundoValorInteger;
        Integer opEscolhidaInteger;

        Integer resultado = 0;
        try {
            System.out.println("Entre com o primeiro valor: ");
            InputStreamReader c = new InputStreamReader(System.in);
            BufferedReader cd = new BufferedReader(c);
            primeiroValor = cd.readLine();

            System.out.println("Entre com o segundo valor: ");
            InputStreamReader sv = new InputStreamReader(System.in);
            BufferedReader svb = new BufferedReader(sv);
            segundoValor = svb.readLine();

            System.out.println("Agora, selecione a opção desejada para o cálculo: \n"
                    + "1 - Somar\n"
                    + "2 - Multiplicar\n"
                    + "3 - Subtrair\n"
                    + "4 - Dividir\n"
            );
            InputStreamReader op = new InputStreamReader(System.in);
            BufferedReader opb = new BufferedReader(op);
            opEscolhida = opb.readLine();

            opEscolhidaInteger = Integer.parseInt(opEscolhida);
            primeiroValorInteger = Integer.parseInt(primeiroValor);
            segundoValorInteger = Integer.parseInt(segundoValor);

            switch (opEscolhidaInteger) {
                case 1:
                    resultado = primeiroValorInteger + segundoValorInteger;
                    opEscolhidaExtenso = "soma";
                    break;
                case 2:
                    resultado = primeiroValorInteger * segundoValorInteger;
                    opEscolhidaExtenso = "multiplicação";
                    break;
                case 3:
                    resultado = primeiroValorInteger - segundoValorInteger;
                    opEscolhidaExtenso = "subtração";
                    break;
                case 4:
                    resultado = primeiroValorInteger / segundoValorInteger;
                    opEscolhidaExtenso = "divisão";
                    break;

            }

            System.out.println("O resultado da " + opEscolhidaExtenso + " é : " + resultado);

        } catch (IOException e) {
            System.out.println("Erro de entrada");
        }
    }
}