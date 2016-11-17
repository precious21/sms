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
@Table(name="rms_guest")
public class RmsGuestDomain {

	 @Id
	 @GeneratedValue(generator = "system-uuid")
	 @GenericGenerator(name = "system-uuid", strategy = "uuid")
	 
	 @Column(name = "guest_id", unique = true)
	  private String guestId;
	 
	 @Column(name = "gues_code")
	  private String guestCode;
	 
	 @Column(name = "guest_name")
	  private String guestName;
	 
	 @Column(name = "father_name")
	  private String fatherName;
	 
	 @Column(name = "gender")
	  private String gender;
	 
	 @Column(name = "contact_no")
	  private String contactNo;
	 
	 @Column(name = "room_no")
	  private String roomNo;
	 
	 @Column(name = "cnic")
	  private String cnic;
	 
	 @Column(name = "guest_status")
	  private String guestStatus;
	 
	 @Column(name = "reg_date")
	  private Date regDate;
	 
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

	 
}
