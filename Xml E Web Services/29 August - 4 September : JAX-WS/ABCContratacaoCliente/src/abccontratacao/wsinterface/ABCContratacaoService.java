/**
 * ABCContratacaoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package abccontratacao.wsinterface;

public interface ABCContratacaoService extends java.rmi.Remote {
    public java.lang.String poderContratar(java.lang.String abc_nome, int abc_idade, java.lang.String abc_cpf, int abc_sexo, java.lang.String abc_setor) throws java.rmi.RemoteException, abccontratacao.wsinterface.Exception;
    public abccontratacao.wsinterface.Pessoa[] consultar(java.lang.String abc_setor) throws java.rmi.RemoteException;
}
