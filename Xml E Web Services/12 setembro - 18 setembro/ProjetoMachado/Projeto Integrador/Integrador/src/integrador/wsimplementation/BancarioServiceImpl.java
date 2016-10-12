/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.wsimplementation;

import integrador.wsinterface.BancarioService;
import integrador.wsinterface.Conta;
import integrador.wsinterface.ContaDAO;
import javax.jws.WebService;

/**
 *
 * @author Machado
 */

@WebService(endpointInterface="integrador.wsinterface.BancarioService")
public class BancarioServiceImpl implements BancarioService{
    
    ContaDAO contas;
    
    public BancarioServiceImpl(){
        contas = new ContaDAO();
    }

    @Override
    public long criarConta(String nome, double saldo) {
        return contas.criarConta(new Conta(0,nome,saldo)).getNumeroConta();
    }

    @Override
    public double consultarSaldo(long numConta) {
        return contas.consultarSaldo(numConta);
    }

    @Override
    public String efetuarDeposito(long numConta, double valor) {
        return contas.efetuarDeposito(numConta, valor);
    }

    @Override
    public String efetuarSaque(long numConta, double valor) {
        return contas.efetuarSaque(numConta, valor);
    }

    @Override
    public String fecharConta(long numConta) {
        return contas.fechar(numConta);
    }    
}
