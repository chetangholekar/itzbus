/**
 * Journey.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Journey  implements java.io.Serializable {
    private int journey_id;

    private int bus_id;

    private java.lang.String bus_type;

    private int no_of_seats_available;

    private java.lang.String route_note;

    private int no_of_boarding_points;

    private in.vrllogistics.www.webs.WS.Boarding_point[] boarding_points;

    private int journey_min;

    private in.vrllogistics.www.webs.WS.Seat_detail seat_details;

    public Journey() {
    }

    public Journey(
           int journey_id,
           int bus_id,
           java.lang.String bus_type,
           int no_of_seats_available,
           java.lang.String route_note,
           int no_of_boarding_points,
           in.vrllogistics.www.webs.WS.Boarding_point[] boarding_points,
           int journey_min,
           in.vrllogistics.www.webs.WS.Seat_detail seat_details) {
           this.journey_id = journey_id;
           this.bus_id = bus_id;
           this.bus_type = bus_type;
           this.no_of_seats_available = no_of_seats_available;
           this.route_note = route_note;
           this.no_of_boarding_points = no_of_boarding_points;
           this.boarding_points = boarding_points;
           this.journey_min = journey_min;
           this.seat_details = seat_details;
    }


    /**
     * Gets the journey_id value for this Journey.
     * 
     * @return journey_id
     */
    public int getJourney_id() {
        return journey_id;
    }


    /**
     * Sets the journey_id value for this Journey.
     * 
     * @param journey_id
     */
    public void setJourney_id(int journey_id) {
        this.journey_id = journey_id;
    }


    /**
     * Gets the bus_id value for this Journey.
     * 
     * @return bus_id
     */
    public int getBus_id() {
        return bus_id;
    }


    /**
     * Sets the bus_id value for this Journey.
     * 
     * @param bus_id
     */
    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }


    /**
     * Gets the bus_type value for this Journey.
     * 
     * @return bus_type
     */
    public java.lang.String getBus_type() {
        return bus_type;
    }


    /**
     * Sets the bus_type value for this Journey.
     * 
     * @param bus_type
     */
    public void setBus_type(java.lang.String bus_type) {
        this.bus_type = bus_type;
    }


    /**
     * Gets the no_of_seats_available value for this Journey.
     * 
     * @return no_of_seats_available
     */
    public int getNo_of_seats_available() {
        return no_of_seats_available;
    }


    /**
     * Sets the no_of_seats_available value for this Journey.
     * 
     * @param no_of_seats_available
     */
    public void setNo_of_seats_available(int no_of_seats_available) {
        this.no_of_seats_available = no_of_seats_available;
    }


    /**
     * Gets the route_note value for this Journey.
     * 
     * @return route_note
     */
    public java.lang.String getRoute_note() {
        return route_note;
    }


    /**
     * Sets the route_note value for this Journey.
     * 
     * @param route_note
     */
    public void setRoute_note(java.lang.String route_note) {
        this.route_note = route_note;
    }


    /**
     * Gets the no_of_boarding_points value for this Journey.
     * 
     * @return no_of_boarding_points
     */
    public int getNo_of_boarding_points() {
        return no_of_boarding_points;
    }


    /**
     * Sets the no_of_boarding_points value for this Journey.
     * 
     * @param no_of_boarding_points
     */
    public void setNo_of_boarding_points(int no_of_boarding_points) {
        this.no_of_boarding_points = no_of_boarding_points;
    }


    /**
     * Gets the boarding_points value for this Journey.
     * 
     * @return boarding_points
     */
    public in.vrllogistics.www.webs.WS.Boarding_point[] getBoarding_points() {
        return boarding_points;
    }


    /**
     * Sets the boarding_points value for this Journey.
     * 
     * @param boarding_points
     */
    public void setBoarding_points(in.vrllogistics.www.webs.WS.Boarding_point[] boarding_points) {
        this.boarding_points = boarding_points;
    }


    /**
     * Gets the journey_min value for this Journey.
     * 
     * @return journey_min
     */
    public int getJourney_min() {
        return journey_min;
    }


    /**
     * Sets the journey_min value for this Journey.
     * 
     * @param journey_min
     */
    public void setJourney_min(int journey_min) {
        this.journey_min = journey_min;
    }


    /**
     * Gets the seat_details value for this Journey.
     * 
     * @return seat_details
     */
    public in.vrllogistics.www.webs.WS.Seat_detail getSeat_details() {
        return seat_details;
    }


    /**
     * Sets the seat_details value for this Journey.
     * 
     * @param seat_details
     */
    public void setSeat_details(in.vrllogistics.www.webs.WS.Seat_detail seat_details) {
        this.seat_details = seat_details;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Journey)) return false;
        Journey other = (Journey) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.journey_id == other.getJourney_id() &&
            this.bus_id == other.getBus_id() &&
            ((this.bus_type==null && other.getBus_type()==null) || 
             (this.bus_type!=null &&
              this.bus_type.equals(other.getBus_type()))) &&
            this.no_of_seats_available == other.getNo_of_seats_available() &&
            ((this.route_note==null && other.getRoute_note()==null) || 
             (this.route_note!=null &&
              this.route_note.equals(other.getRoute_note()))) &&
            this.no_of_boarding_points == other.getNo_of_boarding_points() &&
            ((this.boarding_points==null && other.getBoarding_points()==null) || 
             (this.boarding_points!=null &&
              java.util.Arrays.equals(this.boarding_points, other.getBoarding_points()))) &&
            this.journey_min == other.getJourney_min() &&
            ((this.seat_details==null && other.getSeat_details()==null) || 
             (this.seat_details!=null &&
              this.seat_details.equals(other.getSeat_details())));
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
        _hashCode += getJourney_id();
        _hashCode += getBus_id();
        if (getBus_type() != null) {
            _hashCode += getBus_type().hashCode();
        }
        _hashCode += getNo_of_seats_available();
        if (getRoute_note() != null) {
            _hashCode += getRoute_note().hashCode();
        }
        _hashCode += getNo_of_boarding_points();
        if (getBoarding_points() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBoarding_points());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBoarding_points(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getJourney_min();
        if (getSeat_details() != null) {
            _hashCode += getSeat_details().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Journey.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("journey_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Journey_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bus_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Bus_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bus_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Bus_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_of_seats_available");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "No_of_seats_available"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("route_note");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Route_note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_of_boarding_points");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "No_of_boarding_points"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boarding_points");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Boarding_points"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Boarding_point"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Boarding_point"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("journey_min");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Journey_min"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seat_details");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Seat_details"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Seat_detail"));
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
