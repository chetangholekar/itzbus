package com.itz.bus.server;

import in.vrllogistics.www.webs.WS.Cancell_ticket_result;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jisp.base.report.server.IReportContext;
import jisp.cvms.RequestProcessing;
import jisp.paymentgw.PaymentGatewayResponseCodes;

import com.itz.bus.helper.VRLBusLayoutHelper;
import com.itz.bus.helper.VRLBusTicketDetailsHelper;
import com.itz.bus.helper.VRLBusTypeHelper;
import com.itz.bus.info.UserInfo;
import com.itz.bus.info.VRLBoardingPointInfo;
import com.itz.bus.info.VRLBusLayoutInfo;
import com.itz.bus.info.VRLBusPassengerDetInfo;
import com.itz.bus.info.VRLBusTicketDetailsInfo;
import com.itz.bus.info.VRLBusTypeInfo;
import com.itz.bus.info.VRLJourneyInfo;
import com.itz.bus.info.VRLSeatDetailsInfo;
import com.itz.bus.util.Email;
import com.itz.bus.util.VRLConstant;
import com.itz.bus.ws.VRLBusServices;

import eleclipse.util.PropertySupport;
import eleclipse.util.log.ILogger;
import eleclipse.util.log.LogType;
import eleclipse.util.log.Logger;

public class VRLBookingServiceServlet extends HttpServlet{
	
	 public VRLBookingServiceServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	 
	   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	HttpSession session = request.getSession(false);
	boolean sessioncheck = false;
	if (session == null || session.getAttribute("userInfo") == null)
	{
		sessioncheck = false;
	} else
	{
		sessioncheck = true;
	}

	if (!sessioncheck)
	{
		request.setAttribute("msg", "Invalid session. This could have happened if you pressed back or refresh or kept your session idle for a long time.");
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("/jsp/applicationError.jsp");
		requestdispatcher.forward(request, response);
		session.invalidate();
		return;
	}
	
	String path = null;
	String action = "";
	boolean isforward = true;
	
