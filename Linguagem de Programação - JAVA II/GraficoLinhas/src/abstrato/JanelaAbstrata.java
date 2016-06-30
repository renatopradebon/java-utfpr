/*
 * JanelaAbstrata.java
 * @author fabricio@utfpr.edu.br
 */
package abstrato;

import interfaces.PadraoJanela;
import java.awt.Color;
import javax.swing.JFrame;

public abstract class JanelaAbstrata extends JFrame 
implements PadraoJanela {

    private int posicaoX = 180;
    private int posicaoY = 2;
    private int altura = 700;
    private int largura = 900;
    private Color corFrente = java.awt.Color.black;
    private Color corFundo = java.awt.Color.gray;
    private String titulo = "Comparacao entre "
            + "metodos de ordenacao";

    /**
     * @return the posicaoX
     */
    public int getPosicaoX() {
        return posicaoX;
    }

    /**
     * @param posicaoX the posicaoX to set
     */
    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    /**
     * @return the posicaoY
     */
    public int getPosicaoY() {
        return posicaoY;
    }

    /**
     * @param posicaoY the posicaoY to set
     */
    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * @return the largura
     */
    public int getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * @return the corFrente
     */
    public Color getCorFrente() {
        return corFrente;
    }

    /**
     * @param corFrente the corFrente to set
     */
    public void setCorFrente(Color corFrente) {
        this.corFrente = corFrente;
    }

    /**
     * @return the corFundo
     */
    public Color getCorFundo() {
        return corFundo;
    }

    /**
     * @param corFundo the corFundo to set
     */
    public void setCorFundo(Color corFundo) {
        this.corFundo = corFundo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
