/**
 * Confirm_booking.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Confirm_booking  implements java.io.Serializable {
    private int response_code;

    private java.lang.String pnr_no;

    private int is_split_journey;

    private int is_split_first;

    private int is_split_second;

    private int split_station_id;

    private java.lang.String split_station;

    private java.lang.String split_station_time;

    private int split_serial_no;

    private int source_serial_no;

    private int destination_serial_no;

    public Confirm_booking() {
    }

    public Confirm_booking(
           int response_code,
           java.lang.String pnr_no,
           int is_split_journey,
           int is_split_first,
           int is_split_second,
           int split_station_id,
           java.lang.String split_station,
           java.lang.String split_station_time,
           int split_serial_no,
           int source_serial_no,
           int destination_serial_no) {
           this.response_code = response_code;
           this.pnr_no = pnr_no;
           this.is_split_journey = is_split_journey;
           this.is_split_first = is_split_first;
           this.is_split_second = is_split_second;
           this.split_station_id = split_station_id;
           this.split_station = split_station;
           this.split_station_time = split_station_time;
           this.split_serial_no = split_serial_no;
           this.source_serial_no = source_serial_no;
           this.destination_serial_no = destination_serial_no;
    }


    /**
     * Gets the response_code value for this Confirm_booking.
     * 
     * @return response_code
     */
    public int getResponse_code() {
        return response_code;
    }


    /**
     * Sets the response_code value for this Confirm_booking.
     * 
     * @param response_code
     */
    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }


    /**
     * Gets the pnr_no value for this Confirm_booking.
     * 
     * @return pnr_no
     */
    public java.lang.String getPnr_no() {
        return pnr_no;
    }


    /**
     * Sets the pnr_no value for this Confirm_booking.
     * 
     * @param pnr_no
     */
    public void setPnr_no(java.lang.String pnr_no) {
        this.pnr_no = pnr_no;
    }


    /**
     * Gets the is_split_journey value for this Confirm_booking.
     * 
     * @return is_split_journey
     */
    public int getIs_split_journey() {
        return is_split_journey;
    }


    /**
     * Sets the is_split_journey value for this Confirm_booking.
     * 
     * @param is_split_journey
     */
    public void setIs_split_journey(int is_split_journey) {
        this.is_split_journey = is_split_journey;
    }


    /**
     * Gets the is_split_first value for this Confirm_booking.
     * 
     * @return is_split_first
     */
    public int getIs_split_first() {
        return is_split_first;
    }


    /**
     * Sets the is_split_first value for this Confirm_booking.
     * 
     * @param is_split_first
     */
    public void setIs_split_first(int is_split_first) {
        this.is_split_first = is_split_first;
    }


    /**
     * Gets the is_split_second value for this Confirm_booking.
     * 
     * @return is_split_second
     */
    public int getIs_split_second() {
        return is_split_second;
    }


    /**
     * Sets the is_split_second value for this Confirm_booking.
     * 
     * @param is_split_second
     */
    public void setIs_split_second(int is_split_second) {
        this.is_split_second = is_split_second;
    }


    /**
     * Gets the split_station_id value for this Confirm_booking.
     * 
     * @return split_station_id
     */
    public int getSplit_station_id() {
        return split_station_id;
    }


    /**
     * Sets the split_station_id value for this Confirm_booking.
     * 
     * @param split_station_id
     */
    public void setSplit_station_id(int split_station_id) {
        this.split_station_id = split_station_id;
    }


    /**
     * Gets the split_station value for this Confirm_booking.
     * 
     * @return split_station
     */
    public java.lang.String getSplit_station() {
        return split_station;
    }


    /**
     * Sets the split_station value for this Confirm_booking.
     * 
     * @param split_station
     */
    public void setSplit_station(java.lang.String split_station) {
        this.split_station = split_station;
    }


    /**
     * Gets the split_station_time value for this Confirm_booking.
     * 
     * @return split_station_time
     */
    public java.lang.String getSplit_station_time() {
        return split_station_time;
    }


    /**
     * Sets the split_station_time value for this Confirm_booking.
     * 
     * @param split_station_time
     */
    public void setSplit_station_time(java.lang.String split_station_time) {
        this.split_station_time = split_station_time;
    }


    /**
     * Gets the split_serial_no value for this Confirm_booking.
     * 
     * @return split_serial_no
     */
    public int getSplit_serial_no() {
        return split_serial_no;
    }


    /**
     * Sets the split_serial_no value for this Confirm_booking.
     * 
     * @param split_serial_no
     */
    public void setSplit_serial_no(int split_serial_no) {
        this.split_serial_no = split_serial_no;
    }


    /**
     * Gets the source_serial_no value for this Confirm_booking.
     * 
     * @return source_serial_no
     */
    public int getSource_serial_no() {
        return source_serial_no;
    }


    /**
     * Sets the source_serial_no value for this Confirm_booking.
     * 
     * @param source_serial_no
     */
    public void setSource_serial_no(int source_serial_no) {
        this.source_serial_no = source_serial_no;
    }


    /**
     * Gets the destination_serial_no value for this Confirm_booking.
     * 
     * @return destination_serial_no
     */
    public int getDestination_serial_no() {
        return destination_serial_no;
    }


    /**
     * Sets the destination_serial_no value for this Confirm_booking.
     * 
     * @param destination_serial_no
     */
    public void setDestination_serial_no(int destination_serial_no) {
        this.destination_serial_no = destination_serial_no;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Confirm_booking)) return false;
        Confirm_booking other = (Confirm_booking) obj;
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
            this.is_split_journey == other.getIs_split_journey() &&
            this.is_split_first == other.getIs_split_first() &&
            this.is_split_second == other.getIs_split_second() &&
            this.split_station_id == other.getSplit_station_id() &&
            ((this.split_station==null && other.getSplit_station()==null) || 
             (this.split_station!=null &&
              this.split_station.equals(other.getSplit_station()))) &&
            ((this.split_station_time==null && other.getSplit_station_time()==null) || 
             (this.split_station_time!=null &&
              this.split_station_time.equals(other.getSplit_station_time()))) &&
            this.split_serial_no == other.getSplit_serial_no() &&
            this.source_serial_no == other.getSource_serial_no() &&
            this.destination_serial_no == other.getDestination_serial_no();
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
        _hashCode += getIs_split_journey();
        _hashCode += getIs_split_first();
        _hashCode += getIs_split_second();
        _hashCode += getSplit_station_id();
        if (getSplit_station() != null) {
            _hashCode += getSplit_station().hashCode();
        }
        if (getSplit_station_time() != null) {
            _hashCode += getSplit_station_time().hashCode();
        }
        _hashCode += getSplit_serial_no();
        _hashCode += getSource_serial_no();
        _hashCode += getDestination_serial_no();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Confirm_booking.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "confirm_booking"));
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
        elemField.setFieldName("is_split_journey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "is_split_journey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_split_first");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "is_split_first"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_split_second");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "is_split_second"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("split_station_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "split_station_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("split_station");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "split_station"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("split_station_time");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "split_station_time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("split_serial_no");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "split_serial_no"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source_serial_no");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "source_serial_no"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destination_serial_no");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "destination_serial_no"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
