package com.pfa.pack.config.twilio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfig {
	
	private String accountSid;
	private String authToken;
	private String trialNumber;
	
	public TwilioConfig() {
		
	}
	
	public String getAccountSid() {
		return accountSid;
	}
	
	public void setAccountSid(final String accountSid) {
		this.accountSid = accountSid;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	
	public void setAuthToken(final String authToken) {
		this.authToken = authToken;
	}
	
	public String getTrialNumber() {
		return trialNumber;
	}
	
	public void setTrialNumber(final String trialNumber) {
		this.trialNumber = trialNumber;
	}
	
	
	
}









