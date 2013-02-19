/**
 * Stations_list.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Stations_list  implements java.io.Serializable {
    private int response_code;

    private int no_of_stations;

    private in.vrllogistics.www.webs.WS.Station[] stations;

    public Stations_list() {
    }

    public Stations_list(
           int response_code,
           int no_of_stations,
           in.vrllogistics.www.webs.WS.Station[] stations) {
           this.response_code = response_code;
           this.no_of_stations = no_of_stations;
           this.stations = stations;
    }


    /**
     * Gets the response_code value for this Stations_list.
     * 
     * @return response_code
     */
    public int getResponse_code() {
        return response_code;
    }


    /**
     * Sets the response_code value for this Stations_list.
     * 
     * @param response_code
     */
    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }


    /**
     * Gets the no_of_stations value for this Stations_list.
     * 
     * @return no_of_stations
     */
    public int getNo_of_stations() {
        return no_of_stations;
    }


    /**
     * Sets the no_of_stations value for this Stations_list.
     * 
     * @param no_of_stations
     */
    public void setNo_of_stations(int no_of_stations) {
        this.no_of_stations = no_of_stations;
    }


    /**
     * Gets the stations value for this Stations_list.
     * 
     * @return stations
     */
    public in.vrllogistics.www.webs.WS.Station[] getStations() {
        return stations;
    }


    /**
     * Sets the stations value for this Stations_list.
     * 
     * @param stations
     */
    public void setStations(in.vrllogistics.www.webs.WS.Station[] stations) {
        this.stations = stations;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Stations_list)) return false;
        Stations_list other = (Stations_list) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.response_code == other.getResponse_code() &&
            this.no_of_stations == other.getNo_of_stations() &&
            ((this.stations==null && other.getStations()==null) || 
             (this.stations!=null &&
              java.util.Arrays.equals(this.stations, other.getStations())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getResponse_code();
        _hashCode += getNo_of_stations();
        if (getStations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStations(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Stations_list.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "stations_list"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "response_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_of_stations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "no_of_stations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "stations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "station"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "station"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
