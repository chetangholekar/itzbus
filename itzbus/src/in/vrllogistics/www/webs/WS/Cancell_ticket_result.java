/**
 * Cancell_ticket_result.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Cancell_ticket_result  implements java.io.Serializable {
    private int response_code;

    private int cnr_no;

    private double refund_amount;

    public Cancell_ticket_result() {
    }

    public Cancell_ticket_result(
           int response_code,
           int cnr_no,
           double refund_amount) {
           this.response_code = response_code;
           this.cnr_no = cnr_no;
           this.refund_amount = refund_amount;
    }


    /**
     * Gets the response_code value for this Cancell_ticket_result.
     * 
     * @return response_code
     */
    public int getResponse_code() {
        return response_code;
    }


    /**
     * Sets the response_code value for this Cancell_ticket_result.
     * 
     * @param response_code
     */
    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }


    /**
     * Gets the cnr_no value for this Cancell_ticket_result.
     * 
     * @return cnr_no
     */
    public int getCnr_no() {
        return cnr_no;
    }


    /**
     * Sets the cnr_no value for this Cancell_ticket_result.
     * 
     * @param cnr_no
     */
    public void setCnr_no(int cnr_no) {
        this.cnr_no = cnr_no;
    }


    /**
     * Gets the refund_amount value for this Cancell_ticket_result.
     * 
     * @return refund_amount
     */
    public double getRefund_amount() {
        return refund_amount;
    }


    /**
     * Sets the refund_amount value for this Cancell_ticket_result.
     * 
     * @param refund_amount
     */
    public void setRefund_amount(double refund_amount) {
        this.refund_amount = refund_amount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Cancell_ticket_result)) return false;
        Cancell_ticket_result other = (Cancell_ticket_result) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.response_code == other.getResponse_code() &&
            this.cnr_no == other.getCnr_no() &&
            this.refund_amount == other.getRefund_amount();
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
        _hashCode += getCnr_no();
        _hashCode += new Double(getRefund_amount()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Cancell_ticket_result.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Cancell_ticket_result"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "response_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cnr_no");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "cnr_no"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refund_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Refund_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
