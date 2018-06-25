package org.com.au.wagerapi.model;

import javax.ws.rs.QueryParam;

public class BetTransactionCreateModel {

	private @QueryParam("BetType") String BetType;
	private @QueryParam("PropNumber") int PropNumber;
	private @QueryParam("CustomerID") int CustomerID;
	private @QueryParam("Investment") int Investment;
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
