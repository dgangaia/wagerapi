package org.com.au.wagerapi.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"bettype", "propnumber", "customerid", "investment"})
public class BetTransactionCreateModel {

	private  String bettype;
	private  int propnumber;
	private  int customerid;
	private  int investment;
	public String getBettype() {
		return bettype;
	}
	public void setBettype(String bettype) {
		this.bettype = bettype;
	}
	public int getPropnumber() {
		return propnumber;
	}
	public void setPropnumber(int propnumber) {
		this.propnumber = propnumber;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getInvestment() {
		return investment;
	}
	public void setInvestment(int investment) {
		this.investment = investment;
	}
	
	
}
