/**
 * Destination_list.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Destination_list  implements java.io.Serializable {
    private int response_code;

    private int source_id;

    private java.lang.String from_date;

    private int no_of_destination;

    private in.vrllogistics.www.webs.WS.Station[] destination_stations;

    public Destination_list() {
    }

    public Destination_list(
           int response_code,
           int source_id,
           java.lang.String from_date,
           int no_of_destination,
           in.vrllogistics.www.webs.WS.Station[] destination_stations) {
           this.response_code = response_code;
           this.source_id = source_id;
           this.from_date = from_date;
           this.no_of_destination = no_of_destination;
           this.destination_stations = destination_stations;
    }


    /**
     * Gets the response_code value for this Destination_list.
     * 
     * @return response_code
     */
    public int getResponse_code() {
        return response_code;
    }


    /**
     * Sets the response_code value for this Destination_list.
     * 
     * @param response_code
     */
    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }


    /**
     * Gets the source_id value for this Destination_list.
     * 
     * @return source_id
     */
    public int getSource_id() {
        return source_id;
    }


    /**
     * Sets the source_id value for this Destination_list.
     * 
     * @param source_id
     */
    public void setSource_id(int source_id) {
        this.source_id = source_id;
    }


    /**
     * Gets the from_date value for this Destination_list.
     * 
     * @return from_date
     */
    public java.lang.String getFrom_date() {
        return from_date;
    }


    /**
     * Sets the from_date value for this Destination_list.
     * 
     * @param from_date
     */
    public void setFrom_date(java.lang.String from_date) {
        this.from_date = from_date;
    }


    /**
     * Gets the no_of_destination value for this Destination_list.
     * 
     * @return no_of_destination
     */
    public int getNo_of_destination() {
        return no_of_destination;
    }


    /**
     * Sets the no_of_destination value for this Destination_list.
     * 
     * @param no_of_destination
     */
    public void setNo_of_destination(int no_of_destination) {
        this.no_of_destination = no_of_destination;
    }


    /**
     * Gets the destination_stations value for this Destination_list.
     * 
     * @return destination_stations
     */
    public in.vrllogistics.www.webs.WS.Station[] getDestination_stations() {
        return destination_stations;
    }


    /**
     * Sets the destination_stations value for this Destination_list.
     * 
     * @param destination_stations
     */
    public void setDestination_stations(in.vrllogistics.www.webs.WS.Station[] destination_stations) {
        this.destination_stations = destination_stations;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Destination_list)) return false;
        Destination_list other = (Destination_list) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.response_code == other.getResponse_code() &&
            this.source_id == other.getSource_id() &&
            ((this.from_date==null && other.getFrom_date()==null) || 
             (this.from_date!=null &&
              this.from_date.equals(other.getFrom_date()))) &&
            this.no_of_destination == other.getNo_of_destination() &&
            ((this.destination_stations==null && other.getDestination_stations()==null) || 
             (this.destination_stations!=null &&
              java.util.Arrays.equals(this.destination_stations, other.getDestination_stations())));
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
        _hashCode += getSource_id();
        if (getFrom_date() != null) {
            _hashCode += getFrom_date().hashCode();
        }
        _hashCode += getNo_of_destination();
        if (getDestination_stations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDestination_stations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDestination_stations(), i);
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
        new org.apache.axis.description.TypeDesc(Destination_list.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Destination_list"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "response_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Source_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("from_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "From_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_of_destination");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "No_of_destination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destination_stations");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Destination_stations"));
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
