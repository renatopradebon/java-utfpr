/*
 * PadraoJanela.java
 * @author fabricio@utfpr.edu.br
 */
package interfaces;

public interface PadraoJanela {

    public abstract void redimensiona(int novaLargura, int novaAltura);

    public abstract void mover(int novoX, int novoY);

    public abstract void trocaFrente(java.awt.Color novaCor);

    public abstract void trocaFundo(java.awt.Color novaCor);

    public abstract void trocaTitulo(String novoTitulo);
}