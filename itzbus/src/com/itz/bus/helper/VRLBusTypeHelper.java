package com.itz.bus.helper;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import com.itz.bus.info.VRLBusTypeInfo;

import jisp.base.server.IServerContext;
import jisp.base.server.JISPTranHelper;


public class VRLBusTypeHelper extends JISPTranHelper{
	
	private String tableName = "TBLVRLBUSTYPE";

	public VRLBusTypeHelper(IServerContext iservercontext) {
		super(iservercontext);
		// TODO Auto-generated constructor stub
	}
	
	protected String getBaseSelectCondition() {
		String s = " from "+tableName+ "";
		return s;
	}
	
	protected String getBaseSelectParams() {
		String s = " BUSTYPE_ID,BUS_NAME,COLUMNCOUNT,ROWCOUNT";
		return s;
	}
	
	protected Collection getInsertSqls(Object obj) {
		Vector vector = new Vector();
		Object obj1 = null;
		VRLBusTypeInfo vrlBusTypeInfo = (VRLBusTypeInfo)obj;
		String s = "insert into "+tableName+ " (BUSTYPE_ID,BUS_NAME,COLUMNCOUNT,ROWCOUNT) values (" + str(vrlBusTypeInfo.getBusType_ID()) + ", " + str(vrlBusTypeInfo.getBusName()) + ", " + vrlBusTypeInfo.getColumnCount()+ ", " +vrlBusTypeInfo.getRowCount() + " )";
		vector.add(s);
		return vector;
	}

	
	protected Collection getDeleteSqls(Collection collection) {
		Vector vector = new Vector();
		String s = getWithCondition(collection, "or", getFieldAlias());
		String s1 = "delete from "+tableName+ " where " + s;
		vector.add(s1);
		return vector;
	}
	
	protected String getFieldAlias() {
		return "";
	}
	
	protected String getFirstJoinForBaseSelectSql() {
		return super.getFirstJoinForBaseSelectSql();
	}
	
	protected Object getNewObject() {
		return new VRLBusTypeInfo();
	}
	
	protected Object makeObject(Object obj, Iterator iterator) {
		VRLBusTypeInfo vrlBusTypeInfo = (VRLBusTypeInfo)obj;
		Number number = (Number)iterator.next();
		if(number != null)
		vrlBusTypeInfo.setBusType_ID(number.intValue());
		vrlBusTypeInfo.setBusName((String)iterator.next());
		number = (Number)iterator.next();
		if(number != null)
			vrlBusTypeInfo.setColumnCount(number.intValue());
		number = (Number)iterator.next();
		if(number != null)
			vrlBusTypeInfo.setRowCount(number.intValue());
		return vrlBusTypeInfo;
	}
	
	public Collection getCollectionForDetails(Object obj) {
		VRLBusTypeInfo vrlBusTypeInfo = (VRLBusTypeInfo)obj;
		String s = " BUSTYPE_ID = "+vrlBusTypeInfo.getBusType_ID();
		return getCollectionWithCondition(s);
	}
	
	public VRLBusTypeInfo getBusTypeDetails(Object obj) {
		Collection coll = this.getCollectionForDetails(obj);
		int i = 0;
		VRLBusTypeInfo vrlBusTypeInfo = null;
		if (coll != null && !coll.isEmpty()) {
			for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
				vrlBusTypeInfo = new VRLBusTypeInfo();
				vrlBusTypeInfo = (VRLBusTypeInfo) iterator.next();
			}
		}
		return vrlBusTypeInfo;
	}

}
