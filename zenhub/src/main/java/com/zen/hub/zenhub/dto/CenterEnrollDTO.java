package com.zen.hub.zenhub.dto;

import java.util.Date;

public class CenterEnrollDTO {
	private String centerPassword;
	private String centerId;
	private String centerName;
	private String centerDescription;
	private String centerOwnerFirstName;
	private String centerOwnerMidName;
	private String centerOwnerLastName;	
	private String centerAddress1;		
	private String centerAddress2;	
	private String centerCity;		
	private String centerState;	
	private String centerZipCode;	
	private String centerCountry;	
	private String centerOwnerEmail;	
	private String centerOwnerPhone;
	private Date centerCloseStartDate;
	private boolean centerOpenStatus;
	
	public String getCenterPassword() {
		return centerPassword;
	}
	public void setCenterPassword(String centerPassword) {
		this.centerPassword = centerPassword;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterDescription() {
		return centerDescription;
	}
	public void setCenterDescription(String centerDescription) {
		this.centerDescription = centerDescription;
	}
	public String getCenterOwnerFirstName() {
		return centerOwnerFirstName;
	}
	public void setCenterOwnerFirstName(String centerOwnerFirstName) {
		this.centerOwnerFirstName = centerOwnerFirstName;
	}
	public String getCenterOwnerMidName() {
		return centerOwnerMidName;
	}
	public void setCenterOwnerMidName(String centerOwnerMidName) {
		this.centerOwnerMidName = centerOwnerMidName;
	}
	public String getCenterOwnerLastName() {
		return centerOwnerLastName;
	}
	public void setCenterOwnerLastName(String centerOwnerLastName) {
		this.centerOwnerLastName = centerOwnerLastName;
	}
	public String getCenterAddress1() {
		return centerAddress1;
	}
	public void setCenterAddress1(String centerAddress1) {
		this.centerAddress1 = centerAddress1;
	}
	public String getCenterAddress2() {
		return centerAddress2;
	}
	public void setCenterAddress2(String centerAddress2) {
		this.centerAddress2 = centerAddress2;
	}
	public String getCenterCity() {
		return centerCity;
	}
	public void setCenterCity(String centerCity) {
		this.centerCity = centerCity;
	}
	public String getCenterState() {
		return centerState;
	}
	public void setCenterState(String centerState) {
		this.centerState = centerState;
	}
	public String getCenterZipCode() {
		return centerZipCode;
	}
	public void setCenterZipCode(String centerZipCode) {
		this.centerZipCode = centerZipCode;
	}
	public String getCenterCountry() {
		return centerCountry;
	}
	public void setCenterCountry(String centerCountry) {
		this.centerCountry = centerCountry;
	}
	public String getCenterOwnerEmail() {
		return centerOwnerEmail;
	}
	public void setCenterOwnerEmail(String centerOwnerEmail) {
		this.centerOwnerEmail = centerOwnerEmail;
	}
	public String getCenterOwnerPhone() {
		return centerOwnerPhone;
	}
	public void setCenterOwnerPhone(String centerOwnerPhone) {
		this.centerOwnerPhone = centerOwnerPhone;
	}
	public Date getCenterCloseStartDate() {
		return centerCloseStartDate;
	}
	public void setCenterCloseStartDate(Date centerCloseStartDate) {
		this.centerCloseStartDate = centerCloseStartDate;
	}
	public boolean isCenterOpenStatus() {
		return centerOpenStatus;
	}
	public void setCenterOpenStatus(boolean centerOpenStatus) {
		this.centerOpenStatus = centerOpenStatus;
	}	
}
