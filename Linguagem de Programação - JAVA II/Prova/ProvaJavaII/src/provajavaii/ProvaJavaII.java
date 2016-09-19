/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provajavaii;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author renatopradebon
 */
public final class ProvaJavaII {

    static private String mensagem;

    static private File arquivo;

    public ProvaJavaII(String mensagem, String arquivo) {
        ProvaJavaII.mensagem = mensagem;
        ProvaJavaII.arquivo = new File(arquivo);
    }

    public static Boolean existeArquivo() throws IOException {
        Boolean retorno;

        if (ProvaJavaII.arquivo.isFile()) {
            retorno = true;
        } else {
            ProvaJavaII.criaNovoArquivo();            
            retorno = false;
        }
        return retorno;
    }

    public static void criaNovoArquivo() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ProvaJavaII.arquivo))) {
            writer.write(ProvaJavaII.mensagem);
            //Criando o conteúdo do arquivo
            writer.flush();
            //Fechando conexão e escrita do arquivo.

        } catch (IOException ioException) {
            System.err.println(ioException);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);

        System.out.println(
                "Digite um endereço de Path válido para consulta: ");
        String arquivo = entrada.nextLine();

        System.out.println("Digite uma mensagem para salvar no arquivo: ");
        String mensagem = entrada.nextLine();

        ProvaJavaII provajava = new ProvaJavaII(mensagem, arquivo);

        Boolean resultado = provajava.existeArquivo();

        System.out.println(resultado);
    }
}
