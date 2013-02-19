/**
 * Journey_list.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Journey_list  implements java.io.Serializable {
    private int response_code;

    private int no_of_journies;

    private in.vrllogistics.www.webs.WS.Journey[] journies;

    public Journey_list() {
    }

    public Journey_list(
           int response_code,
           int no_of_journies,
           in.vrllogistics.www.webs.WS.Journey[] journies) {
           this.response_code = response_code;
           this.no_of_journies = no_of_journies;
           this.journies = journies;
    }


    /**
     * Gets the response_code value for this Journey_list.
     * 
     * @return response_code
     */
    public int getResponse_code() {
        return response_code;
    }


    /**
     * Sets the response_code value for this Journey_list.
     * 
     * @param response_code
     */
    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }


    /**
     * Gets the no_of_journies value for this Journey_list.
     * 
     * @return no_of_journies
     */
    public int getNo_of_journies() {
        return no_of_journies;
    }


    /**
     * Sets the no_of_journies value for this Journey_list.
     * 
     * @param no_of_journies
     */
    public void setNo_of_journies(int no_of_journies) {
        this.no_of_journies = no_of_journies;
    }


    /**
     * Gets the journies value for this Journey_list.
     * 
     * @return journies
     */
    public in.vrllogistics.www.webs.WS.Journey[] getJournies() {
        return journies;
    }


    /**
     * Sets the journies value for this Journey_list.
     * 
     * @param journies
     */
    public void setJournies(in.vrllogistics.www.webs.WS.Journey[] journies) {
        this.journies = journies;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Journey_list)) return false;
        Journey_list other = (Journey_list) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.response_code == other.getResponse_code() &&
            this.no_of_journies == other.getNo_of_journies() &&
            ((this.journies==null && other.getJournies()==null) || 
             (this.journies!=null &&
              java.util.Arrays.equals(this.journies, other.getJournies())));
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
        _hashCode += getNo_of_journies();
        if (getJournies() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getJournies());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getJournies(), i);
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
        new org.apache.axis.description.TypeDesc(Journey_list.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Journey_list"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "response_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_of_journies");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "No_of_journies"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("journies");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Journies"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey"));
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
