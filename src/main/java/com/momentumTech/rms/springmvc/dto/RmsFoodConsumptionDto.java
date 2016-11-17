package com.momentumTech.rms.springmvc.dto;

import java.util.Date;


import com.momentumTech.rms.springmvc.domain.RmsVisitMenuPlaneDomain;

public class RmsFoodConsumptionDto {

	  private String foodConsumptionId;
	  
	  private RmsVisitMenuPlaneDomain rmsVisitMenuPlaneDomain;
	 
	  private String description;
	 
	  private String clientID;

	  private String userId;

	  private String createdBy;

	  private Date createdOn;

	  private String updatedBy;

	  private Date updatedOn;

	public String getFoodConsumptionId() {
		return foodConsumptionId;
	}

	public void setFoodConsumptionId(String foodConsumptionId) {
		this.foodConsumptionId = foodConsumptionId;
	}

	public RmsVisitMenuPlaneDomain getRmsVisitMenuPlaneDomain() {
		return rmsVisitMenuPlaneDomain;
	}

	public void setRmsVisitMenuPlaneDomain(RmsVisitMenuPlaneDomain rmsVisitMenuPlaneDomain) {
		this.rmsVisitMenuPlaneDomain = rmsVisitMenuPlaneDomain;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
