package com.momentumTech.rms.springmvc.dto;

import java.util.Date;

public class RmsFoodTypeDto {

	  private String foodTypeId;
	 
	  private String foodTypeName;
	 
	  private String description;
	 
	  private Date foodTimeFrom;
	 
	  private Date foodTimeTo;
	 
	  private String clientID;

	  private String userId;

	  private String createdBy;

	  private Date createdOn;

	  private String updatedBy;

	  private Date updatedOn;

	public String getFoodTypeId() {
		return foodTypeId;
	}

	public void setFoodTypeId(String foodTypeId) {
		this.foodTypeId = foodTypeId;
	}

	public String getFoodTypeName() {
		return foodTypeName;
	}

	public void setFoodTypeName(String foodTypeName) {
		this.foodTypeName = foodTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFoodTimeFrom() {
		return foodTimeFrom;
	}

	public void setFoodTimeFrom(Date foodTimeFrom) {
		this.foodTimeFrom = foodTimeFrom;
	}

	public Date getFoodTimeTo() {
		return foodTimeTo;
	}

	public void setFoodTimeTo(Date foodTimeTo) {
		this.foodTimeTo = foodTimeTo;
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
