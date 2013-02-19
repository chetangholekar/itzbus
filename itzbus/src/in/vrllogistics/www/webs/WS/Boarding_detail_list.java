/**
 * Boarding_detail_list.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Boarding_detail_list  implements java.io.Serializable {
    private int no_of_boarding_points;

    private int response_code;

    private in.vrllogistics.www.webs.WS.Boarding_detail[] boarding_detail;

    public Boarding_detail_list() {
    }

    public Boarding_detail_list(
           int no_of_boarding_points,
           int response_code,
           in.vrllogistics.www.webs.WS.Boarding_detail[] boarding_detail) {
           this.no_of_boarding_points = no_of_boarding_points;
           this.response_code = response_code;
           this.boarding_detail = boarding_detail;
    }


    /**
     * Gets the no_of_boarding_points value for this Boarding_detail_list.
     * 
     * @return no_of_boarding_points
     */
    public int getNo_of_boarding_points() {
        return no_of_boarding_points;
    }


    /**
     * Sets the no_of_boarding_points value for this Boarding_detail_list.
     * 
     * @param no_of_boarding_points
     */
    public void setNo_of_boarding_points(int no_of_boarding_points) {
        this.no_of_boarding_points = no_of_boarding_points;
    }


    /**
     * Gets the response_code value for this Boarding_detail_list.
     * 
     * @return response_code
     */
    public int getResponse_code() {
        return response_code;
    }


    /**
     * Sets the response_code value for this Boarding_detail_list.
     * 
     * @param response_code
     */
    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }


    /**
     * Gets the boarding_detail value for this Boarding_detail_list.
     * 
     * @return boarding_detail
     */
    public in.vrllogistics.www.webs.WS.Boarding_detail[] getBoarding_detail() {
        return boarding_detail;
    }


    /**
     * Sets the boarding_detail value for this Boarding_detail_list.
     * 
     * @param boarding_detail
     */
    public void setBoarding_detail(in.vrllogistics.www.webs.WS.Boarding_detail[] boarding_detail) {
        this.boarding_detail = boarding_detail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Boarding_detail_list)) return false;
        Boarding_detail_list other = (Boarding_detail_list) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.no_of_boarding_points == other.getNo_of_boarding_points() &&
            this.response_code == other.getResponse_code() &&
            ((this.boarding_detail==null && other.getBoarding_detail()==null) || 
             (this.boarding_detail!=null &&
              java.util.Arrays.equals(this.boarding_detail, other.getBoarding_detail())));
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
        _hashCode += getNo_of_boarding_points();
        _hashCode += getResponse_code();
        if (getBoarding_detail() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBoarding_detail());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBoarding_detail(), i);
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
        new org.apache.axis.description.TypeDesc(Boarding_detail_list.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_detail_list"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_of_boarding_points");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "No_of_boarding_points"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "response_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boarding_detail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_detail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_detail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_detail"));
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
