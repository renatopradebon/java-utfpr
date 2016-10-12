/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.wsinterface;

/**
 *
 * @author Machado
 */
public class Conta {
    private String nome;
    private long numeroConta;
    private double saldo;
    
    public Conta(){
        
    }
    
    public Conta(long numeroConta, String nome, double saldo) {
            super();
            this.nome = nome;
            this.numeroConta = numeroConta;
            this.saldo = saldo;
    }    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
}
