package abccontratacao.wsinterface;

public class ABCContratacaoServiceProxy implements abccontratacao.wsinterface.ABCContratacaoService {
  private String _endpoint = null;
  private abccontratacao.wsinterface.ABCContratacaoService aBCContratacaoService = null;
  
  public ABCContratacaoServiceProxy() {
    _initABCContratacaoServiceProxy();
  }
  
  public ABCContratacaoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initABCContratacaoServiceProxy();
  }
  
  private void _initABCContratacaoServiceProxy() {
    try {
      aBCContratacaoService = (new abccontratacao.wsimplementation.ABCContratacaoServiceImplServiceLocator()).getABCContratacaoServiceImplPort();
      if (aBCContratacaoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aBCContratacaoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aBCContratacaoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aBCContratacaoService != null)
      ((javax.xml.rpc.Stub)aBCContratacaoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public abccontratacao.wsinterface.ABCContratacaoService getABCContratacaoService() {
    if (aBCContratacaoService == null)
      _initABCContratacaoServiceProxy();
    return aBCContratacaoService;
  }
  
  public java.lang.String poderContratar(java.lang.String abc_nome, int abc_idade, java.lang.String abc_cpf, int abc_sexo, java.lang.String abc_setor) throws java.rmi.RemoteException, abccontratacao.wsinterface.Exception{
    if (aBCContratacaoService == null)
      _initABCContratacaoServiceProxy();
    return aBCContratacaoService.poderContratar(abc_nome, abc_idade, abc_cpf, abc_sexo, abc_setor);
  }
  
  public abccontratacao.wsinterface.Pessoa[] consultar(java.lang.String abc_setor) throws java.rmi.RemoteException{
    if (aBCContratacaoService == null)
      _initABCContratacaoServiceProxy();
    return aBCContratacaoService.consultar(abc_setor);
  }
  
  
}