package com.itz.bus.helper;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import jisp.base.server.IServerContext;
import jisp.base.server.JISPTranHelper;

import com.itz.bus.info.VRLBusPassengerDetInfo;
import com.itz.bus.info.VRLBusTicketDetailsInfo;

import eleclipse.util.PropertySupport;
import eleclipse.util.log.ILogger;

public class VRLBusTicketDetailsHelper  extends JISPTranHelper{
	private String tableName = "tblvrlbusticket";
	
	PropertySupport support = null;
	
	
	public VRLBusTicketDetailsHelper(IServerContext iservercontext) {
		
		super(iservercontext);
		support  = new PropertySupport("PrimaryKeyList");  
		
		// TODO Auto-generated constructor stub
	}	
	
	public int insertTicketDetails(VRLBusTicketDetailsInfo vrlBustktDtlInfo) {
		boolean flag = false;
		int insert = 0;
		try
		{	
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	    System.out.println("vrlBustktDtlInfo.getJourneydatetime() "+vrlBustktDtlInfo.getJourneydatetime());
	    Date jDate = dateFormat.parse(vrlBustktDtlInfo.getJourneydatetime());
			
		VRLBusPassengerDetInfo[] busPassengerDetInfos =	vrlBustktDtlInfo.getBusPassengerDetInfos();
		String prefix = support.getResource("TBLVRLBUSTICKET", "VRL");
		String orderid = this.getNextPrimaryKey("tblvrlbusticket", "orderid", prefix, 15);
		vrlBustktDtlInfo.setOrderid(orderid);
		
		beginTransaction();
		
		String query = "insert into "+tableName+ " (orderid,requestdate,journeydatetime," +
		"source,destination,journeyid," +
		"bustype,boardingptid,boardingptname,boardingpttime,mobileno,emailid," +
		"status,bookedby,bookingpoint) " +
		"values (" + str(vrlBustktDtlInfo.getOrderid()) + ",sysdate"+ ", " +str(jDate)+ ", " +
		//+ ", " + vrlBustktDtlInfo.getJourneydatetime()+", " +
		""+str(vrlBustktDtlInfo.getSource())+ ", "+str(vrlBustktDtlInfo.getDestination())+ ", " +
		str(vrlBustktDtlInfo.getJourneyid())+", "+		
		""+str(vrlBustktDtlInfo.getBustype())+", " +
		""+str(vrlBustktDtlInfo.getBoardingptid())+", " +
		""+str(vrlBustktDtlInfo.getBoardingptname())+", " +
		""+str(vrlBustktDtlInfo.getBoardingpttime())+", " +
		""+str(vrlBustktDtlInfo.getMobileno())+", " +
		""+str(vrlBustktDtlInfo.getEmailid())+", " +
		//""+vrlBustktDtlInfo.getTempPNR()+", " +
		""+str(vrlBustktDtlInfo.getStatus())+", " +
		""+str(vrlBustktDtlInfo.getBookedby())+", " +
		str(vrlBustktDtlInfo.getBookingpoint())+")";
		insert = fireUpdate(query);		
		if(insert == 1){
			//multiple inserts 
			for(VRLBusPassengerDetInfo vrlBusPassengerDetInfo: busPassengerDetInfos )
			{
				String qry = "insert into tblvrlpassengerdetails (orderid,passgengerid,passengername,gender," +
				"age,seatno,status,seatid)" +			
				"values (" + str(orderid) + ","+ 
				""+ str(vrlBusPassengerDetInfo.getPassgengerid())+","+
				""+ str(vrlBusPassengerDetInfo.getPassengername())+", " +
				"" +str(vrlBusPassengerDetInfo.getGender())+ ", "+str(vrlBusPassengerDetInfo.getAge())+ ", " +
				"" +str(vrlBusPassengerDetInfo.getSeatno())+ ", "+str(vrlBusPassengerDetInfo.getStatus())+ ", " +
				str(vrlBusPassengerDetInfo.getSeatId())+")";			
				
				insert = fireUpdate(qry);
				if(insert != 1)
					flag = false;
				else
					flag = true;
			}
		}		
		
		}catch(Exception ex){
			ex.printStackTrace();
			println("BusTicketDetails-ROLLBACK TXN "+""+"", ILogger.ERROR);			
		}
		finally{
			System.out.println("VRLBusTicketDetailsHelper : flag = "+flag); 
			endTransaction(flag);
		}
		return insert;
	}
	
