package org.com.au.wagerapi.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"customerId", "firstName", "lastName", "emailId", "betInvestment"})
public class BetInvestmentCustomerModel {

	private String firstName;
	private String lastName;
	private String emailId;
	private int customerId;
	private int betInvestment;
	
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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBetInvestment() {
		return betInvestment;
	}
	public void setBetInvestment(int betInvestment) {
		this.betInvestment = betInvestment;
	}
	
}
