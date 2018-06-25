package org.com.au.wagerapi.model;

import java.sql.Date;

public class CustomerModel {

	private String firstName;
	private String lastName;
	private String emailId;
	private String addressId;
	private Boolean activeCustomer;
	private Date userCreationDate;
	private Date lastRecordUpdateDate;
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
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public Boolean getActiveCustomer() {
		return activeCustomer;
	}
	public void setActiveCustomer(Boolean activeCustomer) {
		this.activeCustomer = activeCustomer;
	}
	public Date getUserCreationDate() {
		return userCreationDate;
	}
	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
	}
	public Date getLastRecordUpdateDate() {
		return lastRecordUpdateDate;
	}
	public void setLastRecordUpdateDate(Date lastRecordUpdateDate) {
		this.lastRecordUpdateDate = lastRecordUpdateDate;
	}
	
	
}
