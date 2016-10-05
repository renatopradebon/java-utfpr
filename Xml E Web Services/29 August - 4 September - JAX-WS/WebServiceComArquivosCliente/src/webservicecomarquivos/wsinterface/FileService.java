/**
 * FileService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservicecomarquivos.wsinterface;

public interface FileService extends java.rmi.Remote {
    public java.lang.String salvarArquivo(java.lang.String fs_nomeArquivo, byte[] fs_arquivoEnviado) throws java.rmi.RemoteException;
    public byte[] downloadArquivo(java.lang.String fs_nomeArquivo) throws java.rmi.RemoteException, webservicecomarquivos.wsinterface.Exception;
}
