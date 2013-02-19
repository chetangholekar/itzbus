/**
 * VRL_x0020_Booking_x0020_Web_x0020_ServicesLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class VRL_x0020_Booking_x0020_Web_x0020_ServicesLocator extends org.apache.axis.client.Service implements in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_Services {

/**
 * API's to fulfill Online Booking through Web Services
 */

    public VRL_x0020_Booking_x0020_Web_x0020_ServicesLocator() {
    }


    public VRL_x0020_Booking_x0020_Web_x0020_ServicesLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public VRL_x0020_Booking_x0020_Web_x0020_ServicesLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap
    private java.lang.String VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap_address = "http://210.212.198.5/webs/ws/vrlbookingservice.asmx";

    public java.lang.String getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapAddress() {
        return VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapWSDDServiceName = "VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap";

    public java.lang.String getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapWSDDServiceName() {
        return VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapWSDDServiceName;
    }

    public void setVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapWSDDServiceName(java.lang.String name) {
        VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapWSDDServiceName = name;
    }

    public in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap(endpoint);
    }

    public in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapStub _stub = new in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapStub(portAddress, this);
            _stub.setPortName(getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapEndpointAddress(java.lang.String address) {
        VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap_address = address;
    }


    // Use to get a proxy class for VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12
    private java.lang.String VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12_address = "http://210.212.198.5/webs/ws/vrlbookingservice.asmx";

    public java.lang.String getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12Address() {
        return VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12WSDDServiceName = "VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12";

    public java.lang.String getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12WSDDServiceName() {
        return VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12WSDDServiceName;
    }

    public void setVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12WSDDServiceName(java.lang.String name) {
        VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12WSDDServiceName = name;
    }

    public in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12(endpoint);
    }

    public in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12Stub _stub = new in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12Stub(portAddress, this);
            _stub.setPortName(getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12EndpointAddress(java.lang.String address) {
        VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapStub _stub = new in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapStub(new java.net.URL(VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap_address), this);
                _stub.setPortName(getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapWSDDServiceName());
                return _stub;
            }
            if (in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12Stub _stub = new in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12Stub(new java.net.URL(VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12_address), this);
                _stub.setPortName(getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12WSDDServiceName());
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
        if ("VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap".equals(inputPortName)) {
            return getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap();
        }
        else if ("VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12".equals(inputPortName)) {
            return getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "VRL_x0020_Booking_x0020_Web_x0020_Services");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap"));
            ports.add(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap".equals(portName)) {
            setVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapEndpointAddress(address);
        }
        else 
if ("VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12".equals(portName)) {
            setVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap12EndpointAddress(address);
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
