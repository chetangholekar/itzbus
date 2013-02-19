/**
 * Jounrney_source_destinationlist.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class Jounrney_source_destinationlist  implements java.io.Serializable {
    private in.vrllogistics.www.webs.WS.Journey_source_station_list[] j_source_list;

    public Jounrney_source_destinationlist() {
    }

    public Jounrney_source_destinationlist(
           in.vrllogistics.www.webs.WS.Journey_source_station_list[] j_source_list) {
           this.j_source_list = j_source_list;
    }


    /**
     * Gets the j_source_list value for this Jounrney_source_destinationlist.
     * 
     * @return j_source_list
     */
    public in.vrllogistics.www.webs.WS.Journey_source_station_list[] getJ_source_list() {
        return j_source_list;
    }


    /**
     * Sets the j_source_list value for this Jounrney_source_destinationlist.
     * 
     * @param j_source_list
     */
    public void setJ_source_list(in.vrllogistics.www.webs.WS.Journey_source_station_list[] j_source_list) {
        this.j_source_list = j_source_list;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jounrney_source_destinationlist)) return false;
        Jounrney_source_destinationlist other = (Jounrney_source_destinationlist) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.j_source_list==null && other.getJ_source_list()==null) || 
             (this.j_source_list!=null &&
              java.util.Arrays.equals(this.j_source_list, other.getJ_source_list())));
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
        if (getJ_source_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getJ_source_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getJ_source_list(), i);
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
        new org.apache.axis.description.TypeDesc(Jounrney_source_destinationlist.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "jounrney_source_destinationlist"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("j_source_list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "j_source_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_source_station_list"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_source_station_list"));
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
