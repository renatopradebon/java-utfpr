/**
 * IMCServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package imcservice.wsimplementation;

public class IMCServiceImplServiceLocator extends org.apache.axis.client.Service implements imcservice.wsimplementation.IMCServiceImplService {

    public IMCServiceImplServiceLocator() {
    }


    public IMCServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IMCServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IMCServiceImplPort
    private java.lang.String IMCServiceImplPort_address = "http://localhost:8080/IMCService";

    public java.lang.String getIMCServiceImplPortAddress() {
        return IMCServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IMCServiceImplPortWSDDServiceName = "IMCServiceImplPort";

    public java.lang.String getIMCServiceImplPortWSDDServiceName() {
        return IMCServiceImplPortWSDDServiceName;
    }

    public void setIMCServiceImplPortWSDDServiceName(java.lang.String name) {
        IMCServiceImplPortWSDDServiceName = name;
    }

    public imcservice.wsinterface.IMCServiceInterface getIMCServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IMCServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIMCServiceImplPort(endpoint);
    }

    public imcservice.wsinterface.IMCServiceInterface getIMCServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            imcservice.wsimplementation.IMCServiceImplPortBindingStub _stub = new imcservice.wsimplementation.IMCServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getIMCServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIMCServiceImplPortEndpointAddress(java.lang.String address) {
        IMCServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (imcservice.wsinterface.IMCServiceInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                imcservice.wsimplementation.IMCServiceImplPortBindingStub _stub = new imcservice.wsimplementation.IMCServiceImplPortBindingStub(new java.net.URL(IMCServiceImplPort_address), this);
                _stub.setPortName(getIMCServiceImplPortWSDDServiceName());
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
        if ("IMCServiceImplPort".equals(inputPortName)) {
            return getIMCServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://wsimplementation.imcservice/", "IMCServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://wsimplementation.imcservice/", "IMCServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IMCServiceImplPort".equals(portName)) {
            setIMCServiceImplPortEndpointAddress(address);
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
