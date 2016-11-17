package com.momentumTech.rms.springmvc.dto;

import java.util.Date;

import com.momentumTech.rms.springmvc.domain.RmsGuestDomain;

public class RmsVisitDto {

	  private String visitId;
	
	  private RmsGuestDomain rmsGuestDomain;
	 
	  private Date checkIn;
	 
	  private Date checkOut;
	 
	  private Date visitClosingDate;
	 
	  private boolean visitStatus;
	 
	  private String clientID;

	  private String userId;

	  private String createdBy;

	  private Date createdOn;

	  private String updatedBy;

	  private Date updatedOn;

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public RmsGuestDomain getRmsGuestDomain() {
		return rmsGuestDomain;
	}

	public void setRmsGuestDomain(RmsGuestDomain rmsGuestDomain) {
		this.rmsGuestDomain = rmsGuestDomain;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public Date getVisitClosingDate() {
		return visitClosingDate;
	}

	public void setVisitClosingDate(Date visitClosingDate) {
		this.visitClosingDate = visitClosingDate;
	}

	public boolean isVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(boolean visitStatus) {
		this.visitStatus = visitStatus;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
}
