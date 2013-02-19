package com.itz.bus.info;

import java.util.Date;

public class VRLBusTicketDetailsInfo {
	private String orderid;
	private String source;
	private String destination;
	private int sourceId;
	private int destinationId;
	private int journeyid;
	private int originalfare;
	private int totalfare;
	private int pgcharges;
	private String journeydatetime;
	private String bustype;
	private int  boardingptid;
	private String boardingptname;
	private String boardingpttime;
	private String mobileno;
	private String emailid;
	private String pgid;
	private String tempPNR;
	private String confirmPNR;
	private String status;
	private String bookedby;
	private String bookingpoint;
	private String requestdate;
	private VRLBusPassengerDetInfo[] busPassengerDetInfos;
	private String cnrNo;
	private Date cancellationDate;
	private String cancelledBy;
	private int refundAmount;
	/**
	 * @return the orderid
	 */
	public String getOrderid() {
		return orderid;
	}
	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the sourceId
	 */
	public int getSourceId() {
		return sourceId;
	}
	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	/**
	 * @return the destinationId
	 */
	public int getDestinationId() {
		return destinationId;
	}
	/**
	 * @param destinationId the destinationId to set
	 */
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}
	/**
	 * @return the journeyid
	 */
	public int getJourneyid() {
		return journeyid;
	}
	/**
	 * @param journeyid the journeyid to set
	 */
	public void setJourneyid(int journeyid) {
		this.journeyid = journeyid;
	}
	/**
	 * @return the originalfare
	 */
	public int getOriginalfare() {
		return originalfare;
	}
	/**
	 * @param originalfare the originalfare to set
	 */
	public void setOriginalfare(int originalfare) {
		this.originalfare = originalfare;
	}
	/**
	 * @return the totalfare
	 */
	public int getTotalfare() {
		return totalfare;
	}
	/**
	 * @param totalfare the totalfare to set
	 */
	public void setTotalfare(int totalfare) {
		this.totalfare = totalfare;
	}
	/**
	 * @return the pgcharges
	 */
	public int getPgcharges() {
		return pgcharges;
	}
	/**
	 * @param pgcharges the pgcharges to set
	 */
	public void setPgcharges(int pgcharges) {
		this.pgcharges = pgcharges;
	}
	/**
	 * @return the journeydatetime
	 */
	public String getJourneydatetime() {
		return journeydatetime;
	}
	/**
	 * @param journeydatetime the journeydatetime to set
	 */
	public void setJourneydatetime(String journeydatetime) {
		this.journeydatetime = journeydatetime;
	}
	/**
	 * @return the bustype
	 */
	public String getBustype() {
		return bustype;
	}
	/**
	 * @param bustype the bustype to set
	 */
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}
	/**
	 * @return the boardingptid
	 */
	public int getBoardingptid() {
		return boardingptid;
	}
	/**
	 * @param boardingptid the boardingptid to set
	 */
	public void setBoardingptid(int boardingptid) {
		this.boardingptid = boardingptid;
	}
	/**
	 * @return the boardingptname
	 */
	public String getBoardingptname() {
		return boardingptname;
	}
	/**
	 * @param boardingptname the boardingptname to set
	 */
	public void setBoardingptname(String boardingptname) {
		this.boardingptname = boardingptname;
	}
	/**
	 * @return the boardingpttime
	 */
	public String getBoardingpttime() {
		return boardingpttime;
	}
	/**
	 * @param boardingpttime the boardingpttime to set
	 */
	public void setBoardingpttime(String boardingpttime) {
		this.boardingpttime = boardingpttime;
	}
	/**
	 * @return the mobileno
	 */
	public String getMobileno() {
		return mobileno;
	}
	/**
	 * @param mobileno the mobileno to set
	 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}
	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	/**
	 * @return the pgid
	 */
	public String getPgid() {
		return pgid;
	}
	/**
	 * @param pgid the pgid to set
	 */
	public void setPgid(String pgid) {
		this.pgid = pgid;
	}
	/**
	 * @return the tempPNR
	 */
	public String getTempPNR() {
		return tempPNR;
	}
	/**
	 * @param tempPNR the tempPNR to set
	 */
	public void setTempPNR(String tempPNR) {
		this.tempPNR = tempPNR;
	}
	/**
	 * @return the confirmPNR
	 */
	public String getConfirmPNR() {
		return confirmPNR;
	}
	/**
	 * @param confirmPNR the confirmPNR to set
	 */
	public void setConfirmPNR(String confirmPNR) {
		this.confirmPNR = confirmPNR;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the bookedby
	 */
	public String getBookedby() {
		return bookedby;
	}
	/**
	 * @param bookedby the bookedby to set
	 */
	public void setBookedby(String bookedby) {
		this.bookedby = bookedby;
	}
	/**
	 * @return the bookingpoint
	 */
	public String getBookingpoint() {
		return bookingpoint;
	}
	/**
	 * @param bookingpoint the bookingpoint to set
	 */
	public void setBookingpoint(String bookingpoint) {
		this.bookingpoint = bookingpoint;
	}
	/**
	 * @return the requestdate
	 */
	public String getRequestdate() {
		return requestdate;
	}
	/**
	 * @param requestdate the requestdate to set
	 */
	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}
	/**
	 * @return the busPassengerDetInfos
	 */
	public VRLBusPassengerDetInfo[] getBusPassengerDetInfos() {
		return busPassengerDetInfos;
	}
	/**
	 * @param busPassengerDetInfos the busPassengerDetInfos to set
	 */
	public void setBusPassengerDetInfos(
			VRLBusPassengerDetInfo[] busPassengerDetInfos) {
		this.busPassengerDetInfos = busPassengerDetInfos;
	}
	/**
	 * @return the cnrNo
	 */
	public String getCnrNo() {
		return cnrNo;
	}
	/**
	 * @param cnrNo the cnrNo to set
	 */
	public void setCnrNo(String cnrNo) {
		this.cnrNo = cnrNo;
	}
	/**
	 * @return the cancellationDate
	 */
	public Date getCancellationDate() {
		return cancellationDate;
	}
	/**
	 * @param cancellationDate the cancellationDate to set
	 */
	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}
	/**
	 * @return the cancelledBy
	 */
	public String getCancelledBy() {
		return cancelledBy;
	}
	/**
	 * @param cancelledBy the cancelledBy to set
	 */
	public void setCancelledBy(String cancelledBy) {
		this.cancelledBy = cancelledBy;
	}
	/**
	 * @return the refundAmount
	 */
	public int getRefundAmount() {
		return refundAmount;
	}
	/**
	 * @param refundAmount the refundAmount to set
	 */
	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	
}