	public int updatePaymentDtl(String orderid, String oldstatus, String newstatus)
	{
	    String query = "update tblvrlbusticket set status = " + str(newstatus) + " where orderid = " + str(orderid) + " and status = " + str(oldstatus);
	    return fireUpdate(query);
	}
	
	public int updateTempBookedPNR(String tempPNR,String orderid, int originalFare,int totalFare)
	{
	   String query = "update tblvrlbusticket set temppnr = " + str(tempPNR) + ",originalfare = " + str(originalFare) + ",totalfare  = " + str(totalFare) + " where orderid = " + str(orderid);
	   return fireUpdate(query);
	}
	
	//public int updatePaymentDtl(String totalAmount,String orderid,String pgid)
	public int updatePaymentDtl(String orderid,String pgid)
	{
	    String query = "update tblvrlbusticket set pgid = " + str(pgid) + " where orderid = " + str(orderid);
	    return fireUpdate(query);
	}
	//After get Confirmed PNR, status will update "S" against orderid
	public int updateConfirmedPNR(String confirmPNR,String status,String orderid)
	{
	    //String query = "update tblvrlbusticket set confirmpnr = " + str(confirmPNR) + ",status ="+str(status)+",pgid="+str(pgid)+" where orderid = " + str(orderid);
		String query = "update tblvrlbusticket set confirmpnr = " + str(confirmPNR) + ",status ="+str(status)+" where orderid = " + str(orderid);
		return fireUpdate(query);
	}
	
	public int updateConfirmedPNR(String confirmPNR,String status,String orderid,String pgid)
	{
	    String query = "update tblvrlbusticket set confirmpnr = " + str(confirmPNR) + ",status ="+str(status)+",pgid="+str(pgid)+" where orderid = " + str(orderid);
	    updateConfirmedPNR(status,orderid);
	    return fireUpdate(query);
	}
	
	public int updateConfirmedPNR(String status,String orderid)
	{
	    String query = "update tblvrlpassengerdetails set status = " + str(status) + " where orderid = " + str(orderid);	    
	    return fireUpdate(query);
	}
	
	public int updateCNRNoOnCancellation(int cnrNo,String orderid, String usercode, int refundAmount)
	{
		
	    String query = "update tblvrlbusticket set status = 'C',cnrno = "+str(cnrNo)+",cancellationdate = sysdate,cancelledby = "+str(usercode)+",refundamt = "+str(refundAmount)+"  where orderid = " + str(orderid)+" and bookedby = "+str(usercode);	    
	    return fireUpdate(query);
	}
	
	public int updateTicketOnFailure(String orderid)
	{
	    String query = "update tblvrlbusticket set status = 'F' where orderid = " + str(orderid);	    
	    return fireUpdate(query);
	}
	
	protected String getBaseSelectCondition() {
		String s = " from "+tableName;
		return s;
	}
	
	public Collection getCollectionForDetails(Object obj) {
		VRLBusTicketDetailsInfo vrlBustktDtlInfo = (VRLBusTicketDetailsInfo)obj;
		String s = " CONFIRMPNR = "+ str(vrlBustktDtlInfo.getConfirmPNR())
		+" AND BOOKEDBY = "+ str(vrlBustktDtlInfo.getBookedby());
				
		return getCollectionWithCondition(s);
	}
	
