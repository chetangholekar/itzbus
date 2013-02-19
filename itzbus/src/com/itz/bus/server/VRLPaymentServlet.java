package com.itz.bus.server;

import in.vrllogistics.www.webs.WS.Temp_booking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jisp.base.report.server.IReportContext;
import jisp.cvms.DataValidation;
import jisp.cvms.RequestProcessing;

import com.itz.bus.helper.VRLBusTicketDetailsHelper;
import com.itz.bus.info.UserInfo;
import com.itz.bus.info.VRLBusPassengerDetInfo;
import com.itz.bus.info.VRLBusTicketDetailsInfo;
import com.itz.bus.util.VRLConstant;
import com.itz.bus.ws.VRLBusServices;

import eleclipse.util.PropertySupport;
import eleclipse.util.log.ILogger;
import eleclipse.util.log.LogType;

/**
 * Servlet implementation class VRLPaymentServlet
 */
public class VRLPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	RequestProcessing rp = new RequestProcessing();
	PropertySupport vrlBus = null;
	VRLBusServices  vrlWS = new VRLBusServices();
	DataValidation dv = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VRLPaymentServlet() {
    	dv = new DataValidation();
    	vrlBus = new PropertySupport("ItzBus");    	
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		boolean sessioncheck = false;
		if (session == null || session.getAttribute("userInfo") == null)
		{
			sessioncheck = false;
		} else
		{
			long newValue = Long.parseLong((request.getParameter("bookTicketToken")));
			long oldValue = session.getAttribute("bookTicketToken") == null ? 0: ((Long) session.getAttribute("bookTicketToken")).longValue();
			if (oldValue != newValue) 
			{
				sessioncheck = true;
				session.setAttribute("bookTicketToken",newValue);
			}
		}

		if (!sessioncheck)
		{
			request.setAttribute("msg", "Invalid session. This could have happened if you pressed back or refresh or kept your session idle for a long time.");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/jsp/applicationError.jsp");
			requestdispatcher.forward(request, response);
			session.invalidate();
			return;
		}
		
		boolean validateFlag = true;
		String orderid = "";
		String path ="/jsp/bookTicket.jsp";
		String seatid="";
		String seatNo ="";
		String name="";
		String age="";
		String sex="";
		String strSeatNo = "";
	    String strName = "";
	    String errorMessage="";
		int strPsgSex = 1;
		int psgSex = 0;
		int sourceid = 0;
		int destid = 0;
		
		
		String mobileno = request.getParameter("mobileno");
		String emailid = request.getParameter("emailid");
		
		if (!dv.validateMobileNumber(mobileno)) {
			validateFlag = false;
		   	errorMessage = "Please enter validae mobile number";
	    }
	
		if (!dv.validateEmailID(emailid)) {
			validateFlag = false;
			errorMessage = "Please enter validae email id";
		}
		
		IReportContext ireportcontext = (IReportContext)getServletContext().getAttribute("WebContext");
		ILogger ilogger = ireportcontext.getLogger();
		if(validateFlag){
			UserInfo userInfo = ((UserInfo)session.getAttribute("userInfo"));
			VRLBusTicketDetailsHelper ticketDetail = new VRLBusTicketDetailsHelper(ireportcontext);
			VRLBusTicketDetailsInfo tktDtlInfo = new VRLBusTicketDetailsInfo();
			VRLBusTicketDetailsInfo busTicketDetailsInfo = (VRLBusTicketDetailsInfo)session.getAttribute("busTicketInfo");
			Temp_booking temoBook = null;	
			int boardingptid = busTicketDetailsInfo.getBoardingptid();
			int journeyid = busTicketDetailsInfo.getJourneyid();
			sourceid = busTicketDetailsInfo.getSourceId();
			destid = busTicketDetailsInfo.getDestinationId();
			VRLBusPassengerDetInfo[] pasngrDetailsInfo = null;
					
			tktDtlInfo.setMobileno(mobileno);
			tktDtlInfo.setEmailid(emailid);
			//below parameters are get from session and Set to Info
			tktDtlInfo.setSource(busTicketDetailsInfo.getSource());
			tktDtlInfo.setDestination(busTicketDetailsInfo.getDestination());
			tktDtlInfo.setSourceId(sourceid);
			tktDtlInfo.setDestinationId(destid);
			tktDtlInfo.setBoardingptid(boardingptid);		
			tktDtlInfo.setJourneyid(journeyid);		
			tktDtlInfo.setBustype(busTicketDetailsInfo.getBustype());		
			tktDtlInfo.setBoardingptname(busTicketDetailsInfo.getBoardingptname());
			tktDtlInfo.setBoardingpttime(busTicketDetailsInfo.getBoardingpttime());
			tktDtlInfo.setBookingpoint(busTicketDetailsInfo.getBookingpoint());
			tktDtlInfo.setJourneydatetime(busTicketDetailsInfo.getJourneydatetime());
			//TO DO Decode
			tktDtlInfo.setBookedby(userInfo.getUserCode());		
			//tktDtlInfo.setBookingpoint(userInfo.);
			tktDtlInfo.setStatus("P");
			int result = 0;
			String[] totalPassengers =(String[])request.getParameterValues("total");
			if(totalPassengers.length != 0){
				pasngrDetailsInfo = new VRLBusPassengerDetInfo[totalPassengers.length];
		    	for(int k=0;k<totalPassengers.length;k++)
		    	{
	    		  	pasngrDetailsInfo[k] = new VRLBusPassengerDetInfo();
	    		    name = (String)request.getParameter("name_"+k);
					sex = (String)request.getParameter("sex_"+k);					
					age = (String)request.getParameter("age_"+k);
					seatid= (String)(request.getParameter("seatId_"+k));
					seatNo = (String)(request.getParameter("seatNo_"+k));
					pasngrDetailsInfo[k].setPassengername(name);
					pasngrDetailsInfo[k].setGender(sex);
					pasngrDetailsInfo[k].setAge(Integer.parseInt(age));
					pasngrDetailsInfo[k].setSeatno(seatNo);	
					pasngrDetailsInfo[k].setSeatId(seatid);
					pasngrDetailsInfo[k].setStatus("P");
					pasngrDetailsInfo[k].setPassgengerid(k+1);				
					
					/*
					 * setting for doTempPNR
					 */
					if(sex.equals("M"))
						psgSex = 1;
					else
						psgSex = 2;
					
					if(k > 0){
						strSeatNo = strSeatNo + "," +seatNo;
						strName = strName + "," + name;
						
					}else{
						strSeatNo = seatNo;
						strName = name;
					}
					strPsgSex = psgSex;
				}
		    	
	    	    tktDtlInfo.setBusPassengerDetInfos(pasngrDetailsInfo);
	  		    result = ticketDetail.insertTicketDetails(tktDtlInfo);
	  		  
	  		    String debugString = journeyid+":"+sourceid+":"+destid+":"+strSeatNo+":"+strName+":"+mobileno+":"+strPsgSex+":"+boardingptid;
	  		    if(result == 1){
			    	temoBook = vrlWS.doTempBooking(journeyid, sourceid, destid, strSeatNo,strName,mobileno,strPsgSex,boardingptid);
			    	orderid = tktDtlInfo.getOrderid();
			    	int tempPNRResponseCode = temoBook.getResponse_code();
					if(tempPNRResponseCode == VRLConstant.SUCCESS)
					{		
						String tempPNR = temoBook.getPnr_no();
						tktDtlInfo.setTempPNR(tempPNR);
						double ticketAmount = temoBook.getGrand_total();
				    	tktDtlInfo.setTotalfare(new Double(ticketAmount*100).intValue());
				    	tktDtlInfo.setOriginalfare(new Double(ticketAmount*100).intValue());
						
						//Update tblbusticket with tempPNR against oredrid 
					    int updateTempPNR = ticketDetail.updateTempBookedPNR(tempPNR, orderid, tktDtlInfo.getOriginalfare(), tktDtlInfo.getTotalfare());
					    if(updateTempPNR == 1){
					    	println(ilogger, "TEMPPNR:"+debugString, LogType.INFO);
					    	session.setAttribute("orderid",orderid);
			        	 	session.setAttribute("tktDtlInfo", tktDtlInfo);
			        	 	path = "/jsp/confirmPNR.jsp";
					    }
					    else{
					    	request.setAttribute("msg", "Error Processing Your Request.Please Try Again Later");
					    	println(ilogger, " Update PNR Error "+orderid, LogType.ERROR);
					    }
					}else{
						
						println(ilogger, "Unable to book ticket,Please try again later:"+debugString, LogType.ERROR);
						session.setAttribute("msg", "Unable to book ticket,Please try again later");
						path = "/jsp/bookTicket.jsp";
					}
			    }
			    else{
			    	errorMessage = "Error Processing Your Request.Please Try again Later";
					request.setAttribute("msg",errorMessage);
			    	println(ilogger, "Error to insert in tblvrlbusticket, "+tktDtlInfo.getOrderid(), LogType.ERROR);
			    }
		     }else{
		    	 errorMessage = "Please fill Passenger Details";
				 request.setAttribute("msg",errorMessage);
		    	 println(ilogger, "Error to insert in tblvrlbusticket, "+tktDtlInfo.getOrderid(), LogType.INFO);
		     }
		 }else{
			 request.setAttribute("msg",errorMessage);
			 println(ilogger, "Validation:"+errorMessage, LogType.ERROR);
		 }
		RequestDispatcher requestdispatcher = request.getRequestDispatcher(path); 
		requestdispatcher.forward(request, response);
	}

	private void println(ILogger ilogger, String s, LogType logtype) {
		if (ilogger != null) {
			ilogger.println(this.getServletName() + " : " + s, logtype);
		} else {
			System.out.println(this.getServletName() + " : " + s);
		}
	}
}
