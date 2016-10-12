/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import integrador.wsinterface.Conta;
import integrador.wsinterface.ContaDAO;

/**
 *
 * @author Machado
 */
public class TesteJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conta conta1 = new Conta();
        conta1.setNumeroConta(4);
        conta1.setNome("Alex");
        conta1.setSaldo(100);
        ContaDAO dao = new ContaDAO();
        dao.criarConta(conta1);
        
        
        Conta conta2 = new Conta();
        conta2.setNumeroConta(5);
        conta2.setNome("Machado");
        conta2.setSaldo(200);
        dao.criarConta(conta2);
        
    }
    
}
