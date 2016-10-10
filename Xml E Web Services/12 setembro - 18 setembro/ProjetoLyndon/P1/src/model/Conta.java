package model;

import java.util.ArrayList;
import java.util.List;

public class Conta
{
    private String banco;
    private long numero;
    private double saldoInicial; 
    private List<Movimento> movimento;
    
    public Conta(String banco, double saldoInicial)
    {
        this.saldoInicial=saldoInicial;
        this.banco=banco;
        movimento = new ArrayList<>();
    }


    public long getNumero()
    {
        return numero;
    }

    public void setNumero(long numero)
    {
        this.numero = numero;
    }

    public List<Movimento> getMovimento()
    {
        return movimento;
    }

    public void setMovimento(List<Movimento> movimento)
    {
        this.movimento = movimento;
    }
 
    public double getSaldoInicial()
    {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial)
    {
        this.saldoInicial = saldoInicial;
    }

  
    public String getBanco()
    {
        return banco;
    }

    public void setBanco(String banco)
    {
        this.banco = banco;
    }
    
}
