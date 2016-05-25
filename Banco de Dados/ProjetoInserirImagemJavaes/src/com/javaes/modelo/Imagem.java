package com.javaes.modelo;

import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author javaes
 */
@Entity
public class Imagem implements Serializable 
{
    private static final long serialVersionUID = -4821574219095544368L;
    public Imagem(){}
    @Id
    @GeneratedValue
    private long idImagem;
    private byte[] quadrado;
    private byte[] triangulo;
    private byte[] circulo;

    public byte[] getCirculo() 
    {
        return circulo;
    }

    public void setCirculo(byte[] circulo) 
    {
        this.circulo = circulo;
    }

    public byte[] getQuadrado() 
    {
        return quadrado;
    }

    public void setQuadrado(byte[] quadrado) 
    {
        this.quadrado = quadrado;
    }

    public byte[] getTriangulo() 
    {
        return triangulo;
    }

    public void setTriangulo(byte[] triangulo) 
    {
        this.triangulo = triangulo;
    }

    public long getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(long idImagem) {
        this.idImagem = idImagem;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Imagem other = (Imagem) obj;
        if (this.idImagem != other.idImagem) {
            return false;
        }
        if (!Arrays.equals(this.quadrado, other.quadrado)) {
            return false;
        }
        if (!Arrays.equals(this.triangulo, other.triangulo)) {
            return false;
        }
        if (!Arrays.equals(this.circulo, other.circulo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (this.idImagem ^ (this.idImagem >>> 32));
        hash = 79 * hash + Arrays.hashCode(this.quadrado);
        hash = 79 * hash + Arrays.hashCode(this.triangulo);
        hash = 79 * hash + Arrays.hashCode(this.circulo);
        return hash;
    }


    
}
