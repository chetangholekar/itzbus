package com.itz.bus.dwr;

import in.vrllogistics.www.webs.WS.Station;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.itz.bus.ws.VRLBusServices;

public class CommonDWRUtil {
	
	public HashMap getVRLStationList() throws Exception{
		LinkedHashMap list = new LinkedHashMap();
		try{
			
			Station[] stationList = null;
			VRLBusServices vrlBusServices = new VRLBusServices();
			stationList = vrlBusServices.getStationList();
				list.put("", "Select");
				if(stationList != null) {
					for(int i =0; i<= stationList.length-2; i++) {
						list.put(stationList[i].getStation_id(), stationList[i].getStation_name());
					}
				}
				
		}
		
		catch(Exception e){e.printStackTrace();}
		return list;
	}
	
	public HashMap getVRLDestinationStationList(int source_station_Id) throws Exception{
		LinkedHashMap list = new LinkedHashMap();
		try{
			
			Station[] stationList = null;
			VRLBusServices vrlBusServices = new VRLBusServices();
			Calendar cal = new GregorianCalendar();
			Date creationDate = cal.getTime();
			SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
			String journey_date = f.format(creationDate);
			stationList = vrlBusServices.GetDestinationStation(source_station_Id, journey_date);
				list.put("", "Select");
				if(stationList != null) {
					for(int i =0; i<= stationList.length-2; i++) {
						list.put(stationList[i].getStation_id(), stationList[i].getStation_name());
					}
				}
		}
		catch(Exception e){e.printStackTrace();}
		return list;
	}

}
