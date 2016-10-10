package dao;

import java.text.DecimalFormat;

import model.Cliente;
import model.Movimento;
import model.Transacao;

public class ContaDAO
{
    private Cliente cliente;

    public ContaDAO(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public void deposito(double valor)
    {
        Movimento movimento = new Movimento();
        movimento.setNumero(cliente.getConta().getMovimento().size() + 1);
        movimento.setTransacao(Transacao.Credito);
        movimento.setValor(valor);
        cliente.getConta().getMovimento().add(movimento);
    }

    public void saque(double valor)
    {
        Movimento movimento = new Movimento();
        movimento.setNumero(cliente.getConta().getMovimento().size() + 1);
        movimento.setTransacao(Transacao.Debito);
        movimento.setValor(valor);
        cliente.getConta().getMovimento().add(movimento);
    }

    public void extrato()
    {
        double saldo = cliente.getConta().getSaldoInicial();
        System.out.println("Extrato: "+cliente.getNome());
        print("Saldo inicial",saldo);

        for (Movimento m : cliente.getConta().getMovimento())
        {
            print( m.getTransacao().toString(), m.getValor());
            
            if (m.getTransacao().equals(Transacao.Credito))
            {
                saldo = saldo + m.getValor();
            }
            else
            {
                saldo = saldo - m.getValor();
            }
        }
        print( "Saldo Final",saldo);
    }

    private String cifrao(double valor)
    {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
        String valorFormatado = decimalFormat.format(valor);
        return "R$" + "              ".substring( valorFormatado.length() ) + decimalFormat.format(valor);
    }
    
    private void print(String texto,double valor)
    {
        System.out.println( String.format("%-20s %s",texto, cifrao(valor)) );
    }

}