	IReportContext iReportContext = (IReportContext) getServletContext().getAttribute("WebContext");
	VRLBusTicketDetailsHelper vrlBusTicketDetailsHelper = new VRLBusTicketDetailsHelper(iReportContext);
	ILogger ilogger = iReportContext.getLogger();
	try {
		action = request.getParameter("submitAction");
		VRLBusServices vrlBusServices = new VRLBusServices();
		
		UserInfo userInfo =(UserInfo)session.getAttribute("userInfo");
		
		if(action.equalsIgnoreCase("SearchAvailBus"))
		{
			String sourceStation = request.getParameter("source_station");
			String destStation = request.getParameter("dest_station");
			String sourceStationName = request.getParameter("srcStnName");
			String destStationName = request.getParameter("destStnName");
			String journeyDate = request.getParameter("journey_Date");
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
			SimpleDateFormat format2 = new SimpleDateFormat("mm/dd/yyyy");
			journeyDate = format2.format(format.parse(journeyDate));
			VRLJourneyInfo[] getBusDetails = vrlBusServices.getAvailableJournies(Integer.parseInt(sourceStation), Integer.parseInt(destStation), journeyDate);
			session.setAttribute("getAvailBusDetails", getBusDetails);
			request.setAttribute("sourceStation", sourceStation);
			request.setAttribute("destStation", destStation);
			request.setAttribute("sourceStationName", sourceStationName);
			request.setAttribute("destStationName", destStationName);
			request.setAttribute("jrnyDate",  format.format(format2.parse(journeyDate)));
			path = "/jsp/home.jsp";
		}
		else if(action.equalsIgnoreCase("GetBusDetails"))
		{
			String busType = request.getParameter("busType");
			String journeyId = request.getParameter("jrnyId");
			VRLBusTypeHelper vrlBusTypeHelper = new VRLBusTypeHelper(iReportContext);
			VRLBusLayoutHelper vrlBusLayoutHelper = new VRLBusLayoutHelper(iReportContext);
			VRLBusTypeInfo vrlBusTypeInfo = new VRLBusTypeInfo();
			vrlBusTypeInfo.setBusType_ID(Integer.parseInt(busType));
			vrlBusTypeInfo=vrlBusTypeHelper.getBusTypeDetails(vrlBusTypeInfo);
			VRLBusLayoutInfo vrlBusLayoutInfo = new VRLBusLayoutInfo();
			VRLBusLayoutInfo[] vrlBusLayoutInfos;
			vrlBusLayoutInfo.setBusTypeId(vrlBusTypeInfo.getBusType_ID());
			vrlBusLayoutInfos = vrlBusLayoutHelper.getBusLayoutDetails(vrlBusLayoutInfo);
			VRLJourneyInfo[] jrny =(VRLJourneyInfo[])session.getAttribute("getAvailBusDetails");
			request.setAttribute("vrlBusTypeInfo", vrlBusTypeInfo);
			request.setAttribute("vrlBusLayoutInfos", vrlBusLayoutInfos);
			request.setAttribute("busDetails", jrny[Integer.parseInt(journeyId)]);
			path = "/jsp/home.jsp";
		}
		else if(action.equalsIgnoreCase("GetBusDetailsByString"))
		{
			String busType = request.getParameter("busType");
			String journeyId = request.getParameter("jrnyId");
			//System.out.println("busType :"+busType+"journeyId :"+journeyId);
			VRLBusTypeHelper vrlBusTypeHelper = new VRLBusTypeHelper(iReportContext);
			VRLBusLayoutHelper vrlBusLayoutHelper = new VRLBusLayoutHelper(iReportContext);
			VRLBusTypeInfo vrlBusTypeInfo = new VRLBusTypeInfo();
			vrlBusTypeInfo.setBusType_ID(Integer.parseInt(busType));
			vrlBusTypeInfo=vrlBusTypeHelper.getBusTypeDetails(vrlBusTypeInfo);
			VRLBusLayoutInfo vrlBusLayoutInfo = new VRLBusLayoutInfo();
			VRLBusLayoutInfo[] vrlBusLayoutInfos;
			vrlBusLayoutInfo.setBusTypeId(vrlBusTypeInfo.getBusType_ID());
			vrlBusLayoutInfos = vrlBusLayoutHelper.getBusLayoutDetails(vrlBusLayoutInfo);
			VRLJourneyInfo[] jrny =(VRLJourneyInfo[])session.getAttribute("getAvailBusDetails");
			//request.setAttribute("vrlBusTypeInfo", vrlBusTypeInfo);
			//request.setAttribute("vrlBusLayoutInfos", vrlBusLayoutInfos);
			//request.setAttribute("busDetails", jrny[Integer.parseInt(journeyId)]);
			
			/**
			 * 
			 */
			String finalTable = "";
			String layoutTable = "";
			String showRouteTable = "";
			String bookedMaleTicketStyle = "background-color: #F55252";
			String bookedFemaleTicketStyle = "background-color: #0066ff";
			String availTicketStyle = "background-color: #ADFF2F";
			String blockedTicketStyle= "background-color: #ff9933";    
			
			String style ="";
			boolean checkBoxFlag = false;
			int arrDeatails = 0;
			VRLBusLayoutInfo[][] seatList = null;
			HashMap<String, VRLSeatDetailsInfo> seatDetails = new HashMap<String, VRLSeatDetailsInfo>();
			VRLSeatDetailsInfo vrlSeatDetailsInfo = new VRLSeatDetailsInfo();
			VRLBoardingPointInfo[] vrlBoardingPointInfo = null;
			VRLJourneyInfo busDetails = jrny[Integer.parseInt(journeyId)];
			vrlBoardingPointInfo = busDetails.getBoarding_points();
			
			if(busDetails !=null)
			{
				seatDetails = busDetails.getSeatDetails();
				vrlBoardingPointInfo = busDetails.getBoarding_points();
			}
			
			if(vrlBusTypeInfo != null){
				seatList= new VRLBusLayoutInfo[vrlBusTypeInfo.getRowCount()][vrlBusTypeInfo.getColumnCount()];
				int k=0;
				for (int i=0;i<vrlBusTypeInfo.getRowCount();i++){
					for (int j=0;j<vrlBusTypeInfo.getColumnCount();j++){
						seatList[i][j] = vrlBusLayoutInfos[k];
						k++;
					}
				}
			}
			
			 if(vrlBusTypeInfo != null){ 
				 layoutTable = layoutTable +"<table border='1' class='table table-bordered table-striped'>";
			 	 for (int i=0; i < vrlBusTypeInfo.getRowCount(); i++) // Row Iteration
				 { 
			 		 layoutTable = layoutTable +"<tr>";
					 for (int j=0;j < vrlBusTypeInfo.getColumnCount();j++) // column Iteration
					 {
						 //System.out.println.println("Row is  "+i+"####Column is "+j+ seatList[i][j]);
						 vrlBusLayoutInfo =  seatList[i][j];
						 //need to check condition for empty seats 
						 
						 if(vrlBusLayoutInfo.getSeatNo() != 0)
						 {
							 vrlSeatDetailsInfo = (VRLSeatDetailsInfo)seatDetails.get(String.valueOf(vrlBusLayoutInfo.getSeatNo()));
					 		   if(vrlSeatDetailsInfo.getSeat_availablity().equalsIgnoreCase("0"))
					 		   {
					 			  if("1".equalsIgnoreCase(vrlSeatDetailsInfo.getSeat_sexes())){
					 				 style= bookedMaleTicketStyle;  
					 			  }else if("2".equalsIgnoreCase(vrlSeatDetailsInfo.getSeat_sexes())){
					 				 style = bookedFemaleTicketStyle;  
					 			  }
					 			   checkBoxFlag = false;
					 		   }
					 	   	   else
					 	   	   {
					 	   		   style= availTicketStyle;
					 	   		   checkBoxFlag = true;
					 	   	   }
				 	     }
					 	 else
					 	 {
					 		 style="background-color: white";
					 		 checkBoxFlag = false;
					 	 }
						 	   //System.out.println("Seat No :"+vrlBusLayoutInfo.getSeatNo()); 
						 	  layoutTable = layoutTable +"<td style='"+style+"'>";
						 	   if(vrlBusLayoutInfo.getSeatId() != null)
						 	   {
						 		   if(checkBoxFlag)
						 	 	   {
						 	 		String temp="<input type='checkbox' name='seatDet"+journeyId+"' id='seatDet"+journeyId+"_"+arrDeatails+"' value='"+arrDeatails+"'>&nbsp;<input type='hidden' name='seatId"+journeyId+"_"+arrDeatails+"' id='seatId"+journeyId+"_"+arrDeatails+"' value='"+vrlSeatDetailsInfo.getSeat_Names()+"'><input type='hidden' name='seatNo"+journeyId+"_"+arrDeatails+"'  id='seatNo"+journeyId+"_"+arrDeatails+"' value='"+vrlSeatDetailsInfo.getSeat_indexs()+"'/><input type='hidden' name='fare"+journeyId+"_"+arrDeatails+"'  id='fare"+journeyId+"_"+arrDeatails+"' value='"+vrlSeatDetailsInfo.getSeat_fares()+"'/>";
						 	 		layoutTable = layoutTable +temp;
						 	 		arrDeatails++;
						 	 		//System.out.println("arrDeatails :"+arrDeatails);
						 	 	   }
						 		  layoutTable = layoutTable +"<a title='Fare: "+vrlSeatDetailsInfo.getSeat_fares()+getGenderDesc(vrlSeatDetailsInfo.getSeat_sexes())+"'>"+vrlBusLayoutInfo.getSeatId()+","+vrlBusLayoutInfo.getSeatType()+" "+vrlBusLayoutInfo.getWindow()+"</a>"; 
						 	   }
						 	   else{
	
						 	  }
						 	  layoutTable = layoutTable + "</td>";
						 	  //System.out.println("Td :"+layoutTable);
						    }
						    layoutTable = layoutTable +"</tr>";
					  } 
						 layoutTable = layoutTable +"</table>";
				
				/* For boarding point */
				 String boradingDiv = "";
				 boradingDiv = boradingDiv +"<div class='control-group'><div class='controls'>Boarding Point : <select name='boardingPoint"+journeyId+"' id='boardingPoint"+journeyId+"'><option value='' selected='selected'>Select Boarding Point</option>";
				for(int b=0;b<vrlBoardingPointInfo.length;b++){ 
					boradingDiv = boradingDiv +"<option value='"+vrlBoardingPointInfo[b].getBoarding_point_id()+"^"+vrlBoardingPointInfo[b].getBoarding_point_name()+"^"+vrlBoardingPointInfo[b].getBoarding_point_time()+"'>"+vrlBoardingPointInfo[b].getBoarding_point_name()+" - "+vrlBoardingPointInfo[b].getBoarding_point_time()+"</option>";
					showRouteTable = showRouteTable + "<tr><td>"+vrlBoardingPointInfo[b].getBoarding_point_name()+"</td><td>"+vrlBoardingPointInfo[b].getBoarding_point_time()+"</td></tr>";
	
				}
				showRouteTable = "<table class=table table-bordered table-striped><thead><tr><th>Boarding Point</th><th>Boarding Time</th></tr></thead>"+showRouteTable + "</table>";
				boradingDiv = boradingDiv +"</select><input type='hidden' name='journeyId"+journeyId+"'  id='journeyId"+journeyId+"' value='"+busDetails.getJourney_id()+"'/><input type='hidden' name='busType"+journeyId+"'  id='busType"+journeyId+"' value='"+busDetails.getBus_type()+"'/><input name='submit"+journeyId+"' value='Book' width='50' type='submit' onclick='return bookValidate("+journeyId+");' class='btn btn-warning'></div></div>";
				
				String bookInfoTable = "<table class='table table-bordered table-striped'>" +
						          "<tr><td style='"+bookedMaleTicketStyle+"'></td><td>Male</td></tr>" +
						          "<tr><td style='"+bookedFemaleTicketStyle+"'></td><td>Female</td></tr>" +
						          "<tr><td style='"+availTicketStyle+"'></td><td>Not Booked</td></tr>" +
						          "<tr><td style='"+blockedTicketStyle+"'></td><td>Blocked</td></tr>" +
						          "<tr><td>W</td><td>Window Seat</td></tr>" +
						          "<tr><td>NW</td><td>Non Window</td></tr>" +
						          "<tr><td>ST</td><td>Seater</td></tr>" +
						          "<tr><td>SS</td><td>Semi Sleeper</td></tr>" +
						          "<tr><td>UBS</td><td>Upper Berth Single</td></tr>" +
						          "<tr><td>LBS</td><td>Lower Berth Single</td></tr>" +
						          "<tr><td>UBD</td><td>Upper Berth Dbl</td></tr>" +
						          "<tr><td>LBD</td><td>Lower Berth Dbl</td></tr>" +
						          
						           	
						         // "<tr><td colsapn=2><a href ='#' title="+showRouteTable+">Show Boarding Points</a></td></tr>" +
						          "</table>";
				finalTable = "<table class='table table-bordered table-striped'>" +
							 "<tr><td><strong>Bus Route</strong>: "+busDetails.getRoute_note()+"</td>" +
							 "<tr><td><strong>Bus Type</strong>: "+busDetails.getBus_type()+"</td>" +
						     "<tr><td>"+layoutTable+"</td>" +
						     //"<td>"+showRouteTable+"</td>" +
						     "<td>"+bookInfoTable+"</td></tr><table>";
				finalTable = finalTable + boradingDiv;
				/* */
			 } 
			 //System.out.println("XML :"+xml);
			 response.setContentType("text");
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().write(finalTable);
			 isforward = false;
			 
		}
		if(action.equalsIgnoreCase("bookTicketDetails"))
		{
			String Id = request.getParameter("Id");
			String sourceStationId = request.getParameter("srcStationId");
			String destStationId = request.getParameter("destStationId");
			String sourceStationName = request.getParameter("srcStnName");
			String destStationName = request.getParameter("destStnName");
			String journeyDate = request.getParameter("journey_Date");
			
			
			String jouneyId = (String)request.getParameter("journeyId"+Id);
			String[] seatDet =(String[])request.getParameterValues("seatDet"+Id);
			String boardingPoint = (String)request.getParameter("boardingPoint"+Id);
			String busType = (String)request.getParameter("busType"+Id);
			String boarding[] = boardingPoint.split("\\^");
			VRLBusTicketDetailsInfo busTicketDetailsInfo = new VRLBusTicketDetailsInfo();
			busTicketDetailsInfo.setBoardingptid(Integer.parseInt(boarding[0]));
			busTicketDetailsInfo.setBoardingptname(boarding[1]);
			busTicketDetailsInfo.setBoardingpttime(boarding[2]);
			
			//System.out.println(Integer.parseInt(boarding[0])+"%%"+boarding[1]+"%%"+boarding[2]);
			busTicketDetailsInfo.setBustype(busType);
			busTicketDetailsInfo.setDestination(destStationName);
			busTicketDetailsInfo.setJourneydatetime(journeyDate+" "+boarding[2]);
			busTicketDetailsInfo.setJourneyid(Integer.parseInt(jouneyId));
			busTicketDetailsInfo.setSource(sourceStationName);
			busTicketDetailsInfo.setSourceId(Integer.parseInt(sourceStationId));
			busTicketDetailsInfo.setDestinationId(Integer.parseInt(destStationId));
			session.setAttribute("busTicketInfo",busTicketDetailsInfo);
			//System.out.println("sourceStationName :"+sourceStationName+"=destStationName :"+destStationName+"=journeyDate :"+journeyDate+"=jouneyId :"+jouneyId+"=boardingPoint :"+boardingPoint+"busType :"+busType+"=seatDet :"+seatDet.length);
			path = "/jsp/bookTicket.jsp";
		}else if(action.equalsIgnoreCase("searchBookedTicket"))
		{
			String pnrNo = request.getParameter("confirmPNR");
			VRLBusTicketDetailsInfo pnrDetailsInfo = new VRLBusTicketDetailsInfo();
			pnrDetailsInfo.setConfirmPNR(pnrNo);
			pnrDetailsInfo.setBookedby(userInfo.getUserCode());
			VRLBusTicketDetailsInfo busTicketDetailsInfo = vrlBusTicketDetailsHelper.getDetails(pnrDetailsInfo);
			if(busTicketDetailsInfo != null){
				request.setAttribute("busTicketDetailsInfo", busTicketDetailsInfo);
			}else{
				request.setAttribute("msg", "No Record Found For PNR No. : "+pnrNo);
			}
			path = "/jsp/cancelTicket.jsp";
		}
		else if(action.equalsIgnoreCase("cancelTicket"))
		{
			String pnrNo = request.getParameter("confirmPNR");
			String orderId = request.getParameter("orderid");
			Cancell_ticket_result cancellTicketResult = null;
			cancellTicketResult = vrlBusServices.CancellTicket(pnrNo);
			if(cancellTicketResult != null){
				//println(ilogger, "CancellTicket:PNR No:"+pnrNo+",ResponseCode:"+cancellTicketResult.getResponse_code()+",CNR No : "+cancellTicketResult.getCnr_no()+",RefundAmount:"+cancellTicketResult.getRefund_amount(),LogType.INFO);
				if(cancellTicketResult.getResponse_code() ==  VRLConstant.SUCCESS)
				{
				   //call Refund here
			    	RequestProcessing rp = new RequestProcessing();
			        String refundtype = "";
					String reply = "";
					PropertySupport vrlBus = new PropertySupport("ItzBus");
					String merchanttypekey = vrlBus .getResource("MerchantKey","");
			        String refundURL = vrlBus.getResource("RefundURL",""); 
			        VRLBusTicketDetailsInfo pnrDetailsInfo = new VRLBusTicketDetailsInfo();
					pnrDetailsInfo.setConfirmPNR(pnrNo);
					pnrDetailsInfo.setBookedby(userInfo.getUserCode());
					VRLBusTicketDetailsInfo busTicketDetailsInfo = vrlBusTicketDetailsHelper.getDetails(pnrDetailsInfo);
			        int ticketAmt = busTicketDetailsInfo.getTotalfare();
					int refundAmt =  new Double(cancellTicketResult.getRefund_amount()*100).intValue(); 
			        int refund = 0;
					if(ticketAmt == refundAmt){
			        	refundtype = "F";
			        	refund = ticketAmt;
			        }else{
			        	refundtype = "P";
			        	refund = refundAmt;
			        }
			        
			        String s_paramString = "amount=" +refund+"&transactionid=" + busTicketDetailsInfo.getPgid()+"&merchanttypekey=" + merchanttypekey + 
			        "&orderid=" + busTicketDetailsInfo.getOrderid()+
			        "&type="+refundtype+"&description=Refunded since transaction cancel ticket with VRL booking";
			        println(ilogger, "s_paramString = "+s_paramString+"",LogType.INFO);
			        
			        //System.out.println( "s_paramString = "+s_paramString);
			        String refundReply = rp.processRequest(refundURL, s_paramString);
			        StringTokenizer  res = new StringTokenizer(refundReply, ",");            
			        int responsecode = Integer.parseInt((String)res.nextElement());	                    
			        if(responsecode == 0)
			        {
			        	int update = vrlBusTicketDetailsHelper.updateCNRNoOnCancellation(cancellTicketResult.getCnr_no(), orderId,userInfo.getUserCode(), refundAmt);
						if(update == 1)
						{
							request.setAttribute("successResult", cancellTicketResult);
						    request.setAttribute("success", "Ticket cancelled successfully for PNR No.: "+pnrNo+" and details are as below.");
			        	
						}else{
							println(ilogger, "Error come during Updating Status:"+pnrNo+",ResponseCode:"+cancellTicketResult.getResponse_code()+",CNR No : "+cancellTicketResult.getCnr_no()+",RefundAmount:"+cancellTicketResult.getRefund_amount(),LogType.INFO);
							request.setAttribute("msg", "Ticket cancelled successfully, Error come during Updating Status at Itzcash End for PNR : "+pnrNo+" and details are as below.");
						}
			        }
			   	 	else
			   	 	{	   	 		
			   	 		request.setAttribute("msg", PaymentGatewayResponseCodes.getResponseLongDescription(responsecode));
			   	 		path = "/jsp/cancelTicket.jsp";   	 		
			        } 
			        //End of cancellation
			    }
			    else if(cancellTicketResult.getResponse_code() == VRLConstant.CANCELLATION_TIME_IS_OVER)
			    {
				   //display message like Cancellation time is over
				   request.setAttribute("msg", "Cancellation time is over for PNR No.: "+pnrNo);
			    }
			}
			else
			{
				// need to add code for ticket already cancelled
				request.setAttribute("msg", "Ticket already cancelled for PNR No. : "+pnrNo);
			}
			path = "/jsp/cancelTicket.jsp";
		}else if(action.equalsIgnoreCase("tktHistory"))
		{
			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			String status = request.getParameter("status");
			VRLBusTicketDetailsInfo[] ticketDetailsInfos = vrlBusTicketDetailsHelper.getTicketHistory(userInfo.getUserCode(), status, fromDate, toDate);
			if(ticketDetailsInfos != null){
				request.setAttribute("ticketHistory", ticketDetailsInfos);
			}else{
				request.setAttribute("msg", "No Record Found");
			}
			
			request.setAttribute("fromDate", fromDate);
			request.setAttribute("toDate", toDate);
			request.setAttribute("status", status);
			path = "/jsp/ticketHistory.jsp";
			
		}
		else if(action.equalsIgnoreCase("printTicket"))
		{
			String pnrNo = request.getParameter("pnrNo");
			VRLBusTicketDetailsInfo tktDtlInfo = vrlBusTicketDetailsHelper.getTicketByPNR(pnrNo, userInfo.getUserCode());
			String printTicketString = printTicket(tktDtlInfo);
			if(printTicketString != null){
				StringBuilder formatReceipt = new StringBuilder();
				printTicketString = printTicketString.replaceFirst("\\$bookedBy",isNull(userInfo.getCompanyName()));
				formatReceipt.append(printTicketString);
  	            request.setAttribute("formatReceipt", formatReceipt.toString());
  	            path = "/jsp/printReceipt.jsp";
			}else{
				request.setAttribute("formatReceipt", "Error in Displaying Ticket.Please Try again Later.");
			}
			path = "/jsp/printReceipt.jsp";
		}
		else if(action.equalsIgnoreCase("emailTicket"))
		{
			String pnrNo = request.getParameter("conPnr");
			String toEmail = request.getParameter("email");
			PropertySupport vrlBus = new PropertySupport("EMail");
			String smtphost = vrlBus.getResource("SmtpHost", "localhost");
			String smtpport = vrlBus.getResource("SmtpPort", "25");
			VRLBusTicketDetailsInfo tktDtlInfo = vrlBusTicketDetailsHelper.getTicketByPNR(pnrNo, userInfo.getUserCode());
			String printTicketString = printTicket(tktDtlInfo);
			if(printTicketString != null){
				StringBuilder formatReceipt = new StringBuilder();
				printTicketString = printTicketString.replaceFirst("\\$bookedBy",isNull(userInfo.getCompanyName()));
				formatReceipt.append(printTicketString);
				Email email = new Email(smtphost, smtpport);
				email.setFrom("help@itzcash.com");
				email.setTo(toEmail);
				email.setSubject("Ticket Reciept");
				email.setTextMessage( formatReceipt.toString());
				email.setContentType("text/html");
				boolean isMailSent = email.sendMail();
				System.out.println("emailTicket::"+pnrNo+":::"+email+":::"+smtphost+":::"+smtpport);
				if(!isMailSent){
					println(ilogger, "EMailStatus:PNR="+pnrNo+",MailSent:"+isMailSent, Logger.INFO);	
				}
			}else{
				request.setAttribute("formatReceipt", "Error in Displaying Ticket.Please Try again Later.");
			}
			path = "/jsp/ticketHistory.jsp";
		}
		/*else if(action.equalsIgnoreCase("bookTempTkt"))
		{
			String tempPNR = request.getParameter("tempPNR");
			VRLBusTicketDetailsInfo tktDtlInfo = vrlBusTicketDetailsHelper.getTempTicketByPNR(tempPNR, userInfo.getUserCode());
			session.removeAttribute("tktDtlInfo");
			if(tktDtlInfo != null ){
				session.setAttribute("tktDtlInfo", tktDtlInfo);
			}else{
				request.setAttribute("msg", "Temp PNR "+tempPNR+" Not Found.");
			}
			path = "/jsp/bookTempTicket.jsp";
		}*/
	}catch (Exception e) {
		e.printStackTrace();
		path = "/jsp/home.jsp";
	}
	
