package com.hackathon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_session")
public class LoginSession {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="session_key")
	private String sessionKey;
	
	@Column(name="email")
	private String email;
	
	public LoginSession() {}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getEmail() {
		return email;
	} 

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
