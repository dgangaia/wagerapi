package org.com.au.wagerapi.model;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder={"duration_start", "duration_end", "totalNumberofBet"})
public class BetCountPerHourModel {

	private int totalNumberofBet;
	private Timestamp duration_start;
	private Timestamp duration_end;
	public int getTotalNumberofBet() {
		return totalNumberofBet;
	}
	public void setTotalNumberofBet(int totalNumberofBet) {
		this.totalNumberofBet = totalNumberofBet;
	}
	public Timestamp getDuration_start() {
		return duration_start;
	}
	public void setDuration_start(Timestamp duration_start) {
		this.duration_start = duration_start;
	}
	public Timestamp getDuration_end() {
		return duration_end;
	}
	public void setDuration_end(Timestamp duration_end) {
		this.duration_end = duration_end;
	}

	
}
