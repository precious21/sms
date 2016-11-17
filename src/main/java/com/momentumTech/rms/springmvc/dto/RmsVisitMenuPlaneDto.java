package com.momentumTech.rms.springmvc.dto;

import com.momentumTech.rms.springmvc.domain.RmsFoodTypeDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitDomain;

public class RmsVisitMenuPlaneDto {

	  private int visitMenuPlaneId;
	 
	  private RmsVisitDomain rmsVisitDomain;
	 
	  private RmsFoodTypeDomain rmsFoodTypeDomain;
	 
	  private String foodLimit;
	 
	  private String remaining;

	public int getVisitMenuPlaneId() {
		return visitMenuPlaneId;
	}

	public void setVisitMenuPlaneId(int visitMenuPlaneId) {
		this.visitMenuPlaneId = visitMenuPlaneId;
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

	public String getFoodLimit() {
		return foodLimit;
	}

	public void setFoodLimit(String foodLimit) {
		this.foodLimit = foodLimit;
	}

	public String getRemaining() {
		return remaining;
	}

	public void setRemaining(String remaining) {
		this.remaining = remaining;
	}
}
