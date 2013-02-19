package com.itz.bus.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itz.bus.info.UserInfo;

import jisp.base.DealerInfo;
import jisp.base.MultipleAddressInfo;
import jisp.base.report.server.IReportContext;
import jisp.base.report.server.ReportContextProvider;
import jisp.base.server.DealerHelper;
import jisp.base.server.IServerContext;

import eleclipse.util.PropertySupport;
import eleclipse.util.log.ILogger;
import eleclipse.util.log.LogType;

public class ItzBusRedirectionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public ItzBusRedirectionServlet()
	{
	}
	
	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException
	 {
		 String dealerCode = "";
		 String receivedHash ="";
		 String generatedHash = "";
		 String state="";
		 String city = "";
		 String pinCode = "";	
		 String orderId = "";
		 boolean matchedIP = false;
		 String path = "/jsp/applicationError.jsp";
		 Enumeration  params=request.getParameterNames();
		 PrintWriter out=response.getWriter();
		 IReportContext ireportcontext = (IReportContext)getServletContext().getAttribute("WebContext");
		 ILogger  ilogger = ireportcontext.getLogger();
		 while(params.hasMoreElements())
		 {
			 String param=(String)params.nextElement();
		     String values[]=request.getParameterValues(param);
		     if (param.equals("dlrcode"))
		     {
		    	 dealerCode = (String)values[0];
		     }
		     else if (param.equals("checksum"))
		     {
		    	receivedHash = (String)values[0];
		     }
		     else if (param.equals("state"))
		     {
		    	 state = (String)values[0];
		     }
		     else if (param.equals("city"))
		     {
		    	city = (String)values[0];
		     }
		     else if (param.equals("pincode"))
		     {
		    	pinCode = (String)values[0];
		     }
		     else if (param.equals("orderid"))
		     {
		    	orderId = (String)values[0];
		     }
	     }
		
		 String input ="state="+state+"&city="+city+"&pincode="+pinCode+"&orderid="+orderId;
		 String ipaddress = request.getRemoteAddr();
		 PropertySupport prBus = new PropertySupport("ItzBus");
		 String validIPList = prBus.getResource("IPList", "");
		 String secretKey = prBus.getResource("SharedSecret", "");
		 /*StringTokenizer iplist = new StringTokenizer(validIPList, ",");
		 while (iplist.hasMoreElements()) {
			if (ipaddress.equals(iplist.nextElement())) {
				matchedIP = true;
				break;
			}
		 }
*/		 if(true) //No IP Check Required As IT will give cutomer IP
	    // if(matchedIP)
	     {
	    	Date currentdate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
			String salt = secretKey+sdf.format(currentdate);
	    	generatedHash = this.getBasicHash(salt, input);
	    	System.out.println("Generated Hash "+generatedHash);
	    	System.out.println("Received Hash "+receivedHash);
	    	if(generatedHash.equalsIgnoreCase(receivedHash))
	    	{
	    		
	    		UserInfo userInfo = new UserInfo();
	    		userInfo.setUserCode(dealerCode);
	    		/*IServerContext serverContext = new ReportContextProvider("CVMSUser").getWebContext();
	    		//DealerHelper dealerHelper = new DealerHelper(ireportcontext);
*/	    		DealerHelper dealerHelper = new DealerHelper(ireportcontext);
	    		Collection coll = dealerHelper.getDealerById(dealerCode);
	    	    DealerInfo info = null;
	    		if(coll != null && !coll.isEmpty())
	    		{
	    			for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
	    				info = new DealerInfo();
	    				info= (DealerInfo)iterator.next();
	    			}
	    		}
	    		
	    		if(info != null){
	    			userInfo.setUserCode(info.getDealerId());
	    			userInfo.setCompanyName(info.getCompanyName());
	    			userInfo.setFirstName(info.getFirstName());
	    			userInfo.setLastName(info.getLastName());
	    			userInfo.setAddressInfo(info.getAddressInfo());
	    			//MultipleAddressInfo addressInfo = info.getAddressInfo();
	    			HttpSession session = request.getSession();
		    		//Checking 
		    		// Will use /dev/urandom (NativePRNG) on Linux but will use SHA1PRNG on Windows
		    		SecureRandom random = new SecureRandom();
		    		byte bytes[] = new byte[20]; // 20 bytes = 160-bit
		    		random.nextBytes(bytes);
		    		// Above 3 lines go together and are needed for seeding the SecureRandom
		    		long oldvalue = random.nextLong();
		    		request.setAttribute("itzoldsessionvalue", "" + oldvalue);
		    		session.setAttribute("itzoldsessionvalue", "" + oldvalue);
		    		long newvalue = random.nextLong();
		    		request.setAttribute("itznewsessionvalue", "" + newvalue);
		    		session.setAttribute("itznewsessionvalue", "" + newvalue);
		    		session.setAttribute("itzcurrentlocation", "Login");
		    		//checking 
		    		
		    		session.setAttribute("userInfo", userInfo);
		    		
		    		path = "/jsp/home.jsp";
	    			
	    		}else{
	    			request.setAttribute("msg", "Error in Processing Dealer Data.Please try again later. : ");
	    			path = "/jsp/applicationError.jsp";
	    		}
	    		
	    	}
	    	else
	    	{
	    		request.setAttribute("msg", "you are not authorized to process this request");
	    		println(ilogger, "Checksum Error IP : " + ipaddress + " , DealerCode : " + dealerCode ,LogType.ERROR);
	    		path = "/jsp/applicationError.jsp";
	    	}
	    }
	    else
	    {
	    	request.setAttribute("msg", "you are not authorized to process this request");
	    	println(ilogger, "Unauthorized access IP : " + ipaddress + " , DealerCode : " + dealerCode ,LogType.ERROR);
	    	path = "/jsp/applicationError.jsp";
	    }
	    RequestDispatcher requestdispatcher = request.getRequestDispatcher(path);
 		requestdispatcher.forward(request, response);
	}
	 
	public synchronized String getBasicHash(String salt,String text)
	{
		String hash = null;
		String salted = salt + text;
		byte[] defaultBytes = salted.getBytes();
		try
		{
		    MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(defaultBytes);
			byte messageDigest[] = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i=0;i<messageDigest.length;i++) {
				//hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1) {
				    // could use a for loop, but we're only dealing with a single byte
				    hexString.append('0');
				}
				hexString.append(hex);
			}
			hash = hexString.toString();
		}
		catch(NoSuchAlgorithmException e)
	    {
	      System.out.println(e.getMessage());
	    }
	    return hash;
    }
	
	private void println(ILogger ilogger, String s, LogType logtype)
	{
		String servletName = getServletName() + ":";
		s = servletName + s;
		if (ilogger != null)
			ilogger.println(s, logtype);
		else
			System.out.println(s);
	}
}
