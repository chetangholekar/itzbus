package com.itz.bus.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import jisp.base.report.server.DefaultReportContext;
import jisp.base.report.server.ReportContextProvider;
import jisp.base.web.server.WebContextProvider;
import jisp.base.web.server.WebInitializationServlet;

public class ItzBusInitializationServlet extends WebInitializationServlet
{
	 public ItzBusInitializationServlet()
	 {
	 }

	 protected WebContextProvider getWebContextProvider()
	 {
		 return new ReportContextProvider("ItzBus");
	 }

	 public void init(ServletConfig servletconfig)
	 	throws ServletException
	 {
		 super.init(servletconfig);
	 }

	 public void postinit()
	 {
		 DefaultReportContext defaultreportcontext = (DefaultReportContext)getServletContext().getAttribute("WebContext");
		 Collection collection = defaultreportcontext.getLoadedServices();
	     Iterator iterator = collection.iterator();
	     Vector vector = new Vector();
	     for(; iterator.hasNext(); vector.add(iterator.next()));
	     defaultreportcontext.setSelectedServices(vector);
	 }
}
