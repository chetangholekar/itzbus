/**
 * VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public class VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapStub extends org.apache.axis.client.Stub implements in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[10];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetStations");
        oper.setReturnType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "stations_list"));
        oper.setReturnClass(in.vrllogistics.www.webs.WS.Stations_list.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "GetStationsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSourceDestination");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "source_station_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_date"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "jounrney_source_destinationlist"));
        oper.setReturnClass(in.vrllogistics.www.webs.WS.Jounrney_source_destinationlist.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "GetSourceDestinationResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDestinationStation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "source_station_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_date"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Destination_list"));
        oper.setReturnClass(in.vrllogistics.www.webs.WS.Destination_list.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "GetDestinationStationResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAvailableJournies");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "user_source_station_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "user_destination_station_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_date"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Journey_list"));
        oper.setReturnClass(in.vrllogistics.www.webs.WS.Journey_list.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "GetAvailableJourniesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetJourneyDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "user_source_station_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "user_destination_station_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Journey_list"));
        oper.setReturnClass(in.vrllogistics.www.webs.WS.Journey_list.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "GetJourneyDetailsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DotempBooking");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "user_source_station_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "user_destination_station_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "seat_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "person_name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "person_phone"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "sex"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "temp_booking"));
        oper.setReturnClass(in.vrllogistics.www.webs.WS.Temp_booking.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "DotempBookingResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConfirmBooking");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "temp_pnr_no"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "confirm_booking"));
        oper.setReturnClass(in.vrllogistics.www.webs.WS.Confirm_booking.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "ConfirmBookingResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("IsTicketCancellable");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "pnr_no"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Cancellable_status"));
        oper.setReturnClass(in.vrllogistics.www.webs.WS.Cancellable_status.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "API_x0020_Gives_x0020_the_x0020_Cancel_x0020_StatusResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CancellTicket");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "pnr_no"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Cancell_ticket_result"));
        oper.setReturnClass(in.vrllogistics.www.webs.WS.Cancell_ticket_result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "API_x0020_Cancel_x0020_BookingResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetBoardingdetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_detail_list"));
        oper.setReturnClass(in.vrllogistics.www.webs.WS.Boarding_detail_list.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "API_x0020_Gives_x0020_Boarding_x0020_DetailsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    public VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "ArrayOfBoarding_detail");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Boarding_detail[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_detail");
            qName2 = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_detail");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "ArrayOfBoarding_point");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Boarding_point[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Boarding_point");
            qName2 = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Boarding_point");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "ArrayOfJourney");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Journey[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey");
            qName2 = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "ArrayOfJourney_destination_station_list");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Journey_destination_station_list[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_destination_station_list");
            qName2 = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_destination_station_list");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "ArrayOfJourney_source_station_list");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Journey_source_station_list[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_source_station_list");
            qName2 = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_source_station_list");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "ArrayOfStation");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Station[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "station");
            qName2 = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "station");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_detail");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Boarding_detail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "boarding_detail_list");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Boarding_detail_list.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Boarding_point");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Boarding_point.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Cancell_ticket_result");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Cancell_ticket_result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Cancellable_status");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Cancellable_status.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "confirm_booking");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Confirm_booking.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Destination_list");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Destination_list.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "jounrney_source_destinationlist");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Jounrney_source_destinationlist.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Journey.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_destination_station_list");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Journey_destination_station_list.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Journey_list");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Journey_list.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "journey_source_station_list");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Journey_source_station_list.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "Seat_detail");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Seat_detail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "station");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Station.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "stations_list");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Stations_list.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "temp_booking");
            cachedSerQNames.add(qName);
            cls = in.vrllogistics.www.webs.WS.Temp_booking.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public in.vrllogistics.www.webs.WS.Stations_list getStations() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.vrllogistics.in/webs/WS/GetStations");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "GetStations"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (in.vrllogistics.www.webs.WS.Stations_list) _resp;
            } catch (java.lang.Exception _exception) {
                return (in.vrllogistics.www.webs.WS.Stations_list) org.apache.axis.utils.JavaUtils.convert(_resp, in.vrllogistics.www.webs.WS.Stations_list.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public in.vrllogistics.www.webs.WS.Jounrney_source_destinationlist getSourceDestination(int source_station_id, java.lang.String journey_date) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.vrllogistics.in/webs/WS/GetSourceDestination");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "GetSourceDestination"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(source_station_id), journey_date});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (in.vrllogistics.www.webs.WS.Jounrney_source_destinationlist) _resp;
            } catch (java.lang.Exception _exception) {
                return (in.vrllogistics.www.webs.WS.Jounrney_source_destinationlist) org.apache.axis.utils.JavaUtils.convert(_resp, in.vrllogistics.www.webs.WS.Jounrney_source_destinationlist.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public in.vrllogistics.www.webs.WS.Destination_list getDestinationStation(int source_station_id, java.lang.String journey_date) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.vrllogistics.in/webs/WS/GetDestinationStation");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "GetDestinationStation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(source_station_id), journey_date});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (in.vrllogistics.www.webs.WS.Destination_list) _resp;
            } catch (java.lang.Exception _exception) {
                return (in.vrllogistics.www.webs.WS.Destination_list) org.apache.axis.utils.JavaUtils.convert(_resp, in.vrllogistics.www.webs.WS.Destination_list.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public in.vrllogistics.www.webs.WS.Journey_list getAvailableJournies(int user_source_station_id, int user_destination_station_id, java.lang.String journey_date) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.vrllogistics.in/webs/WS/GetAvailableJournies");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "GetAvailableJournies"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(user_source_station_id), new java.lang.Integer(user_destination_station_id), journey_date});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (in.vrllogistics.www.webs.WS.Journey_list) _resp;
            } catch (java.lang.Exception _exception) {
                return (in.vrllogistics.www.webs.WS.Journey_list) org.apache.axis.utils.JavaUtils.convert(_resp, in.vrllogistics.www.webs.WS.Journey_list.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public in.vrllogistics.www.webs.WS.Journey_list getJourneyDetails(int journey_id, int user_source_station_id, int user_destination_station_id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.vrllogistics.in/webs/WS/GetJourneyDetails");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "GetJourneyDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(journey_id), new java.lang.Integer(user_source_station_id), new java.lang.Integer(user_destination_station_id)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (in.vrllogistics.www.webs.WS.Journey_list) _resp;
            } catch (java.lang.Exception _exception) {
                return (in.vrllogistics.www.webs.WS.Journey_list) org.apache.axis.utils.JavaUtils.convert(_resp, in.vrllogistics.www.webs.WS.Journey_list.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public in.vrllogistics.www.webs.WS.Temp_booking dotempBooking(int journey_id, int user_source_station_id, int user_destination_station_id, java.lang.String seat_id, java.lang.String person_name, java.lang.String person_phone, int sex, int boarding_id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.vrllogistics.in/webs/WS/DotempBooking");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "DotempBooking"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(journey_id), new java.lang.Integer(user_source_station_id), new java.lang.Integer(user_destination_station_id), seat_id, person_name, person_phone, new java.lang.Integer(sex), new java.lang.Integer(boarding_id)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (in.vrllogistics.www.webs.WS.Temp_booking) _resp;
            } catch (java.lang.Exception _exception) {
                return (in.vrllogistics.www.webs.WS.Temp_booking) org.apache.axis.utils.JavaUtils.convert(_resp, in.vrllogistics.www.webs.WS.Temp_booking.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public in.vrllogistics.www.webs.WS.Confirm_booking confirmBooking(java.lang.String temp_pnr_no) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.vrllogistics.in/webs/WS/ConfirmBooking");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "ConfirmBooking"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {temp_pnr_no});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (in.vrllogistics.www.webs.WS.Confirm_booking) _resp;
            } catch (java.lang.Exception _exception) {
                return (in.vrllogistics.www.webs.WS.Confirm_booking) org.apache.axis.utils.JavaUtils.convert(_resp, in.vrllogistics.www.webs.WS.Confirm_booking.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public in.vrllogistics.www.webs.WS.Cancellable_status isTicketCancellable(java.lang.String pnr_no) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.vrllogistics.in/webs/WS/API Gives the Cancel Status");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "API_x0020_Gives_x0020_the_x0020_Cancel_x0020_Status"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pnr_no});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (in.vrllogistics.www.webs.WS.Cancellable_status) _resp;
            } catch (java.lang.Exception _exception) {
                return (in.vrllogistics.www.webs.WS.Cancellable_status) org.apache.axis.utils.JavaUtils.convert(_resp, in.vrllogistics.www.webs.WS.Cancellable_status.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public in.vrllogistics.www.webs.WS.Cancell_ticket_result cancellTicket(java.lang.String pnr_no) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.vrllogistics.in/webs/WS/API Cancel Booking");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "API_x0020_Cancel_x0020_Booking"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pnr_no});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (in.vrllogistics.www.webs.WS.Cancell_ticket_result) _resp;
            } catch (java.lang.Exception _exception) {
                return (in.vrllogistics.www.webs.WS.Cancell_ticket_result) org.apache.axis.utils.JavaUtils.convert(_resp, in.vrllogistics.www.webs.WS.Cancell_ticket_result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public in.vrllogistics.www.webs.WS.Boarding_detail_list getBoardingdetail(int boarding_id) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.vrllogistics.in/webs/WS/API Gives Boarding Details");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.vrllogistics.in/webs/WS/", "API_x0020_Gives_x0020_Boarding_x0020_Details"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Integer(boarding_id)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (in.vrllogistics.www.webs.WS.Boarding_detail_list) _resp;
            } catch (java.lang.Exception _exception) {
                return (in.vrllogistics.www.webs.WS.Boarding_detail_list) org.apache.axis.utils.JavaUtils.convert(_resp, in.vrllogistics.www.webs.WS.Boarding_detail_list.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
