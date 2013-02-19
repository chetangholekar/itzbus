package com.itz.bus.info;

/**
 * 
 * @author Nimisha Gosai
 * @since 17/01/2013
 *
 */
public class VRLBusTypeInfo {

	private int busType_ID;
	private String busName;
	private int rowCount;
	private int columnCount;
	/**
	 * @return the busType_ID
	 */
	public int getBusType_ID() {
		return busType_ID;
	}
	/**
	 * @param busTypeID the busType_ID to set
	 */
	public void setBusType_ID(int busTypeID) {
		busType_ID = busTypeID;
	}
	/**
	 * @return the busName
	 */
	public String getBusName() {
		return busName;
	}
	/**
	 * @param busName the busName to set
	 */
	public void setBusName(String busName) {
		this.busName = busName;
	}
	/**
	 * @return the rowCount
	 */
	public int getRowCount() {
		return rowCount;
	}
	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	/**
	 * @return the columnCount
	 */
	public int getColumnCount() {
		return columnCount;
	}
	/**
	 * @param columnCount the columnCount to set
	 */
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}
	
	
}
