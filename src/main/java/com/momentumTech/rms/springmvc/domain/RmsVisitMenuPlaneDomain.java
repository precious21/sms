package com.momentumTech.rms.springmvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="rms_visit_menu_plane")
public class RmsVisitMenuPlaneDomain {

	 @Id
	 @GeneratedValue(generator = "system-uuid")
	 @GenericGenerator(name = "system-uuid", strategy = "uuid")
	 @Column(name = "visit_menu_plane_id", unique = true)
	  private String visitMenuPlaneId;
	 
	 @ManyToOne(targetEntity = RmsVisitDomain.class)
	  @JoinColumn(name = "visit_id", nullable = true, referencedColumnName = "visit_id")
	  private RmsVisitDomain rmsVisitDomain;
	 
	 @ManyToOne(targetEntity = RmsFoodTypeDomain.class)
	  @JoinColumn(name = "food_type_id", nullable = true, referencedColumnName = "food_type_id")
	  private RmsFoodTypeDomain rmsFoodTypeDomain;
	 
	 @Column(name = "food_limit")
	  private String foodLimit;
	 
	 @Column(name = "remaining")
	  private String remaining;

	public String getVisitMenuPlaneId() {
		return visitMenuPlaneId;
	}

	public void setVisitMenuPlaneId(String visitMenuPlaneId) {
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
