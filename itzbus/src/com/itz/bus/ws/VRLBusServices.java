package com.itz.bus.ws;

import java.util.HashMap;

import in.vrllogistics.www.webs.WS.Boarding_detail;

import in.vrllogistics.www.webs.WS.Boarding_detail_list;
import in.vrllogistics.www.webs.WS.Boarding_point;
import in.vrllogistics.www.webs.WS.Cancell_ticket_result;
import in.vrllogistics.www.webs.WS.Cancellable_status;
import in.vrllogistics.www.webs.WS.Confirm_booking;
import in.vrllogistics.www.webs.WS.Destination_list;
import in.vrllogistics.www.webs.WS.Journey;
import in.vrllogistics.www.webs.WS.Journey_list;
import in.vrllogistics.www.webs.WS.Station;
import in.vrllogistics.www.webs.WS.Stations_list;
import in.vrllogistics.www.webs.WS.Temp_booking;
import in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesLocator;
import in.vrllogistics.www.webs.WS.VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap;

import org.apache.axis.client.Stub;
import org.apache.axis.message.SOAPHeaderElement;

import com.itz.bus.info.VRLBoardingPointInfo;
import com.itz.bus.info.VRLJourneyInfo;
import com.itz.bus.info.VRLSeatDetailsInfo;

import eleclipse.util.PropertySupport;

/**
 * 
 * @author Nimisha Gosai
 * @since 16/01/2013
 * @version 1.0
 *
 */

public class VRLBusServices {
	

	
	private static PropertySupport propertySupport = null;
	public static String  path,
	                      userName,
	                      password = null;
	
	public static VRL_x0020_Booking_x0020_Web_x0020_ServicesSoap magicSubscriberSoap;
	
