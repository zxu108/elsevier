package com.zen.hub.zenhub.model;

import java.util.Date;

public class CustomerInfo {

	private Integer custId;
	private String custName;
	private Date custDob;
	private String custSex;
	private String custProj;
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Date getCustDob() {
		return custDob;
	}
	public void setCustDob(Date custDob) {
		this.custDob = custDob;
	}
	public String getCustSex() {
		return custSex;
	}
	public void setCustSex(String custSex) {
		this.custSex = custSex;
	}
	public String getCustProj() {
		return custProj;
	}
	public void setCustProj(String custProj) {
		this.custProj = custProj;
	}

	
}
