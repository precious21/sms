package com.momentumTech.rms.springmvc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="rms_food_type")
public class RmsFoodTypeDomain {

	 @Id
	 @GeneratedValue(generator = "system-uuid")
	 @GenericGenerator(name = "system-uuid", strategy = "uuid")
	 @Column(name = "food_type_id", unique = true)
	  private String foodTypeId;
	 
	 @Column(name = "food_type_name")
	  private String foodTypeName;
	 
	 @Column(name = "description")
	  private String description;
	 
	 @Column(name = "food_time_from")
	  private Date foodTimeFrom;
	 
	 @Column(name = "food_time_to")
	  private Date foodTimeTo;
	 
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