	static{
		try
		{
			propertySupport = new PropertySupport("ItzBus");
			path = propertySupport.getResource("VRLURL", "");
			userName = propertySupport.getResource("VRLUserName", "");
			password = propertySupport.getResource("VRLPassword", "");
			VRL_x0020_Booking_x0020_Web_x0020_ServicesLocator lc = new VRL_x0020_Booking_x0020_Web_x0020_ServicesLocator();
			magicSubscriberSoap = lc.getVRL_x0020_Booking_x0020_Web_x0020_ServicesSoap();
			SOAPHeaderElement authentication = new SOAPHeaderElement(path,"usercredentials");
			SOAPHeaderElement user = new SOAPHeaderElement(path,"user_name", userName);
			SOAPHeaderElement pwd = new SOAPHeaderElement(path,"password", password);
			authentication.addChild(user);
			authentication.addChild(pwd);
			((Stub)magicSubscriberSoap).setHeader(authentication);
			((Stub)magicSubscriberSoap).setUsername(userName);
			((Stub)magicSubscriberSoap).setPassword(password); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public Station[] getStationList() throws Exception
	{
		Station[] stations = null;
		try{
			Stations_list stations_list = null;
			stations_list = magicSubscriberSoap.getStations();
			stations = stations_list.getStations();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stations;
	}
	
	public Station[] GetDestinationStation(int source_station_id,String journey_date) throws Exception
	{
		Station[] stations = null;
		try{
			Destination_list dest_stations_list = null;
			dest_stations_list = magicSubscriberSoap.getDestinationStation(source_station_id, journey_date);
			if(dest_stations_list != null){
				stations = dest_stations_list.getDestination_stations();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stations;
	}
	
	//GetAvailableJournies getAvailableJournies(user_source_station_id, user_destination_station_id, journey_date);
	public VRLJourneyInfo[] getAvailableJournies(int user_source_station_id,int user_destination_station_id,String journey_date) throws Exception
	{
		Journey[] journey = null;
		String seatNames[],
		       seatIndex[],
		       seatAvail[],
		       seatFare[],
		       seatSex[];
		String delimiter = ",";
		VRLJourneyInfo[] vrlJourneyInfo  = null;
		VRLSeatDetailsInfo[] vrlSeatDetailsInfo;
		HashMap<String,VRLSeatDetailsInfo> seatDetails;
		
		try{
			Journey_list jrnyList = null;
			jrnyList = magicSubscriberSoap.getAvailableJournies(user_source_station_id, user_destination_station_id, journey_date);
			
			String requestXML = ((Stub)magicSubscriberSoap)._getCall().getMessageContext().getRequestMessage().getSOAPPartAsString();  
		    String responseXML = ((Stub)magicSubscriberSoap)._getCall().getMessageContext().getResponseMessage().getSOAPPartAsString();
		    //System.out.println("requestXML----"+requestXML);
		    //System.out.println("responseXML----"+responseXML);
		    
			if(jrnyList !=null)
			journey = jrnyList.getJournies();
			
			//System.out.println("jrnyList.getNo_of_journies()"+jrnyList.getNo_of_journies());
			//System.out.println("[journey.length] "+journey.length);
			//System.out.println("[journey] "+journey);
			int nosOfJourneys =  jrnyList.getNo_of_journies();
			//vrlJourneyInfo = new VRLJourneyInfo[journey.length-1];
			vrlJourneyInfo = new VRLJourneyInfo[nosOfJourneys];
			//for(int i=0;i<journey.length-1;i++)
			for(int i=0; i < nosOfJourneys; i++)
			{
				if(journey[i] != null){
					VRLBoardingPointInfo[] vrlBoardingPointInfo = new VRLBoardingPointInfo[journey[i].getNo_of_boarding_points()];
					vrlJourneyInfo[i] = new VRLJourneyInfo();
					vrlJourneyInfo[i].setJourney_id(journey[i].getJourney_id());
					vrlJourneyInfo[i].setBus_id(journey[i].getBus_id());
					vrlJourneyInfo[i].setBus_type(journey[i].getBus_type());
					vrlJourneyInfo[i].setNo_of_seats_available(journey[i].getNo_of_seats_available());
					vrlJourneyInfo[i].setRoute_note(journey[i].getRoute_note());
					vrlJourneyInfo[i].setNo_of_boarding_points(journey[i].getNo_of_boarding_points());
					vrlJourneyInfo[i].setJourney_min(journey[i].getJourney_min());
					
					Boarding_point[] brdgPoint = journey[i].getBoarding_points();
					
					/*for(Boarding_point brdgPoint : journey.getBoarding_points())
					{ Bug detected : total no of boarding points are 5 but they are sending 6 in getBoarding_points()*/
					for(int j=0;j<brdgPoint.length-1;j++){
						vrlBoardingPointInfo[j] = new VRLBoardingPointInfo();
						vrlBoardingPointInfo[j].setBoarding_point_id(brdgPoint[j].getBoarding_point_id());
						vrlBoardingPointInfo[j].setBoarding_point_name(brdgPoint[j].getBoarding_point_name());
						vrlBoardingPointInfo[j].setBoarding_point_time(brdgPoint[j].getBoarding_point_time());
					}
					vrlJourneyInfo[i].setBoarding_points(vrlBoardingPointInfo);
					
					seatNames = journey[i].getSeat_details().getSeat_Names().split(delimiter);
					seatIndex = journey[i].getSeat_details().getSeat_indexs().split(delimiter);
				    seatAvail = journey[i].getSeat_details().getSeat_availablity().split(delimiter);
				    seatFare = journey[i].getSeat_details().getSeat_fares().split(delimiter);
				    seatSex = journey[i].getSeat_details().getSeat_sexes().split(delimiter);
				    vrlSeatDetailsInfo = new VRLSeatDetailsInfo[seatNames.length];
				    seatDetails = new HashMap<String,VRLSeatDetailsInfo>();
				    for(int k=0;k<seatNames.length;k++)
				    {
				    	vrlSeatDetailsInfo[k] = new VRLSeatDetailsInfo();
				    	vrlSeatDetailsInfo[k].setSeat_Names(seatNames[k]);
				    	vrlSeatDetailsInfo[k].setSeat_indexs(seatIndex[k]);
				    	vrlSeatDetailsInfo[k].setSeat_availablity(seatAvail[k]);
				    	vrlSeatDetailsInfo[k].setSeat_fares(seatFare[k]);
				    	vrlSeatDetailsInfo[k].setSeat_sexes(seatSex[k]);
				    	vrlSeatDetailsInfo[k].setSeat_staxp1(journey[i].getSeat_details().getSeat_staxp1());
				    	vrlSeatDetailsInfo[k].setSeat_staxvc1(journey[i].getSeat_details().getSeat_staxvc1());
				    	seatDetails.put(seatIndex[k], vrlSeatDetailsInfo[k]);
				    }
				    vrlJourneyInfo[i].setSeatDetails(seatDetails);
				}
				
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return vrlJourneyInfo;
	}
	//DotempBooking dotempBooking(journey_id, user_source_station_id, user_destination_station_id, seat_id, person_name, person_phone, sex, boarding_id)
	public Temp_booking doTempBooking(int journey_id,int user_source_station_id,int user_destination_station_id,String seat_id,String person_name,String person_phone,int sex,int boarding_id)
	{	
		Temp_booking tempBooking = null;
		try{
			Journey_list jrnyList = null;
			tempBooking = magicSubscriberSoap.dotempBooking(journey_id, user_source_station_id, user_destination_station_id, seat_id, person_name, person_phone, sex, boarding_id);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return tempBooking;
	}
	
	//ConfirmBooking 
	public Confirm_booking confirmBooking(String pnrNo)
	{	
		Confirm_booking confirmBooking = null;
		try{			
			confirmBooking = magicSubscriberSoap.confirmBooking(pnrNo);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return confirmBooking;
	}
	//IsTicketCancellable
	public Cancellable_status IsTicketCancellable(String pnrNo)
	{	
		Cancellable_status cancellableStatus = null;
		try{			
			cancellableStatus = magicSubscriberSoap.isTicketCancellable(pnrNo);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cancellableStatus;
	}
	//Cancell_ticket_result
	public Cancell_ticket_result CancellTicket(String pnrNo)
	{	
		Cancell_ticket_result cancellTicketResult = null;
		try{			
			cancellTicketResult = magicSubscriberSoap.cancellTicket(pnrNo);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cancellTicketResult;
	}
	public Boarding_detail[] getBoardingdetail(int boarding_id)
	{	
		Boarding_detail_list boardingDetailList = null;
		Boarding_detail[] boardingDetail = null;
		try{			
			boardingDetailList = magicSubscriberSoap.getBoardingdetail(boarding_id);			
			boardingDetail = boardingDetailList.getBoarding_detail();			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return boardingDetail;
	}
	//Boarding_detail_list return No_of_boarding_points,response_code,boarding_detail
	public Boarding_detail_list getBoardingdetailList(int boarding_id)
	{	
		Boarding_detail_list boardingDetailList = null;
		try{			
			boardingDetailList = magicSubscriberSoap.getBoardingdetail(boarding_id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return boardingDetailList;
	}
	////Boarding_detail_list return No_of_boarding_points,response_code,boarding_detail
	/*public Boarding_point[] getBoardingPoints(int boarding_id)
	{	
		Boarding_detail_list boardingDetailList = null;
		Journey_list jrnyList = null;
		Journey[] jrny = null;
		try{			
			//jrnyList = magicSubscriberSoap.getJourneyDetails(481605, 3, 139);
			magicSubscriberSoap.get
			jrny = jrnyList.getJournies();
			jrny[0].
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return boardingDetailList;
	}*/
}
