package webservicecomarquivos.wsinterface;

public class FileServiceProxy implements webservicecomarquivos.wsinterface.FileService {
  private String _endpoint = null;
  private webservicecomarquivos.wsinterface.FileService fileService = null;
  
  public FileServiceProxy() {
    _initFileServiceProxy();
  }
  
  public FileServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initFileServiceProxy();
  }
  
  private void _initFileServiceProxy() {
    try {
      fileService = (new webservicecomarquivos.wsimplementation.FileServiceImplServiceLocator()).getFileServiceImplPort();
      if (fileService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fileService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fileService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fileService != null)
      ((javax.xml.rpc.Stub)fileService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservicecomarquivos.wsinterface.FileService getFileService() {
    if (fileService == null)
      _initFileServiceProxy();
    return fileService;
  }
  
  public java.lang.String salvarArquivo(java.lang.String fs_nomeArquivo, byte[] fs_arquivoEnviado) throws java.rmi.RemoteException{
    if (fileService == null)
      _initFileServiceProxy();
    return fileService.salvarArquivo(fs_nomeArquivo, fs_arquivoEnviado);
  }
  
  public byte[] downloadArquivo(java.lang.String fs_nomeArquivo) throws java.rmi.RemoteException, webservicecomarquivos.wsinterface.Exception{
    if (fileService == null)
      _initFileServiceProxy();
    return fileService.downloadArquivo(fs_nomeArquivo);
  }
  
  
}