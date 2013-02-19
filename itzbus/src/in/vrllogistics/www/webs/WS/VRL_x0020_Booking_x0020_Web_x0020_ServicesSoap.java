/**
 * VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package in.vrllogistics.www.webs.WS;

public interface VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap extends java.rmi.Remote {

    /**
     * API Gives all list of stations
     */
    public in.vrllogistics.www.webs.WS.Stations_list getStations() throws java.rmi.RemoteException;

    /**
     * API Gives all list of stations
     */
    public in.vrllogistics.www.webs.WS.Jounrney_source_destinationlist getSourceDestination(int source_station_id, java.lang.String journey_date) throws java.rmi.RemoteException;

    /**
     * API Gives all list of Destination stations
     */
    public in.vrllogistics.www.webs.WS.Destination_list getDestinationStation(int source_station_id, java.lang.String journey_date) throws java.rmi.RemoteException;

    /**
     * API Gives all list of Journies Avaliable
     */
    public in.vrllogistics.www.webs.WS.Journey_list getAvailableJournies(int user_source_station_id, int user_destination_station_id, java.lang.String journey_date) throws java.rmi.RemoteException;

    /**
     * API Gives all list of Journies Avaliable
     */
    public in.vrllogistics.www.webs.WS.Journey_list getJourneyDetails(int journey_id, int user_source_station_id, int user_destination_station_id) throws java.rmi.RemoteException;

    /**
     * API Is to book the seats Temporarily
     */
    public in.vrllogistics.www.webs.WS.Temp_booking dotempBooking(int journey_id, int user_source_station_id, int user_destination_station_id, java.lang.String seat_id, java.lang.String person_name, java.lang.String person_phone, int sex, int boarding_id) throws java.rmi.RemoteException;

    /**
     * API Is to Confirm the Temporary Booking
     */
    public in.vrllogistics.www.webs.WS.Confirm_booking confirmBooking(java.lang.String temp_pnr_no) throws java.rmi.RemoteException;
    public in.vrllogistics.www.webs.WS.Cancellable_status isTicketCancellable(java.lang.String pnr_no) throws java.rmi.RemoteException;
    public in.vrllogistics.www.webs.WS.Cancell_ticket_result cancellTicket(java.lang.String pnr_no) throws java.rmi.RemoteException;
    public in.vrllogistics.www.webs.WS.Boarding_detail_list getBoardingdetail(int boarding_id) throws java.rmi.RemoteException;
}