	public VRLBusTicketDetailsInfo getDetails(Object obj) {
		Collection coll = this.getCollectionForDetails(obj);
		VRLBusTicketDetailsInfo vrlBustktDtlInfo  = null;
		if (coll != null && !coll.isEmpty()) {
			for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
				vrlBustktDtlInfo = new VRLBusTicketDetailsInfo();
				vrlBustktDtlInfo = (VRLBusTicketDetailsInfo) iterator.next();
			}
		}
		return vrlBustktDtlInfo;
	}
	

	protected String getBaseSelectParams() {
		String s = 	"ORDERID," +
					"REQUESTDATE," +
					"JOURNEYDATETIME,"+	
					"PGID, " +
					"SOURCE," +
					"DESTINATION, " +
					"JOURNEYID, " +
					"ORIGINALFARE, " +
					"TOTALFARE," +
					"PGCHARGES," +
					"BUSTYPE," +
					"BOARDINGPTID," +
					"BOARDINGPTNAME," +
					"BOARDINGPTTIME," +
					"MOBILENO," +
					"EMAILID," +
					"TEMPPNR,"+
					"CONFIRMPNR,"+
					"STATUS," +
					"BOOKEDBY," +
					"BOOKINGPOINT," +
					"CNRNO," +
					"CANCELLATIONDATE," +
					"CANCELLEDBY,"+
					"REFUNDAMT";
		return s;
	}
	
	protected Object getKey(Object obj) {
		VRLBusTicketDetailsInfo vrlBustktDtlInfo = (VRLBusTicketDetailsInfo)obj;
		return vrlBustktDtlInfo.getOrderid();
	}

	protected Object getNewObject() {
		return new VRLBusTicketDetailsInfo();
	} 
	
	
	protected Object makeObject(Object obj, Iterator iterator) {
		VRLBusTicketDetailsInfo vrlBustktDtlInfo = (VRLBusTicketDetailsInfo)obj;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:MM:ss");
		String orderid = (String)iterator.next();
		vrlBustktDtlInfo.setOrderid(orderid != null ? orderid.trim() : orderid);
		Date requestDate = (Date)iterator.next();
		vrlBustktDtlInfo.setRequestdate(requestDate != null ? dateFormat.format(requestDate) : null);
		Date journeyDate = (Date)iterator.next();
		vrlBustktDtlInfo.setJourneydatetime(journeyDate != null ? dateFormat.format(journeyDate) : null);
		String pgid = (String)iterator.next();
		vrlBustktDtlInfo.setPgid(pgid != null ? pgid.trim() : pgid);
		vrlBustktDtlInfo.setSource((String)iterator.next());
		vrlBustktDtlInfo.setDestination((String)iterator.next());
		Number number = (Number)iterator.next();
		if(number != null)
			vrlBustktDtlInfo.setJourneyid(number.intValue());
		number = (Number)iterator.next();
		if(number != null)
			vrlBustktDtlInfo.setOriginalfare(number.intValue());
		number = (Number)iterator.next();
		if(number != null)
			vrlBustktDtlInfo.setTotalfare(number.intValue());
		number = (Number)iterator.next();
		if(number != null)
			vrlBustktDtlInfo.setPgcharges(number.intValue());
		vrlBustktDtlInfo.setBustype((String)iterator.next());
		number = (Number)iterator.next();
		if(number != null)
			vrlBustktDtlInfo.setBoardingptid(number.intValue());
		vrlBustktDtlInfo.setBoardingptname((String)iterator.next());
		vrlBustktDtlInfo.setBoardingpttime((String)iterator.next());
		vrlBustktDtlInfo.setMobileno((String)iterator.next());
		vrlBustktDtlInfo.setEmailid((String)iterator.next());
		vrlBustktDtlInfo.setTempPNR((String)iterator.next());
		vrlBustktDtlInfo.setConfirmPNR((String)iterator.next());
		vrlBustktDtlInfo.setStatus((String)iterator.next());
		vrlBustktDtlInfo.setBookedby((String)iterator.next());
		vrlBustktDtlInfo.setBookingpoint((String)iterator.next());
		vrlBustktDtlInfo.setCnrNo((String)iterator.next());
		vrlBustktDtlInfo.setCancellationDate((Date)iterator.next());
		vrlBustktDtlInfo.setCancelledBy((String)iterator.next());
		number = (Number)iterator.next();
		if(number != null)
			vrlBustktDtlInfo.setRefundAmount(number.intValue());
		
		return vrlBustktDtlInfo;
	}

	public VRLBusTicketDetailsInfo[] getTicketHistory(String userCode,String status,String fromDate, String toDate) {
		Collection coll = this.geTicketHistoryCollection(userCode, status,fromDate, toDate);
		VRLBusTicketDetailsInfo[] vrlBustktDtlInfos  = null;
		int i = 0;
	    if(coll != null && !coll.isEmpty())
		{
	    	vrlBustktDtlInfos = new VRLBusTicketDetailsInfo[coll.size()];
			for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
				vrlBustktDtlInfos[i] = new VRLBusTicketDetailsInfo();
				vrlBustktDtlInfos[i] = (VRLBusTicketDetailsInfo)iterator.next();
				/*if(vrlBustktDtlInfos[i].getStatus().equalsIgnoreCase("C")){
					 getDetails(vrlBustktDtlInfos[i]);
				}*/
				i++;
			}
		}
		return vrlBustktDtlInfos;
	}
	
	public Collection geTicketHistoryCollection(String userCode,String status,String fromDate, String toDate) {
		String s = " REQUESTDATE "+ getDayRange(fromDate, toDate) +
				" and BOOKEDBY = "+ str(userCode);
		if(!status.equalsIgnoreCase("A")){
			s = s + " and status = "+ str(status);
		}
		return getCollectionWithCondition(s);
	}
	
	
	public VRLBusTicketDetailsInfo getTicketByPNR(String pnrNo, String userCode) {
		
		VRLPassengerHelper passengerHelper = new VRLPassengerHelper(getServerContext());
		Collection coll = this.getCollectionTicketByPNR(pnrNo, userCode);
		VRLBusTicketDetailsInfo vrlBustktDtlInfo  = null;
		if (coll != null && !coll.isEmpty()) {
			for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
				vrlBustktDtlInfo = new VRLBusTicketDetailsInfo();
				vrlBustktDtlInfo = (VRLBusTicketDetailsInfo) iterator.next();
				VRLBusPassengerDetInfo[] detInfos = passengerHelper.getPassengerDetails(vrlBustktDtlInfo.getOrderid());
				vrlBustktDtlInfo.setBusPassengerDetInfos(detInfos);
			}
		}
		return vrlBustktDtlInfo;
	}
	
	public Collection getCollectionTicketByPNR(String pnrNo, String userCode) {
		String s = " CONFIRMPNR = "+ str(pnrNo)
		+" AND BOOKEDBY = "+ str(userCode);
		return getCollectionWithCondition(s);
	}
	
	public VRLBusTicketDetailsInfo getTempTicketByPNR(String pnrNo, String userCode) {
		
		VRLPassengerHelper passengerHelper = new VRLPassengerHelper(getServerContext());
		Collection coll = this.getCollectionTicketByPNR(pnrNo, userCode);
		VRLBusTicketDetailsInfo vrlBustktDtlInfo  = null;
		if (coll != null && !coll.isEmpty()) {
			for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
				vrlBustktDtlInfo = new VRLBusTicketDetailsInfo();
				vrlBustktDtlInfo = (VRLBusTicketDetailsInfo) iterator.next();
				VRLBusPassengerDetInfo[] detInfos = passengerHelper.getPassengerDetails(vrlBustktDtlInfo.getOrderid());
				vrlBustktDtlInfo.setBusPassengerDetInfos(detInfos);
			}
		}
		return vrlBustktDtlInfo;
	}
	
	public Collection getCollectionTempTicketByPNR(String pnrNo, String userCode) {
		String s = " TEMPPNR = "+ str(pnrNo)
		+" AND BOOKEDBY = "+ str(userCode);
		return getCollectionWithCondition(s);
	}
	
	private String getDayRange(String fromDate,String toDate){
		return " BETWEEN TO_DATE('" + fromDate + " 00:00:00','dd/MM/yyyy HH24:MI:SS') AND TO_DATE('" + toDate + " 23:59:59','dd/MM/yyyy HH24:MI:SS') ";
	}
}
