package com.zen.hub.zenhub;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiError {
	private HttpStatus status;
	private Date timestamp;
	private String message;
	
	private ApiError() {
		timestamp = new Date();
	}
	
	ApiError(HttpStatus status, String message) {
		this();
		this.status = status;
		this.message = message;
		this.timestamp = new Date();
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
