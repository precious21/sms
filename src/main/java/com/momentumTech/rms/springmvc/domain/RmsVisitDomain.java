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
@Table(name="rms_visit")
public class RmsVisitDomain {

	 @Id
	 @GeneratedValue(generator = "system-uuid")
	 @GenericGenerator(name = "system-uuid", strategy = "uuid")
	 @Column(name = "visit_id", unique = true)
	  private String visitId;
	
	 @ManyToOne(targetEntity = RmsGuestDomain.class)
	  @JoinColumn(name = "guest_id", nullable = true, referencedColumnName = "guest_id")
	  private RmsGuestDomain rmsGuestDomain;
	 
	 @Column(name = "check_in")
	  private Date checkIn;
	 
	 @Column(name = "check_out")
	  private Date checkOut;
	 
	 @Column(name = "visit_closing_date")
	  private Date visitClosingDate;
	 
	 @Column(name = "visit_status")
	  private boolean visitStatus;
	 
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
