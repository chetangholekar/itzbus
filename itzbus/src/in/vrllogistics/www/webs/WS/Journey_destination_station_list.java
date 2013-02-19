/**
 * Journey_destination_station_list.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Journey_destination_station_list  implements java.io.Serializable {
    private int d_station_id;

    private java.lang.String d_station_name;

    public Journey_destination_station_list() {
    }

    public Journey_destination_station_list(
           int d_station_id,
           java.lang.String d_station_name) {
           this.d_station_id = d_station_id;
           this.d_station_name = d_station_name;
    }


    /**
     * Gets the d_station_id value for this Journey_destination_station_list.
     * 
     * @return d_station_id
     */
    public int getD_station_id() {
        return d_station_id;
    }


    /**
     * Sets the d_station_id value for this Journey_destination_station_list.
     * 
     * @param d_station_id
     */
    public void setD_station_id(int d_station_id) {
        this.d_station_id = d_station_id;
    }


    /**
     * Gets the d_station_name value for this Journey_destination_station_list.
     * 
     * @return d_station_name
     */
    public java.lang.String getD_station_name() {
        return d_station_name;
    }


    /**
     * Sets the d_station_name value for this Journey_destination_station_list.
     * 
     * @param d_station_name
     */
    public void setD_station_name(java.lang.String d_station_name) {
        this.d_station_name = d_station_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Journey_destination_station_list)) return false;
        Journey_destination_station_list other = (Journey_destination_station_list) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.d_station_id == other.getD_station_id() &&
            ((this.d_station_name==null && other.getD_station_name()==null) || 
             (this.d_station_name!=null &&
              this.d_station_name.equals(other.getD_station_name())));
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
        _hashCode += getD_station_id();
        if (getD_station_name() != null) {
            _hashCode += getD_station_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Journey_destination_station_list.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_destination_station_list"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_station_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "d_station_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_station_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "d_station_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
