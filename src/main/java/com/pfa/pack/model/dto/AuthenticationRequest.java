package com.pfa.pack.model.dto;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public AuthenticationRequest() {
		
	}
	
	public AuthenticationRequest(final String username, final String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [username=" + username + ", password=" + password + "]";
	}
	
	public String getUsername() {
		return username;
	}
	
	public AuthenticationRequest setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public String getPassword() {
		return password;
	}
	
	public AuthenticationRequest setPassword(String password) {
		this.password = password;
		return this;
	}
	
	
	
}
