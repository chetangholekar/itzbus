/**
 * Seat_detail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Seat_detail  implements java.io.Serializable {
    private java.lang.String seat_Names;

    private java.lang.String seat_indexs;

    private java.lang.String seat_availablity;

    private java.lang.String seat_fares;

    private java.lang.String seat_sexes;

    private double seat_staxp1;

    private double seat_staxvc1;

    public Seat_detail() {
    }

    public Seat_detail(
           java.lang.String seat_Names,
           java.lang.String seat_indexs,
           java.lang.String seat_availablity,
           java.lang.String seat_fares,
           java.lang.String seat_sexes,
           double seat_staxp1,
           double seat_staxvc1) {
           this.seat_Names = seat_Names;
           this.seat_indexs = seat_indexs;
           this.seat_availablity = seat_availablity;
           this.seat_fares = seat_fares;
           this.seat_sexes = seat_sexes;
           this.seat_staxp1 = seat_staxp1;
           this.seat_staxvc1 = seat_staxvc1;
    }


    /**
     * Gets the seat_Names value for this Seat_detail.
     * 
     * @return seat_Names
     */
    public java.lang.String getSeat_Names() {
        return seat_Names;
    }


    /**
     * Sets the seat_Names value for this Seat_detail.
     * 
     * @param seat_Names
     */
    public void setSeat_Names(java.lang.String seat_Names) {
        this.seat_Names = seat_Names;
    }


    /**
     * Gets the seat_indexs value for this Seat_detail.
     * 
     * @return seat_indexs
     */
    public java.lang.String getSeat_indexs() {
        return seat_indexs;
    }


    /**
     * Sets the seat_indexs value for this Seat_detail.
     * 
     * @param seat_indexs
     */
    public void setSeat_indexs(java.lang.String seat_indexs) {
        this.seat_indexs = seat_indexs;
    }


    /**
     * Gets the seat_availablity value for this Seat_detail.
     * 
     * @return seat_availablity
     */
    public java.lang.String getSeat_availablity() {
        return seat_availablity;
    }


    /**
     * Sets the seat_availablity value for this Seat_detail.
     * 
     * @param seat_availablity
     */
    public void setSeat_availablity(java.lang.String seat_availablity) {
        this.seat_availablity = seat_availablity;
    }


    /**
     * Gets the seat_fares value for this Seat_detail.
     * 
     * @return seat_fares
     */
    public java.lang.String getSeat_fares() {
        return seat_fares;
    }


    /**
     * Sets the seat_fares value for this Seat_detail.
     * 
     * @param seat_fares
     */
    public void setSeat_fares(java.lang.String seat_fares) {
        this.seat_fares = seat_fares;
    }


    /**
     * Gets the seat_sexes value for this Seat_detail.
     * 
     * @return seat_sexes
     */
    public java.lang.String getSeat_sexes() {
        return seat_sexes;
    }


    /**
     * Sets the seat_sexes value for this Seat_detail.
     * 
     * @param seat_sexes
     */
    public void setSeat_sexes(java.lang.String seat_sexes) {
        this.seat_sexes = seat_sexes;
    }


    /**
     * Gets the seat_staxp1 value for this Seat_detail.
     * 
     * @return seat_staxp1
     */
    public double getSeat_staxp1() {
        return seat_staxp1;
    }


    /**
     * Sets the seat_staxp1 value for this Seat_detail.
     * 
     * @param seat_staxp1
     */
    public void setSeat_staxp1(double seat_staxp1) {
        this.seat_staxp1 = seat_staxp1;
    }


    /**
     * Gets the seat_staxvc1 value for this Seat_detail.
     * 
     * @return seat_staxvc1
     */
    public double getSeat_staxvc1() {
        return seat_staxvc1;
    }


    /**
     * Sets the seat_staxvc1 value for this Seat_detail.
     * 
     * @param seat_staxvc1
     */
    public void setSeat_staxvc1(double seat_staxvc1) {
        this.seat_staxvc1 = seat_staxvc1;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Seat_detail)) return false;
        Seat_detail other = (Seat_detail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.seat_Names==null && other.getSeat_Names()==null) || 
             (this.seat_Names!=null &&
              this.seat_Names.equals(other.getSeat_Names()))) &&
            ((this.seat_indexs==null && other.getSeat_indexs()==null) || 
             (this.seat_indexs!=null &&
              this.seat_indexs.equals(other.getSeat_indexs()))) &&
            ((this.seat_availablity==null && other.getSeat_availablity()==null) || 
             (this.seat_availablity!=null &&
              this.seat_availablity.equals(other.getSeat_availablity()))) &&
            ((this.seat_fares==null && other.getSeat_fares()==null) || 
             (this.seat_fares!=null &&
              this.seat_fares.equals(other.getSeat_fares()))) &&
            ((this.seat_sexes==null && other.getSeat_sexes()==null) || 
             (this.seat_sexes!=null &&
              this.seat_sexes.equals(other.getSeat_sexes()))) &&
            this.seat_staxp1 == other.getSeat_staxp1() &&
            this.seat_staxvc1 == other.getSeat_staxvc1();
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
        if (getSeat_Names() != null) {
            _hashCode += getSeat_Names().hashCode();
        }
        if (getSeat_indexs() != null) {
            _hashCode += getSeat_indexs().hashCode();
        }
        if (getSeat_availablity() != null) {
            _hashCode += getSeat_availablity().hashCode();
        }
        if (getSeat_fares() != null) {
            _hashCode += getSeat_fares().hashCode();
        }
        if (getSeat_sexes() != null) {
            _hashCode += getSeat_sexes().hashCode();
        }
        _hashCode += new Double(getSeat_staxp1()).hashCode();
        _hashCode += new Double(getSeat_staxvc1()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Seat_detail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Seat_detail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seat_Names");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Seat_Names"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seat_indexs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Seat_indexs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seat_availablity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Seat_availablity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seat_fares");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Seat_fares"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seat_sexes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Seat_sexes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seat_staxp1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "seat_staxp1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seat_staxvc1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "seat_staxvc1"));
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
