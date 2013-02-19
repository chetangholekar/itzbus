package com.itz.bus.server;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jisp.base.report.server.IReportContext;


import com.itz.bus.info.UserInfo;
import com.itz.bus.info.VRLBusPassengerDetInfo;
import com.itz.bus.info.VRLBusTicketDetailsInfo;

import eleclipse.util.PropertySupport;
import eleclipse.util.log.ILogger;

/**
 * Servlet implementation class VRLTicketReceiptServlet
 */
public class VRLTicketReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VRLTicketReceiptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside VRLTicketReceiptServlet ******"); 
		HttpSession session = request.getSession(false);
	    IReportContext ireportcontext = (IReportContext)getServletContext().getAttribute("WebContext");
	   
	    ILogger ilogger = ireportcontext.getLogger();
	    String path = "";
	    InputStream fileStream = null;
	    
	    
	    VRLBusPassengerDetInfo[] pasngrDetailsInfo = null;
	    VRLBusTicketDetailsInfo tktDtlInfo =  (VRLBusTicketDetailsInfo)session.getAttribute("tktDtlInfo");
	    UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
	    
	    try{
	    	String dataRead = null;
	    	StringBuilder formatReceipt = new StringBuilder();
	    	if(tktDtlInfo != null){
	    		
	    		pasngrDetailsInfo = tktDtlInfo.getBusPassengerDetInfos();
     				PropertySupport propertySupport = new PropertySupport("ItzBus");
     			    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    		    fileStream = getClass().getClassLoader().getResourceAsStream("com/itz/bus/template/pgVRLReceipt.tpl");
     				byte[] b = new byte[fileStream.available()];
     				fileStream.read(b);
     	            fileStream.close();
     	            dataRead = new String(b);
     	            dataRead = dataRead.replaceFirst("\\$printUrl", propertySupport.getResource("printUrl", ""));
    	            dataRead = dataRead.replaceFirst("\\$logoUrl", propertySupport.getResource("logoUrl", ""));
    	            dataRead = dataRead.replaceFirst("\\$VRLLogoUrl", propertySupport.getResource("VRLLogoUrl", ""));
					//for() TO DO passengerName,seatNo
     	                 	            
    	           dataRead = dataRead.replaceFirst("\\$pnr", isNull(tktDtlInfo.getConfirmPNR()));
     	           dataRead = dataRead.replaceFirst("\\$source", isNull(tktDtlInfo.getSource()));
    	           dataRead = dataRead.replaceFirst("\\$orderid", isNull(tktDtlInfo.getOrderid()));
    	           dataRead = dataRead.replaceFirst("\\$destination", isNull(tktDtlInfo.getDestination()));
    	           dataRead = dataRead.replaceFirst("\\$transactionDate", isNull( dateFormat.format(new Date())));
    	       	   dataRead = dataRead.replaceFirst("\\$bookedBy",isNull(userInfo.getCompanyName()));//busType
    	           dataRead = dataRead.replaceFirst("\\$busType",isNull(tktDtlInfo.getBustype()));
    	           dataRead = dataRead.replaceFirst("\\$totalFare",new java.text.DecimalFormat("0.00").format((double)tktDtlInfo.getTotalfare()/100));
    	           dataRead = dataRead.replaceFirst("\\$jrnyDateTime",isNull(tktDtlInfo.getJourneydatetime()));    	  
    	           dataRead = dataRead.replaceFirst("\\$boardingpt", isNull(tktDtlInfo.getBoardingptname()+" "+tktDtlInfo.getBoardingpttime()));
    	            
    	           String psgDtl = formatPsgDtl(pasngrDetailsInfo);
    	           dataRead = dataRead.replaceFirst("\\$psgDtl", isNull(psgDtl));    	                 	           
     	            
     	           formatReceipt.append(dataRead);
     	           request.setAttribute("formatReceipt", formatReceipt.toString());
     	         path = "/jsp/printReceipt.jsp";
     	
     		}
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally{
	    	if(fileStream != null)
	        {
	             try
	             {
	                 fileStream.close();
	             }
	             catch (IOException ioEx)
	             {
	            	 ioEx.printStackTrace();
	             }
	        }
	    }
	    
	    RequestDispatcher requestdispatcher = request.getRequestDispatcher(path);
	    requestdispatcher.forward(request, response);
	
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

}
