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
@Table(name="rms_user")
public class RmsUserDomain {
	
	  @Id
	  @GeneratedValue(generator = "system-uuid")
	  @GenericGenerator(name = "system-uuid", strategy = "uuid")
	  @Column(name = "user_id", unique = true)
	  private String userId;
	
	  @Column(name = "firstName")
	  private String firstName;

	  @Column(name = "lastName")
	  private String lastName;

	  @Column(name = "emailId")
	  private String emailId;

	  @Column(name = "phoneNo")
	  private String phoneNo;

	  @Column(name = "username")
	  private String username;

	  @Column(name = "password")
	  private String password;

	  @Column(name = "user_status")
	  private String status;

	  @Column(name = "createdBy")
	  private String createdBy;

	  @Column(name = "updatedBy")
	  private String updatedBy;

	  @Column(name = "createdOn")
	  private Date createdOn;

	  @Column(name = "updatedOn")
	  private Date updatedOn;
	  
	  @Column(name = "user_type")
	  private String userType;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
