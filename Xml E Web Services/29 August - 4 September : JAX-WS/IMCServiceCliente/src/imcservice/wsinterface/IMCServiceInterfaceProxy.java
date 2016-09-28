package imcservice.wsinterface;

public class IMCServiceInterfaceProxy implements imcservice.wsinterface.IMCServiceInterface {
  private String _endpoint = null;
  private imcservice.wsinterface.IMCServiceInterface iMCServiceInterface = null;
  
  public IMCServiceInterfaceProxy() {
    _initIMCServiceInterfaceProxy();
  }
  
  public IMCServiceInterfaceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIMCServiceInterfaceProxy();
  }
  
  private void _initIMCServiceInterfaceProxy() {
    try {
      iMCServiceInterface = (new imcservice.wsimplementation.IMCServiceImplServiceLocator()).getIMCServiceImplPort();
      if (iMCServiceInterface != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iMCServiceInterface)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iMCServiceInterface)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iMCServiceInterface != null)
      ((javax.xml.rpc.Stub)iMCServiceInterface)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public imcservice.wsinterface.IMCServiceInterface getIMCServiceInterface() {
    if (iMCServiceInterface == null)
      _initIMCServiceInterfaceProxy();
    return iMCServiceInterface;
  }
  
  public double calcularIMC(java.lang.String imc_nome, double imc_peso, double imc_altura) throws java.rmi.RemoteException, imcservice.wsinterface.Exception{
    if (iMCServiceInterface == null)
      _initIMCServiceInterfaceProxy();
    return iMCServiceInterface.calcularIMC(imc_nome, imc_peso, imc_altura);
  }
  
  public imcservice.wsinterface.DadosImc[] consultar() throws java.rmi.RemoteException{
    if (iMCServiceInterface == null)
      _initIMCServiceInterfaceProxy();
    return iMCServiceInterface.consultar();
  }
  
  
}