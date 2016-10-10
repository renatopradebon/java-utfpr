package model;

public class Cliente
{
    private long codigo;
    private String nome;
    private Conta conta;

    public long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(long codigo)
    {
        this.codigo = codigo;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Conta getConta()
    {
        return conta;
    }

    public void setConta(Conta conta)
    {
        this.conta = conta;
    }

    public Cliente(String nome, String banco, double saldoInicial)
    {
        this.nome = nome;
        conta = new Conta(banco, saldoInicial);
    }

}
