package model;

public class Movimento
{
    private long numero;
    private Transacao transacao;
    private Double valor;
    
    public long getNumero()
    {
        return numero;
    }
    public void setNumero(long numero)
    {
        this.numero = numero;
    }
    public Transacao getTransacao()
    {
        return transacao;
    }
    public void setTransacao(Transacao transacao)
    {
        this.transacao = transacao;
    }
    public Double getValor()
    {
        return valor;
    }
    public void setValor(Double valor)
    {
        this.valor = valor;
    }
    
}
