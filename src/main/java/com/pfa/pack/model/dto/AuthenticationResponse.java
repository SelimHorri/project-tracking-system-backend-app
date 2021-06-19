package com.pfa.pack.model.dto;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private Boolean isEligible;
	
	public AuthenticationResponse() {
		
	}
	
	public AuthenticationResponse(final String username, final Boolean isEligible) {
		this.username = username;
		this.isEligible = isEligible;
	}
	
	@Override
	public String toString() {
		return "AuthenticationResponse [username=" + username + ", isEligible=" + isEligible + "]";
	}
	
	public String getUsername() {
		return username;
	}
	
	public AuthenticationResponse setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public Boolean getIsEligible() {
		return isEligible;
	}
	
	public AuthenticationResponse setIsEligible(Boolean isEligible) {
		this.isEligible = isEligible;
		return this;
	}
	
	
	
}





