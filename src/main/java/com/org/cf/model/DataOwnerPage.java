package com.org.cf.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class DataOwnerPage implements Serializable {
	
	private int dataOwnerId;
	private String consentType;
	private String startTime;
	private Date expiaryDate;
	private String option1;
	private String option2;
	
	
	public int getDataOwnerId() {
		return dataOwnerId;
	}
	public void setDataOwnerId(int dataOwnerId) {
		this.dataOwnerId = dataOwnerId;
	}
	public String getConsentType() {
		return consentType;
	}
	public void setConsentType(String consentType) {
		this.consentType = consentType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Date getExpiaryDate() {
		return expiaryDate;
	}
	public void setExpiaryDate(Date expiaryDate) {
		this.expiaryDate = expiaryDate;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	
	
	
	
	
	
	
	

}
