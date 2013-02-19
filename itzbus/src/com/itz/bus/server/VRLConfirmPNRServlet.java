package com.itz.bus.server;

import in.vrllogistics.www.webs.WS.Confirm_booking;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jisp.base.report.server.IReportContext;
import jisp.cvms.DataValidation;
import jisp.cvms.RequestProcessing;
import jisp.paymentgw.PaymentGatewayResponseCodes;

import com.itz.bus.helper.VRLBusTicketDetailsHelper;
import com.itz.bus.info.VRLBusTicketDetailsInfo;
import com.itz.bus.util.VRLConstant;
import com.itz.bus.ws.VRLBusServices;

import eleclipse.util.PropertySupport;
import eleclipse.util.log.ILogger;
import eleclipse.util.log.LogType;

/**
 * Servlet implementation class VRLConfirmPNRServlet
 */
public class VRLConfirmPNRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataValidation dv = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VRLConfirmPNRServlet() {
    	dv = new DataValidation();
        // TODO Auto-generated constructor stub
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
			long newValue = Long.parseLong((request.getParameter("confirmPNRToken")));
			long oldValue = session.getAttribute("confirmPNRToken") == null ? 0: ((Long) session.getAttribute("confirmPNRToken")).longValue();
			if (oldValue != newValue) 
			{
				sessioncheck = true;
				session.setAttribute("confirmPNRToken",newValue);
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
		IReportContext ireportcontext = (IReportContext)getServletContext().getAttribute("WebContext");
		
		ILogger ilogger = ireportcontext.getLogger();
		String path = "";
		String tempPNR = "";
		String orderid = "";
		String pgTxnID = "";
		
		String reply = "";
		int responsecode = 0;
		VRLBusTicketDetailsHelper ticketDetail = new VRLBusTicketDetailsHelper(ireportcontext);
		VRLBusServices  vrlWS = new VRLBusServices();
		RequestProcessing rp = new RequestProcessing();
		PropertySupport vrlBus = new PropertySupport("ItzBus");
		
		//tempPNR = (String)session.getAttribute("tempPNR");
		//orderid = (String)session.getAttribute("orderid");
		//pgTxnID = (String)session.getAttribute("pgTxnID");
		
		
		String accountno = request.getParameter("accountno");
		String accpassword = request.getParameter("accpassword");
		String merchanttypekey = vrlBus.getResource("MerchantKey","");
		String paymentClientURL = vrlBus.getResource("PaymentClientURL","");
		
		String action = request.getParameter("confirmpnr");
		if(action != null){
			if(action.equalsIgnoreCase("confirmPNR")){
				 
				if (dv.validateAccountNo(accountno) && dv.validatePassword(accpassword)) {
					VRLBusTicketDetailsInfo detailsInfo = (VRLBusTicketDetailsInfo)session.getAttribute("tktDtlInfo");
					String debugString = detailsInfo.getTempPNR()+":"+detailsInfo.getOrderid();
						if(detailsInfo != null){
							orderid = detailsInfo.getOrderid();
							 double originalFare = detailsInfo.getOriginalfare();
							 double totalFare = detailsInfo.getTotalfare();
							 String s_paramString =  "orderid=" + detailsInfo.getOrderid() +
								"&merchanttypekey="+merchanttypekey+"&accountno="+accountno
								+"&password="+accpassword
								+"&productcost="+new Double(totalFare).intValue();
							    reply = rp.processRequest(paymentClientURL, s_paramString);
								String[] pgResponse = reply.split(",");
								//if(pgResponse.length > 0)
						        responsecode = Integer.parseInt(pgResponse[0]);
								if(responsecode == 0)
						        {
									String pOrderid = pgResponse[1];
									String pOriginalAmt = pgResponse[2];
									String pDesc = pgResponse[3];
									pgTxnID = pgResponse[4];
									String balance = "";
									String expiryDate = "";			
									System.out.println("responsecode["+responsecode+"],pOrderid["+pOrderid+"],pOriginalAmt["+pOriginalAmt+"],description["
									 			+pDesc+"[,pgTxnID ["+pgTxnID+"],balance["+balance+"],expiryDate["+expiryDate+"]");
									
									tempPNR = detailsInfo.getTempPNR();
									Confirm_booking confirmBooking = vrlWS.confirmBooking(tempPNR);
									if(confirmBooking != null &&  confirmBooking.getResponse_code() == VRLConstant.SUCCESS)
									{
					        	 		int confResoCode = confirmBooking.getResponse_code();
					        	 		println(ilogger, "VRL Response "+confResoCode+",rderid"+pOrderid+",OriginalAmt"+pOriginalAmt+",TempPNR"+tempPNR, LogType.INFO);
					        	 		String confirmPNR = confirmBooking.getPnr_no();
					        	 		int result =  ticketDetail.updateConfirmedPNR(confirmPNR,"S", orderid,pgTxnID);
					   				    if(result == 1){
					   				    	request.setAttribute("success","Confirmed PNR "+confirmPNR+", Order id - "+orderid+", PG Id "+pgTxnID);
					   				    	println(ilogger, "VRL-SUCCSS:"+debugString+","+confirmPNR+","+pgTxnID, LogType.INFO);
					   				    }else{
					   				    	request.setAttribute("msg","Update Error - Confirmed PNR "+confirmPNR+", Order id - "+orderid+", PG Id "+pgTxnID);
					   				    	println(ilogger, "VRL-SUCCSS UPDATE ERROR:"+result+","+debugString+","+confirmPNR+","+pgTxnID, LogType.INFO);
					   				    }
					   				 
					   				    detailsInfo.setConfirmPNR(confirmPNR);
					   				    session.removeAttribute("tktDtlInfo");
					   				    session.setAttribute("tktDtlInfo", detailsInfo);
					   				    path = "/jsp/bookTicketReceipt.jsp";
				   			        }
				   			 else{
				   				  //call instant Refund here 
			   				 	String refundURL = vrlBus.getResource("RefundURL",""); 
						        int refund = detailsInfo.getTotalfare();
								s_paramString = "amount=" +refund+"&transactionid=" + pgTxnID+"&merchanttypekey=" + merchanttypekey + 
						        "&orderid=" + detailsInfo.getOrderid()+
						        "&type=F&description=Refunded since transaction cancel ticket with VRL booking";
						        println(ilogger, "RefundParams:"+s_paramString+","+debugString, LogType.INFO);
						        System.out.println( "s_paramString = "+s_paramString);
						        String refundReply = rp.processRequest(refundURL, s_paramString);
						        StringTokenizer  res = new StringTokenizer(refundReply, ",");            
						        responsecode = Integer.parseInt((String)res.nextElement());	                    
						        if(responsecode == 0)
						        {
						        	VRLBusTicketDetailsHelper vrlBusTicketDetailsHelper = new VRLBusTicketDetailsHelper(ireportcontext);
						        	int update = vrlBusTicketDetailsHelper.updateTicketOnFailure(detailsInfo.getOrderid());
									if(update == 1)
									{
										request.setAttribute("msg", "Ticket not booked.Amount deducted will be credited back to your card shortly.");
									    path = "/jsp/home.jsp";
						        	
									}else{
										println(ilogger, "Refund error,deducted amount will revert shortly.Order Id : "+detailsInfo.getOrderid(),LogType.INFO);
										request.setAttribute("msg", "Your refund request cannot be processed at this time.Amount deducted will be credited back to your card shortly.");
									}
						        }
						   	 	else
						   	 	{	   	 		
						   	 		request.setAttribute("msg", PaymentGatewayResponseCodes.getResponseLongDescription(responsecode));
						   	 		path = "/jsp/home.jsp";   	 		
						        } 
			   				   //End instant Refund Here
				   		     }
					    }else
				        {
							request.setAttribute("msg",PaymentGatewayResponseCodes.getResponseLongDescription(responsecode));
							path = "/jsp/confirmPNR.jsp";
							println(ilogger, "PG Response Code "+debugString,LogType.ERROR);
				        }
				    }
					else
			        {
						println(ilogger, "VRLBusTicketDetailsInfo null "+debugString,LogType.ERROR);
						request.setAttribute("msg","Error Processing Your Request.Please Try again Later");
						path = "/jsp/home.jsp";
						
			        }
				}else{
					request.setAttribute("msg","Invalid Input Details");
					path = "/jsp/confirmPNR.jsp";
				}
			}
		} else{
			request.setAttribute("msg","Error Processing Your Request.Please Try again Later");
			path = "/jsp/home.jsp";
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
