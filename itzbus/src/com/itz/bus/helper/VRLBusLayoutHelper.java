package com.itz.bus.helper;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import com.itz.bus.info.VRLBusLayoutInfo;

import jisp.base.server.IServerContext;
import jisp.base.server.JISPTranHelper;


public class VRLBusLayoutHelper extends JISPTranHelper{
	
	private String tableName = "TBLVRLBUSLAYOUT";

	public VRLBusLayoutHelper(IServerContext iservercontext) {
		super(iservercontext);
		// TODO Auto-generated constructor stub
	}
	
	protected String getBaseSelectCondition() {
		String s = " from "+tableName+ "";
		return s;
	}
	
	protected String getBaseSelectParams() {
		String s = " ID,BUSTYPE_ID,BUSSEAT_ID,SEAT_NO,SEAT_TYPE,WINDOW,BUSROW,BUSCOLUMN ";
		return s;
	}
	
	protected Collection getInsertSqls(Object obj) {
		Vector vector = new Vector();
		Object obj1 = null;
		VRLBusLayoutInfo vrlBusLayoutInfo = (VRLBusLayoutInfo)obj;
		String s = "insert into "+tableName+ " (ID,BUSTYPE_ID,BUSSEAT_ID,SEAT_NO,SEAT_TYPE,WINDOW,BUSROW,BUSCOLUMN) values (" + vrlBusLayoutInfo.getId() + "," + vrlBusLayoutInfo.getBusTypeId() + ", " + vrlBusLayoutInfo.getSeatId()+ ", " +vrlBusLayoutInfo.getSeatNo() + ", " +str(vrlBusLayoutInfo.getSeatType())+ ", "+str(vrlBusLayoutInfo.getWindow()) + ", " +vrlBusLayoutInfo.getBusRow()+ ", "+vrlBusLayoutInfo.getBusColumn()+ " )";
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
		return new VRLBusLayoutInfo();
	}
	
	protected Object makeObject(Object obj, Iterator iterator) {
		VRLBusLayoutInfo vrlBusLayoutInfo = (VRLBusLayoutInfo)obj;
		Number number = (Number)iterator.next();
		if(number != null)
			vrlBusLayoutInfo.setId(number.intValue());
		number = (Number)iterator.next();
		if(number != null)
			vrlBusLayoutInfo.setBusTypeId(number.intValue());
		vrlBusLayoutInfo.setSeatId((String)iterator.next());
		number = (Number)iterator.next();
		if(number != null)
			vrlBusLayoutInfo.setSeatNo(number.intValue());
		vrlBusLayoutInfo.setSeatType((String)iterator.next());
		vrlBusLayoutInfo.setWindow((String)iterator.next());
		number = (Number)iterator.next();
		if(number != null)
			vrlBusLayoutInfo.setBusRow(number.intValue());
		number = (Number)iterator.next();
		if(number != null)
			vrlBusLayoutInfo.setBusColumn(number.intValue());
		return vrlBusLayoutInfo;
	}
	
	public Collection getCollectionForDetails(Object obj) {
		VRLBusLayoutInfo vrlBusLayoutInfo = (VRLBusLayoutInfo)obj;
		String s = " BUSTYPE_ID = "+vrlBusLayoutInfo.getBusTypeId()+" order by BUSROW,BUSCOLUMN asc";
		return getCollectionWithCondition(s);
	}
	
	public VRLBusLayoutInfo[] getBusLayoutDetails(Object obj) {
		Collection coll = this.getCollectionForDetails(obj);
		int i = 0;
		VRLBusLayoutInfo[] vrlBusLayoutInfos = new VRLBusLayoutInfo[coll.size()];
		if (coll != null && !coll.isEmpty()) {
			for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
				vrlBusLayoutInfos[i] = new VRLBusLayoutInfo();
				vrlBusLayoutInfos[i] = (VRLBusLayoutInfo) iterator.next();
				i++;
			}
		}
		return vrlBusLayoutInfos;
	}

}
