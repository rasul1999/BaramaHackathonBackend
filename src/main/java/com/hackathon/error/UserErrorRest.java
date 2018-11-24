package com.hackathon.error;

import java.util.Date;

public class UserErrorRest {

	private String message;
	private String status;
	private Date timeStamp;
	
	public UserErrorRest() {}

	
	public UserErrorRest(String message, String status, Date timeStamp) {
		super();
		this.message = message;
		this.status = status;
		this.timeStamp = timeStamp;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
