/**
 * Temp_booking.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Temp_booking  implements java.io.Serializable {
    private int response_code;

    private java.lang.String pnr_no;

    private double grand_total;

    private double staxp;

    private double staxvc1;

    public Temp_booking() {
    }

    public Temp_booking(
           int response_code,
           java.lang.String pnr_no,
           double grand_total,
           double staxp,
           double staxvc1) {
           this.response_code = response_code;
           this.pnr_no = pnr_no;
           this.grand_total = grand_total;
           this.staxp = staxp;
           this.staxvc1 = staxvc1;
    }


    /**
     * Gets the response_code value for this Temp_booking.
     * 
     * @return response_code
     */
    public int getResponse_code() {
        return response_code;
    }


    /**
     * Sets the response_code value for this Temp_booking.
     * 
     * @param response_code
     */
    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }


    /**
     * Gets the pnr_no value for this Temp_booking.
     * 
     * @return pnr_no
     */
    public java.lang.String getPnr_no() {
        return pnr_no;
    }


    /**
     * Sets the pnr_no value for this Temp_booking.
     * 
     * @param pnr_no
     */
    public void setPnr_no(java.lang.String pnr_no) {
        this.pnr_no = pnr_no;
    }


    /**
     * Gets the grand_total value for this Temp_booking.
     * 
     * @return grand_total
     */
    public double getGrand_total() {
        return grand_total;
    }


    /**
     * Sets the grand_total value for this Temp_booking.
     * 
     * @param grand_total
     */
    public void setGrand_total(double grand_total) {
        this.grand_total = grand_total;
    }


    /**
     * Gets the staxp value for this Temp_booking.
     * 
     * @return staxp
     */
    public double getStaxp() {
        return staxp;
    }


    /**
     * Sets the staxp value for this Temp_booking.
     * 
     * @param staxp
     */
    public void setStaxp(double staxp) {
        this.staxp = staxp;
    }


    /**
     * Gets the staxvc1 value for this Temp_booking.
     * 
     * @return staxvc1
     */
    public double getStaxvc1() {
        return staxvc1;
    }


    /**
     * Sets the staxvc1 value for this Temp_booking.
     * 
     * @param staxvc1
     */
    public void setStaxvc1(double staxvc1) {
        this.staxvc1 = staxvc1;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Temp_booking)) return false;
        Temp_booking other = (Temp_booking) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.response_code == other.getResponse_code() &&
            ((this.pnr_no==null && other.getPnr_no()==null) || 
             (this.pnr_no!=null &&
              this.pnr_no.equals(other.getPnr_no()))) &&
            this.grand_total == other.getGrand_total() &&
            this.staxp == other.getStaxp() &&
            this.staxvc1 == other.getStaxvc1();
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
        if (getPnr_no() != null) {
            _hashCode += getPnr_no().hashCode();
        }
        _hashCode += new Double(getGrand_total()).hashCode();
        _hashCode += new Double(getStaxp()).hashCode();
        _hashCode += new Double(getStaxvc1()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Temp_booking.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "temp_booking"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "response_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pnr_no");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "pnr_no"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grand_total");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "grand_total"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("staxp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "staxp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("staxvc1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "staxvc1"));
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
