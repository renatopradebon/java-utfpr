/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.log;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Machado
 */
@XmlRootElement
public class TransacaoStore {
    
    private String nome;
    private ArrayList<Transacao> transacaoList;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Transacao> getTransactionList() {
        return transacaoList;
    }
    
    public void setTransactionList(ArrayList<Transacao> transacaoList) {
        this.transacaoList = transacaoList;
    }  
}
