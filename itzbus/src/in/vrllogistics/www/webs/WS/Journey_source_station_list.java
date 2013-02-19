/**
 * Journey_source_station_list.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Journey_source_station_list  implements java.io.Serializable {
    private int s_station_id;

    private java.lang.String s_station_name;

    private in.vrllogistics.www.webs.WS.Journey_destination_station_list[] j_destination_list;

    public Journey_source_station_list() {
    }

    public Journey_source_station_list(
           int s_station_id,
           java.lang.String s_station_name,
           in.vrllogistics.www.webs.WS.Journey_destination_station_list[] j_destination_list) {
           this.s_station_id = s_station_id;
           this.s_station_name = s_station_name;
           this.j_destination_list = j_destination_list;
    }


    /**
     * Gets the s_station_id value for this Journey_source_station_list.
     * 
     * @return s_station_id
     */
    public int getS_station_id() {
        return s_station_id;
    }


    /**
     * Sets the s_station_id value for this Journey_source_station_list.
     * 
     * @param s_station_id
     */
    public void setS_station_id(int s_station_id) {
        this.s_station_id = s_station_id;
    }


    /**
     * Gets the s_station_name value for this Journey_source_station_list.
     * 
     * @return s_station_name
     */
    public java.lang.String getS_station_name() {
        return s_station_name;
    }


    /**
     * Sets the s_station_name value for this Journey_source_station_list.
     * 
     * @param s_station_name
     */
    public void setS_station_name(java.lang.String s_station_name) {
        this.s_station_name = s_station_name;
    }


    /**
     * Gets the j_destination_list value for this Journey_source_station_list.
     * 
     * @return j_destination_list
     */
    public in.vrllogistics.www.webs.WS.Journey_destination_station_list[] getJ_destination_list() {
        return j_destination_list;
    }


    /**
     * Sets the j_destination_list value for this Journey_source_station_list.
     * 
     * @param j_destination_list
     */
    public void setJ_destination_list(in.vrllogistics.www.webs.WS.Journey_destination_station_list[] j_destination_list) {
        this.j_destination_list = j_destination_list;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Journey_source_station_list)) return false;
        Journey_source_station_list other = (Journey_source_station_list) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.s_station_id == other.getS_station_id() &&
            ((this.s_station_name==null && other.getS_station_name()==null) || 
             (this.s_station_name!=null &&
              this.s_station_name.equals(other.getS_station_name()))) &&
            ((this.j_destination_list==null && other.getJ_destination_list()==null) || 
             (this.j_destination_list!=null &&
              java.util.Arrays.equals(this.j_destination_list, other.getJ_destination_list())));
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
        _hashCode += getS_station_id();
        if (getS_station_name() != null) {
            _hashCode += getS_station_name().hashCode();
        }
        if (getJ_destination_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getJ_destination_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getJ_destination_list(), i);
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
        new org.apache.axis.description.TypeDesc(Journey_source_station_list.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_source_station_list"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_station_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "s_station_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("s_station_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "s_station_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("j_destination_list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "j_destination_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_destination_station_list"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_destination_station_list"));
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
