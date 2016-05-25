package teste;

import com.javaes.controle.ImagemRN;
import com.javaes.modelo.Imagem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yoda
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Imagem imagem = new Imagem();
        ImagemRN imagemRN = new ImagemRN();

        File fileQuadrado = new File("C:\\var\\images\\quadrado.png");
        File fileTriangulo = new File("C:\\var\\images\\triangulo.png");
        File fileCirculo = new File("C:\\var\\images\\circulo.png");

        byte[] bFileQuadrado = new byte[(int) fileQuadrado.length()];
        byte[] bFileTriangulo = new byte[(int) fileTriangulo.length()];
        byte[] bFileCirculo = new byte[(int) fileCirculo.length()];
        try {
            //Quadrado
            FileInputStream fileInputStreamQuadrado = new FileInputStream(fileQuadrado);
            fileInputStreamQuadrado.read(bFileQuadrado);
            fileInputStreamQuadrado.close();
            //Triangulo
            FileInputStream fileInputStreamTriangulo = new FileInputStream(fileTriangulo);
            fileInputStreamTriangulo.read(bFileTriangulo);
            fileInputStreamTriangulo.close();
            //Circulo
            FileInputStream fileInputStreamCirculo = new FileInputStream(fileCirculo);
            fileInputStreamCirculo.read(bFileCirculo);
            fileInputStreamCirculo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Salva as imagem em banco
        imagem.setQuadrado(bFileQuadrado);
        imagem.setTriangulo(bFileTriangulo);
        imagem.setCirculo(bFileCirculo);
        imagemRN.salvar(imagem);

//        Imagem imagens = new Imagem();
//        ImagemRN imagemRN = new ImagemRN();
//        imagens = imagemRN.getImagem(3);
//
//        try {
//            //Quadrado
//            FileOutputStream imgQuadrado = new FileOutputStream("C:\\var\\saida\\quadradoSaida.png");
//            imgQuadrado.write(imagens.getQuadrado());
//            imgQuadrado.close();
//            //Triangulo
//            FileOutputStream imgTriangulo = new FileOutputStream("C:\\var\\saida\\trianguloSaida.png");
//            imgTriangulo.write(imagens.getTriangulo());
//            imgTriangulo.close();
//            //Circulo
//            FileOutputStream imgCirculo = new FileOutputStream("C:\\var\\saida\\circuloSaida.png");
//            imgCirculo.write(imagens.getCirculo());
//            imgCirculo.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
