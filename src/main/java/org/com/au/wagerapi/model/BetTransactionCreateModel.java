package org.com.au.wagerapi.model;

public class BetTransactionCreateModel {

	private  String BetType;
	private  int PropNumber;
	private  int CustomerID;
	private  int Investment;
	
	public String getBetType() {
		return BetType;
	}
	public void setBetType(String betType) {
		BetType = betType;
	}
	public int getPropNumber() {
		return PropNumber;
	}
	public void setPropNumber(int propNumber) {
		PropNumber = propNumber;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public int getInvestment() {
		return Investment;
	}
	public void setInvestment(int investment) {
		Investment = investment;
	}

}
