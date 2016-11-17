package com.momentumTech.rms.springmvc.domain;

import java.util.Date;

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
@Table(name="rms_food_consumption")
public class RmsFoodConsumptionDomain {

	 @Id
	 @GeneratedValue(generator = "system-uuid")
	 @GenericGenerator(name = "system-uuid", strategy = "uuid")
	 @Column(name = "food_consumption_id", unique = true)
	  private String foodConsumptionId;
	 
	 @ManyToOne(targetEntity = RmsVisitMenuPlaneDomain.class)
	  @JoinColumn(name = "visit_menu_plane_id", nullable = true, referencedColumnName = "visit_menu_plane_id")
	  private RmsVisitMenuPlaneDomain rmsVisitMenuPlaneDomain;
	 
	 @Column(name = "description")
	  private String description;
	 
	 @Column(name = "qty")
	  private String qty;
	 
	 @Column(name = "client_id")
	  private String clientID;

	  @Column(name = "user_id")
	  private String userId;

	  @Column(name = "createdBy")
	  private String createdBy;

	  @Column(name = "createdOn")
	  private Date createdOn;

	  @Column(name = "updatedBy")
	  private String updatedBy;

	  @Column(name = "updatedOn")
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

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
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
