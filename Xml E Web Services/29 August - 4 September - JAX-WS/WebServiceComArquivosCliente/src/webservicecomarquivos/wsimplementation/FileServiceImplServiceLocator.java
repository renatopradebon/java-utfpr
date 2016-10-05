/**
 * FileServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservicecomarquivos.wsimplementation;

public class FileServiceImplServiceLocator extends org.apache.axis.client.Service implements webservicecomarquivos.wsimplementation.FileServiceImplService {

    public FileServiceImplServiceLocator() {
    }


    public FileServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FileServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FileServiceImplPort
    private java.lang.String FileServiceImplPort_address = "http://localhost:3000/FileService";

    public java.lang.String getFileServiceImplPortAddress() {
        return FileServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FileServiceImplPortWSDDServiceName = "FileServiceImplPort";

    public java.lang.String getFileServiceImplPortWSDDServiceName() {
        return FileServiceImplPortWSDDServiceName;
    }

    public void setFileServiceImplPortWSDDServiceName(java.lang.String name) {
        FileServiceImplPortWSDDServiceName = name;
    }

    public webservicecomarquivos.wsinterface.FileService getFileServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FileServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFileServiceImplPort(endpoint);
    }

    public webservicecomarquivos.wsinterface.FileService getFileServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            webservicecomarquivos.wsimplementation.FileServiceImplPortBindingStub _stub = new webservicecomarquivos.wsimplementation.FileServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getFileServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFileServiceImplPortEndpointAddress(java.lang.String address) {
        FileServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (webservicecomarquivos.wsinterface.FileService.class.isAssignableFrom(serviceEndpointInterface)) {
                webservicecomarquivos.wsimplementation.FileServiceImplPortBindingStub _stub = new webservicecomarquivos.wsimplementation.FileServiceImplPortBindingStub(new java.net.URL(FileServiceImplPort_address), this);
                _stub.setPortName(getFileServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FileServiceImplPort".equals(inputPortName)) {
            return getFileServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wsimplementation.webservicecomarquivos/", "FileServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wsimplementation.webservicecomarquivos/", "FileServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FileServiceImplPort".equals(portName)) {
            setFileServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
