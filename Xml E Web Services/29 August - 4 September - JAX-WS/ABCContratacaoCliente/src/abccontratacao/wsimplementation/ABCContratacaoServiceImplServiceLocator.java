/**
 * ABCContratacaoServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package abccontratacao.wsimplementation;

public class ABCContratacaoServiceImplServiceLocator extends org.apache.axis.client.Service implements abccontratacao.wsimplementation.ABCContratacaoServiceImplService {

    public ABCContratacaoServiceImplServiceLocator() {
    }


    public ABCContratacaoServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ABCContratacaoServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ABCContratacaoServiceImplPort
    private java.lang.String ABCContratacaoServiceImplPort_address = "http://localhost:3000/ABCContratacaoService";

    public java.lang.String getABCContratacaoServiceImplPortAddress() {
        return ABCContratacaoServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ABCContratacaoServiceImplPortWSDDServiceName = "ABCContratacaoServiceImplPort";

    public java.lang.String getABCContratacaoServiceImplPortWSDDServiceName() {
        return ABCContratacaoServiceImplPortWSDDServiceName;
    }

    public void setABCContratacaoServiceImplPortWSDDServiceName(java.lang.String name) {
        ABCContratacaoServiceImplPortWSDDServiceName = name;
    }

    public abccontratacao.wsinterface.ABCContratacaoService getABCContratacaoServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ABCContratacaoServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getABCContratacaoServiceImplPort(endpoint);
    }

    public abccontratacao.wsinterface.ABCContratacaoService getABCContratacaoServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            abccontratacao.wsimplementation.ABCContratacaoServiceImplPortBindingStub _stub = new abccontratacao.wsimplementation.ABCContratacaoServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getABCContratacaoServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setABCContratacaoServiceImplPortEndpointAddress(java.lang.String address) {
        ABCContratacaoServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (abccontratacao.wsinterface.ABCContratacaoService.class.isAssignableFrom(serviceEndpointInterface)) {
                abccontratacao.wsimplementation.ABCContratacaoServiceImplPortBindingStub _stub = new abccontratacao.wsimplementation.ABCContratacaoServiceImplPortBindingStub(new java.net.URL(ABCContratacaoServiceImplPort_address), this);
                _stub.setPortName(getABCContratacaoServiceImplPortWSDDServiceName());
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
        if ("ABCContratacaoServiceImplPort".equals(inputPortName)) {
            return getABCContratacaoServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wsimplementation.abccontratacao/", "ABCContratacaoServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wsimplementation.abccontratacao/", "ABCContratacaoServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ABCContratacaoServiceImplPort".equals(portName)) {
            setABCContratacaoServiceImplPortEndpointAddress(address);
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
