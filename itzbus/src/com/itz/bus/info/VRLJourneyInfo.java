package com.itz.bus.info;

import java.util.HashMap;

public class VRLJourneyInfo {
	
	private int journey_id;
	
    private int bus_id;
    
    private String bus_type;
    
    private int no_of_seats_available;
    
    private String route_note;
    
    private int no_of_boarding_points;
    
    private VRLBoardingPointInfo[] boarding_points;
    
    private int journey_min;
    
    private HashMap<String,VRLSeatDetailsInfo> seatDetails;

	/**
	 * @return the journey_id
	 */
	public int getJourney_id() {
		return journey_id;
	}

	/**
	 * @param journeyId the journey_id to set
	 */
	public void setJourney_id(int journeyId) {
		journey_id = journeyId;
	}

	/**
	 * @return the bus_id
	 */
	public int getBus_id() {
		return bus_id;
	}

	/**
	 * @param busId the bus_id to set
	 */
	public void setBus_id(int busId) {
		bus_id = busId;
	}

	/**
	 * @return the bus_type
	 */
	public String getBus_type() {
		return bus_type;
	}

	/**
	 * @param busType the bus_type to set
	 */
	public void setBus_type(String busType) {
		bus_type = busType;
	}

	/**
	 * @return the no_of_seats_available
	 */
	public int getNo_of_seats_available() {
		return no_of_seats_available;
	}

	/**
	 * @param noOfSeatsAvailable the no_of_seats_available to set
	 */
	public void setNo_of_seats_available(int noOfSeatsAvailable) {
		no_of_seats_available = noOfSeatsAvailable;
	}

	/**
	 * @return the route_note
	 */
	public String getRoute_note() {
		return route_note;
	}

	/**
	 * @param routeNote the route_note to set
	 */
	public void setRoute_note(String routeNote) {
		route_note = routeNote;
	}

	/**
	 * @return the no_of_boarding_points
	 */
	public int getNo_of_boarding_points() {
		return no_of_boarding_points;
	}

	/**
	 * @param noOfBoardingPoints the no_of_boarding_points to set
	 */
	public void setNo_of_boarding_points(int noOfBoardingPoints) {
		no_of_boarding_points = noOfBoardingPoints;
	}

	/**
	 * @return the boarding_points
	 */
	public VRLBoardingPointInfo[] getBoarding_points() {
		return boarding_points;
	}

	/**
	 * @param boardingPoints the boarding_points to set
	 */
	public void setBoarding_points(VRLBoardingPointInfo[] boardingPoints) {
		boarding_points = boardingPoints;
	}

	/**
	 * @return the journey_min
	 */
	public int getJourney_min() {
		return journey_min;
	}

	/**
	 * @param journeyMin the journey_min to set
	 */
	public void setJourney_min(int journeyMin) {
		journey_min = journeyMin;
	}

	/**
	 * @return the seatDetails
	 */
	public HashMap<String, VRLSeatDetailsInfo> getSeatDetails() {
		return seatDetails;
	}

	/**
	 * @param seatDetails the seatDetails to set
	 */
	public void setSeatDetails(HashMap<String, VRLSeatDetailsInfo> seatDetails) {
		this.seatDetails = seatDetails;
	}

	
}