	if(isforward){
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}
}

		
	private String getGenderDesc(String genderCode){
		String gender = "";
		if(genderCode != null){
			if("1".equalsIgnoreCase(genderCode)){
				gender = ",Gender : Male" ;	
			}
			if("2".equalsIgnoreCase(genderCode)){
				gender = ",Gender : Female" ;
			}
		}
		return gender;
	}
	
	private String printTicket(VRLBusTicketDetailsInfo tktDtlInfo){
		String dataRead = null;
		if(tktDtlInfo != null){
			try{
				PropertySupport propertySupport = new PropertySupport("ItzBus");
				VRLBusPassengerDetInfo[] pasngrDetailsInfo = null;
		    	pasngrDetailsInfo = tktDtlInfo.getBusPassengerDetInfos();
		 		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			    InputStream fileStream = getClass().getClassLoader().getResourceAsStream("com/itz/bus/template/pgVRLReceipt.tpl");
		 		byte[] b = new byte[fileStream.available()];
				fileStream.read(b);
	            fileStream.close();
	            dataRead = new String(b);
	            dataRead = dataRead.replaceFirst("\\$printUrl", propertySupport.getResource("printUrl", ""));
	            dataRead = dataRead.replaceFirst("\\$logoUrl", propertySupport.getResource("logoUrl", ""));
	            dataRead = dataRead.replaceFirst("\\$VRLLogoUrl", propertySupport.getResource("VRLLogoUrl", ""));
				dataRead = dataRead.replaceFirst("\\$pnr", isNull(tktDtlInfo.getConfirmPNR()));
	            dataRead = dataRead.replaceFirst("\\$source", isNull(tktDtlInfo.getSource()));
	            dataRead = dataRead.replaceFirst("\\$orderid", isNull(tktDtlInfo.getOrderid()));
	            dataRead = dataRead.replaceFirst("\\$destination", isNull(tktDtlInfo.getDestination()));
	            dataRead = dataRead.replaceFirst("\\$transactionDate", isNull( dateFormat.format(new Date())));
	       	    //dataRead = dataRead.replaceFirst("\\$bookedBy",isNull(userInfo.getCompanyName()));//busType
	            dataRead = dataRead.replaceFirst("\\$busType",isNull(tktDtlInfo.getBustype()));
	            dataRead = dataRead.replaceFirst("\\$totalFare",new java.text.DecimalFormat("0.00").format((double)tktDtlInfo.getTotalfare()/100));
	            dataRead = dataRead.replaceFirst("\\$jrnyDateTime",isNull(tktDtlInfo.getJourneydatetime()));
	            dataRead = dataRead.replaceFirst("\\$boardingpt", isNull(tktDtlInfo.getBoardingptname()+" "+tktDtlInfo.getBoardingpttime()));
		        String psgDtl = formatPsgDtl(pasngrDetailsInfo);
		        dataRead = dataRead.replaceFirst("\\$psgDtl", isNull(psgDtl));    
			}catch (Exception e) {
				e.printStackTrace();
				dataRead = null;
				
			}
		}
		return dataRead;
	}
	
		
	private String isNull(String str){
		
		if(str != null){
			return str;
		}
		return "";
	}
	
	private String formatPsgDtl(VRLBusPassengerDetInfo[] pasngrDetailsInfo) {       
        StringBuilder psgDtls = new StringBuilder();
        for (int i = 0; i < pasngrDetailsInfo.length; i++) {      
        psgDtls.append("<tr><td>");
	     psgDtls.append(i+1);
	     psgDtls.append("</td><td>");
	     psgDtls.append(pasngrDetailsInfo[i].getPassengername());
	     psgDtls.append("</td><td>");
	     psgDtls.append(pasngrDetailsInfo[i].getAge());
	     psgDtls.append("</td><td>");
	     psgDtls.append(pasngrDetailsInfo[i].getGender());
	     psgDtls.append("</td><td>");
	     psgDtls.append(pasngrDetailsInfo[i].getSeatId());
	     psgDtls.append("</td></tr>");
        }
        return psgDtls.toString();
    }
	
	private void println(ILogger ilogger, String s, LogType logtype)
	{
		s = this.getServletName() + " : " + s;
	    if(ilogger != null)
	    	ilogger.println(s, logtype);
	    else
	        System.out.println(s);
	}
}
