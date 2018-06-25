package org.com.au.wagerapi.model;

public class BetTypeModel {

	public int id;
	public String betName;
	public String betDescription;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBetName() {
		return betName;
	}
	public void setBetName(String betName) {
		this.betName = betName;
	}
	public String getBetDescription() {
		return betDescription;
	}
	public void setBetDescription(String betDescription) {
		this.betDescription = betDescription;
	}
}
