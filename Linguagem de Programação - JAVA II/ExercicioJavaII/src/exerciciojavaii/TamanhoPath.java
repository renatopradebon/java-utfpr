/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciojavaii;

import java.io.File;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public class TamanhoPath {

    public static void calculaTamanhoPath(String caminho) {

        File arquivo = new File(caminho);

        if (arquivo.exists()) {

            if (arquivo.isDirectory()) {

                InformacoesPath tamanhoDoArquivo = new InformacoesPath(arquivo);

                System.out.println("\nO endereço '" + caminho
                        + "' é válido e possui um tamanho de aproximadamente "
                        + tamanhoDoArquivo.getTamanhoPastas()
                        + " MB");
                System.out.println("\nO path possui " + tamanhoDoArquivo.getQtdePastas() + " pasta(s).");
                System.out.println("\nO path possui " + tamanhoDoArquivo.getQtdeArquivos() + " arquivos(s).");

            } else if (arquivo.exists()) {
                System.out.println("\nO Path digitado é um arquivo que contém "
                        + new InformacoesPath(arquivo).getTamanhoArquivo()
                        + " MB");
            }
        } else {
            System.out.println("\nEndereço de Path Inválido");
        }
    }
}
