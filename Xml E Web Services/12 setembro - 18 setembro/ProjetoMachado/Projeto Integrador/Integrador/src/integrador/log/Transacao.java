/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.log;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Machado
 */

@XmlRootElement
public class Transacao {
    
    public static final String CRIAR = "CRIAR";
    public static final String SACAR = "SACAR";
    public static final String DEPOSITAR = "DEPOSITAR";
    public static final String FECHAR = "FECHAR";       
    
    long numeroConta;
    String tipoTransacao; //criacao, saque, deposito, fechamento
    String descricao; //descricao detalhada da transacao (com valores)
    String data;
    
    public Transacao() {
        this.numeroConta = 0l;
        this.tipoTransacao = "";
        this.descricao = "";
    }    
    
    public long getNumeroConta() {
        return numeroConta;
    }
    
    public void setNumeroConta(long numeroConta) {
        this.numeroConta = numeroConta;
    }
    
    public String getTipoTransacao() {
        return tipoTransacao;
    }
    
    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    @Override
    public String toString() {       
        return " Numero Conta: " + getNumeroConta() + " " +
               " Data: " + getData() + " " +
               " Operação: " + getTipoTransacao() + " " +
               " Descrição: " + getDescricao();           
    }    
}
