package org.com.au.wagerapi.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"betId", "betName", "numberofbetsold"})
public class BetCountPerBetTypeModel {
	private int betId;
	private String betName;
	private int numberofbetsold;
	public int getBetId() {
		return betId;
	}
	public void setBetId(int betId) {
		this.betId = betId;
	}
	public String getBetName() {
		return betName;
	}
	public void setBetName(String betName) {
		this.betName = betName;
	}
	public int getNumberofbetsold() {
		return numberofbetsold;
	}
	public void setNumberofbetsold(int numberofbetsold) {
		this.numberofbetsold = numberofbetsold;
	}
}
