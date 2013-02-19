package in.vrllogistics.www.webs.WS;

public class VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy implements in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap {
  private String _endpoint = null;
  private in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap = null;
  
  public VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy() {
    _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
  }
  
  public VRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
  }
  
  private void _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy() {
    try {
      vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap = (new in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesLocator()).getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap();
      if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap != null)
      ((javax.xml.rpc.Stub)vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap() {
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap;
  }
  
  public in.vrllogistics.www.webs.WS.Stations_list getStations() throws java.rmi.RemoteException{
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.getStations();
  }
  
  public in.vrllogistics.www.webs.WS.Jounrney_source_destinationlist getSourceDestination(int source_station_id, java.lang.String journey_date) throws java.rmi.RemoteException{
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.getSourceDestination(source_station_id, journey_date);
  }
  
  public in.vrllogistics.www.webs.WS.Destination_list getDestinationStation(int source_station_id, java.lang.String journey_date) throws java.rmi.RemoteException{
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.getDestinationStation(source_station_id, journey_date);
  }
  
  public in.vrllogistics.www.webs.WS.Journey_list getAvailableJournies(int user_source_station_id, int user_destination_station_id, java.lang.String journey_date) throws java.rmi.RemoteException{
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.getAvailableJournies(user_source_station_id, user_destination_station_id, journey_date);
  }
  
  public in.vrllogistics.www.webs.WS.Journey_list getJourneyDetails(int journey_id, int user_source_station_id, int user_destination_station_id) throws java.rmi.RemoteException{
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.getJourneyDetails(journey_id, user_source_station_id, user_destination_station_id);
  }
  
  public in.vrllogistics.www.webs.WS.Temp_booking dotempBooking(int journey_id, int user_source_station_id, int user_destination_station_id, java.lang.String seat_id, java.lang.String person_name, java.lang.String person_phone, int sex, int boarding_id) throws java.rmi.RemoteException{
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.dotempBooking(journey_id, user_source_station_id, user_destination_station_id, seat_id, person_name, person_phone, sex, boarding_id);
  }
  
  public in.vrllogistics.www.webs.WS.Confirm_booking confirmBooking(java.lang.String temp_pnr_no) throws java.rmi.RemoteException{
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.confirmBooking(temp_pnr_no);
  }
  
  public in.vrllogistics.www.webs.WS.Cancellable_status isTicketCancellable(java.lang.String pnr_no) throws java.rmi.RemoteException{
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.isTicketCancellable(pnr_no);
  }
  
  public in.vrllogistics.www.webs.WS.Cancell_ticket_result cancellTicket(java.lang.String pnr_no) throws java.rmi.RemoteException{
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.cancellTicket(pnr_no);
  }
  
  public in.vrllogistics.www.webs.WS.Boarding_detail_list getBoardingdetail(int boarding_id) throws java.rmi.RemoteException{
    if (vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap == null)
      _initVRL_x0020_Booking_x0020_Web_x0020_ServicesSoapProxy();
    return vRL_x0020_Booking_x0020_Web_x0020_ServicesSoap.getBoardingdetail(boarding_id);
  }
  
  
}