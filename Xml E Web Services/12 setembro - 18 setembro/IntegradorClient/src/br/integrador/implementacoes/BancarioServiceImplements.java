/**
 * BancarioServiceImplements.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.integrador.implementacoes;

public interface BancarioServiceImplements extends java.rmi.Remote {
    public long criarConta(java.lang.String arg0, double arg1) throws java.rmi.RemoteException, br.integrador.implementacoes.Exception;
    public double consultarSaldo(long arg0) throws java.rmi.RemoteException, br.integrador.implementacoes.Exception;
    public java.lang.String efetuarDeposito(long arg0, double arg1) throws java.rmi.RemoteException, br.integrador.implementacoes.Exception;
    public java.lang.String efetuarSaque(long arg0, double arg1) throws java.rmi.RemoteException, br.integrador.implementacoes.Exception;
    public java.lang.String fecharConta(long arg0) throws java.rmi.RemoteException, br.integrador.implementacoes.Exception;
}
