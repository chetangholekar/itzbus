package com.itz.bus.helper;

import java.util.Collection;
import java.util.Iterator;

import com.itz.bus.info.VRLBusPassengerDetInfo;
import jisp.base.server.IServerContext;
import jisp.base.server.JISPTranHelper;

public class VRLPassengerHelper extends JISPTranHelper{

	private String tableName = "tblvrlpassengerdetails";
	
	public VRLPassengerHelper(IServerContext iservercontext) {
		super(iservercontext);
	}
	
	protected String getBaseSelectCondition() {
		String s = " from "+tableName;
		return s;
	}
	
	protected String getBaseSelectParams() {
		String s = 	"orderid,passgengerid,passengername,gender,age,seatno,status,cancellationdate,cancelledby,seatid";
		return s;
	}		
	
	protected Object getNewObject() {
		return new VRLBusPassengerDetInfo();
	} 
	
	protected Object makeObject(Object obj, Iterator iterator) {
		VRLBusPassengerDetInfo passengerInfo = new VRLBusPassengerDetInfo();
		passengerInfo.setOrderid((String)iterator.next());
		Number number = (Number)iterator.next();
		if(number != null)
			passengerInfo.setPassgengerid(number.intValue());
		passengerInfo.setPassengername((String)iterator.next());
		passengerInfo.setGender((String)iterator.next());
		number = (Number)iterator.next();
		if(number != null)
			passengerInfo.setAge(number.intValue());
		passengerInfo.setSeatno((String)iterator.next());
		passengerInfo.setStatus((String)iterator.next());
		passengerInfo.setCancellationdate((String)iterator.next());
		iterator.next();
		passengerInfo.setSeatId((String)iterator.next());
		return passengerInfo;
	}
	
	public VRLBusPassengerDetInfo[] getPassengerDetails(String orderId) {
		Collection coll = this.gePassengerDetailsCollection(orderId);
		VRLBusPassengerDetInfo[] detInfos  = null;
		int i = 0;
	    if(coll != null && !coll.isEmpty())
		{
	    	detInfos = new VRLBusPassengerDetInfo[coll.size()];
			for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
				detInfos[i] = new VRLBusPassengerDetInfo();
				detInfos[i] = (VRLBusPassengerDetInfo)iterator.next();
				i++;
			}
		}
		return detInfos;
	}
	
	public Collection gePassengerDetailsCollection(String orderId) {
		String s = 	" orderid = "+ str(orderId);
		return getCollectionWithCondition(s);
	}
}
