package br.integrador.implementacoes;

public class BancarioServiceImplementsProxy implements br.integrador.implementacoes.BancarioServiceImplements {
  private String _endpoint = null;
  private br.integrador.implementacoes.BancarioServiceImplements bancarioServiceImplements = null;
  
  public BancarioServiceImplementsProxy() {
    _initBancarioServiceImplementsProxy();
  }
  
  public BancarioServiceImplementsProxy(String endpoint) {
    _endpoint = endpoint;
    _initBancarioServiceImplementsProxy();
  }
  
  private void _initBancarioServiceImplementsProxy() {
    try {
      bancarioServiceImplements = (new br.integrador.implementacoes.BancarioServiceImplementsServiceLocator()).getBancarioServiceImplementsPort();
      if (bancarioServiceImplements != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bancarioServiceImplements)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bancarioServiceImplements)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bancarioServiceImplements != null)
      ((javax.xml.rpc.Stub)bancarioServiceImplements)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.integrador.implementacoes.BancarioServiceImplements getBancarioServiceImplements() {
    if (bancarioServiceImplements == null)
      _initBancarioServiceImplementsProxy();
    return bancarioServiceImplements;
  }
  
  public long criarConta(java.lang.String arg0, double arg1) throws java.rmi.RemoteException, br.integrador.implementacoes.Exception{
    if (bancarioServiceImplements == null)
      _initBancarioServiceImplementsProxy();
    return bancarioServiceImplements.criarConta(arg0, arg1);
  }
  
  public double consultarSaldo(long arg0) throws java.rmi.RemoteException, br.integrador.implementacoes.Exception{
    if (bancarioServiceImplements == null)
      _initBancarioServiceImplementsProxy();
    return bancarioServiceImplements.consultarSaldo(arg0);
  }
  
  public java.lang.String efetuarDeposito(long arg0, double arg1) throws java.rmi.RemoteException, br.integrador.implementacoes.Exception{
    if (bancarioServiceImplements == null)
      _initBancarioServiceImplementsProxy();
    return bancarioServiceImplements.efetuarDeposito(arg0, arg1);
  }
  
  public java.lang.String efetuarSaque(long arg0, double arg1) throws java.rmi.RemoteException, br.integrador.implementacoes.Exception{
    if (bancarioServiceImplements == null)
      _initBancarioServiceImplementsProxy();
    return bancarioServiceImplements.efetuarSaque(arg0, arg1);
  }
  
  public java.lang.String fecharConta(long arg0) throws java.rmi.RemoteException, br.integrador.implementacoes.Exception{
    if (bancarioServiceImplements == null)
      _initBancarioServiceImplementsProxy();
    return bancarioServiceImplements.fecharConta(arg0);
  }
  
  
}