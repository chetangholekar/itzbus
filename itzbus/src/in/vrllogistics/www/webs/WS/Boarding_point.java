/**
 * Boarding_point.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Boarding_point  implements java.io.Serializable {
    private int boarding_point_id;

    private java.lang.String boarding_point_name;

    private java.lang.String boarding_point_time;

    public Boarding_point() {
    }

    public Boarding_point(
           int boarding_point_id,
           java.lang.String boarding_point_name,
           java.lang.String boarding_point_time) {
           this.boarding_point_id = boarding_point_id;
           this.boarding_point_name = boarding_point_name;
           this.boarding_point_time = boarding_point_time;
    }


    /**
     * Gets the boarding_point_id value for this Boarding_point.
     * 
     * @return boarding_point_id
     */
    public int getBoarding_point_id() {
        return boarding_point_id;
    }


    /**
     * Sets the boarding_point_id value for this Boarding_point.
     * 
     * @param boarding_point_id
     */
    public void setBoarding_point_id(int boarding_point_id) {
        this.boarding_point_id = boarding_point_id;
    }


    /**
     * Gets the boarding_point_name value for this Boarding_point.
     * 
     * @return boarding_point_name
     */
    public java.lang.String getBoarding_point_name() {
        return boarding_point_name;
    }


    /**
     * Sets the boarding_point_name value for this Boarding_point.
     * 
     * @param boarding_point_name
     */
    public void setBoarding_point_name(java.lang.String boarding_point_name) {
        this.boarding_point_name = boarding_point_name;
    }


    /**
     * Gets the boarding_point_time value for this Boarding_point.
     * 
     * @return boarding_point_time
     */
    public java.lang.String getBoarding_point_time() {
        return boarding_point_time;
    }


    /**
     * Sets the boarding_point_time value for this Boarding_point.
     * 
     * @param boarding_point_time
     */
    public void setBoarding_point_time(java.lang.String boarding_point_time) {
        this.boarding_point_time = boarding_point_time;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Boarding_point)) return false;
        Boarding_point other = (Boarding_point) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.boarding_point_id == other.getBoarding_point_id() &&
            ((this.boarding_point_name==null && other.getBoarding_point_name()==null) || 
             (this.boarding_point_name!=null &&
              this.boarding_point_name.equals(other.getBoarding_point_name()))) &&
            ((this.boarding_point_time==null && other.getBoarding_point_time()==null) || 
             (this.boarding_point_time!=null &&
              this.boarding_point_time.equals(other.getBoarding_point_time())));
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
        _hashCode += getBoarding_point_id();
        if (getBoarding_point_name() != null) {
            _hashCode += getBoarding_point_name().hashCode();
        }
        if (getBoarding_point_time() != null) {
            _hashCode += getBoarding_point_time().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Boarding_point.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Boarding_point"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boarding_point_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Boarding_point_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boarding_point_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Boarding_point_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boarding_point_time");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Boarding_point_time"));
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
