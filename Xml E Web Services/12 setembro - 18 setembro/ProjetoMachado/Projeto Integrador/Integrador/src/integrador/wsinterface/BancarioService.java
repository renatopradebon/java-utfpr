/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador.wsinterface;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author Machado
 */
@WebService
public interface BancarioService {
    public @WebResult(name="bs_numeroConta") long
        criarConta(@WebParam(name="bs_nomeCliente") String nome,
                   @WebParam(name="bs_saldoInicial") double saldo)
            throws Exception;
        
    public @WebResult(name="bs_saldoConta") double
        consultarSaldo(@WebParam(name="bs_numeroConta") long numConta)
            throws Exception;
        
    public @WebResult(name="bs_resposta") String
        efetuarDeposito(@WebParam(name="bs_numeroConta") long numConta,
                        @WebParam(name="bs_valorDepositado") double valor)
            throws Exception;
        
    public @WebResult(name="bs_resposta") String
        efetuarSaque(@WebParam(name="bs_numeroConta") long numConta,
                     @WebParam(name="bs_valorSacado") double valor)
            throws Exception;
        
    public @WebResult(name="bs_resposta") String
        fecharConta(@WebParam(name="bs_numeroConta") long numConta)
            throws Exception;    
}
