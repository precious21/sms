package com.momentumTech.rms.springmvc.dto;

import java.util.Date;

import com.momentumTech.rms.springmvc.domain.RmsFoodTypeDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitMenuPlaneDomain;


public class RmsGuestDto {

	  private String guestId;
	 
	  private String guestCode;
	 
	  private String guestName;
	 
	  private String fatherName;
	 
	  private String gender;
	 
	  private String contactNo;
	 
	  private String roomNo;
	 
	  private String cnic;
	 
	  private String guestStatus;
	 
	  private Date regDate;
	 
	  private String clientID;

	  private String userId;

	  private String createdBy;

	  private Date createdOn;

	  private String updatedBy;

	  private Date updatedOn;
	  
	  private RmsVisitDomain rmsVisitDomain;
	  
	  private RmsFoodTypeDomain rmsFoodTypeDomain;
	  
	  private String breakFast;
	  
	  private String lunch;
	  
	  private String dinner;
	  
      private String breakFastRemainig;
	  
	  private String lunchRemaining;
	  
	  private String dinnerRemaining;
	  
	  private String tmpVisitId;
	  
	  private RmsVisitMenuPlaneDomain rmsVisitMenuPlaneDomain;
	  
	  private String tmpCheckIn;
	  
	  private String tmpCheckOut;
	   
	  private String tmpFoodTypeName;
	  
	  private String tmpQuantity;
	  
	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	public String getGuestCode() {
		return guestCode;
	}

	public void setGuestCode(String guestCode) {
		this.guestCode = guestCode;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

	public String getGuestStatus() {
		return guestStatus;
	}

	public void setGuestStatus(String guestStatus) {
		this.guestStatus = guestStatus;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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

	public RmsVisitDomain getRmsVisitDomain() {
		return rmsVisitDomain;
	}

	public void setRmsVisitDomain(RmsVisitDomain rmsVisitDomain) {
		this.rmsVisitDomain = rmsVisitDomain;
	}

	public RmsFoodTypeDomain getRmsFoodTypeDomain() {
		return rmsFoodTypeDomain;
	}

	public void setRmsFoodTypeDomain(RmsFoodTypeDomain rmsFoodTypeDomain) {
		this.rmsFoodTypeDomain = rmsFoodTypeDomain;
	}

	public String getBreakFast() {
		return breakFast;
	}

	public void setBreakFast(String breakFast) {
		this.breakFast = breakFast;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	public String getBreakFastRemainig() {
		return breakFastRemainig;
	}

	public void setBreakFastRemainig(String breakFastRemainig) {
		this.breakFastRemainig = breakFastRemainig;
	}

	public String getLunchRemaining() {
		return lunchRemaining;
	}

	public void setLunchRemaining(String lunchRemaining) {
		this.lunchRemaining = lunchRemaining;
	}

	public String getDinnerRemaining() {
		return dinnerRemaining;
	}

	public void setDinnerRemaining(String dinnerRemaining) {
		this.dinnerRemaining = dinnerRemaining;
	}

	public String getTmpVisitId() {
		return tmpVisitId;
	}

	public void setTmpVisitId(String tmpVisitId) {
		this.tmpVisitId = tmpVisitId;
	}

	public RmsVisitMenuPlaneDomain getRmsVisitMenuPlaneDomain() {
		return rmsVisitMenuPlaneDomain;
	}

	public void setRmsVisitMenuPlaneDomain(RmsVisitMenuPlaneDomain rmsVisitMenuPlaneDomain) {
		this.rmsVisitMenuPlaneDomain = rmsVisitMenuPlaneDomain;
	}

	public String getTmpCheckIn() {
		return tmpCheckIn;
	}

	public void setTmpCheckIn(String tmpCheckIn) {
		this.tmpCheckIn = tmpCheckIn;
	}

	public String getTmpCheckOut() {
		return tmpCheckOut;
	}

	public void setTmpCheckOut(String tmpCheckOut) {
		this.tmpCheckOut = tmpCheckOut;
	}

	public String getTmpFoodTypeName() {
		return tmpFoodTypeName;
	}

	public void setTmpFoodTypeName(String tmpFoodTypeName) {
		this.tmpFoodTypeName = tmpFoodTypeName;
	}

	public String getTmpQuantity() {
		return tmpQuantity;
	}

	public void setTmpQuantity(String tmpQuantity) {
		this.tmpQuantity = tmpQuantity;
	}
}
