/**
 * IMCServiceInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package imcservice.wsinterface;

public interface IMCServiceInterface extends java.rmi.Remote {
    public double calcularIMC(java.lang.String imc_nome, double imc_peso, double imc_altura) throws java.rmi.RemoteException, imcservice.wsinterface.Exception;
    public imcservice.wsinterface.DadosImc[] consultar() throws java.rmi.RemoteException;
}
