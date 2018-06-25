package org.com.au.wagerapi.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"betId", "betName", "betInvestment"})
public class BetInvestmentTypeModel {

	private int betId;
	private String betName;
	private int betInvestment;
		
	public String getBetName() {
		return betName;
	}
	public void setBetName(String betName) {
		this.betName = betName;
	}
	public int getBetInvestment() {
		return betInvestment;
	}
	public void setBetInvestment(int betInvestment) {
		this.betInvestment = betInvestment;
	}
	public int getBetId() {
		return betId;
	}
	public void setBetId(int betId) {
		this.betId = betId;
	}
	
	
}
