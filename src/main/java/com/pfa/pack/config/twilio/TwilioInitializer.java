package com.pfa.pack.config.twilio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {
	
	private TwilioConfig twilioConfig;
	private static final Logger logger = LoggerFactory.getLogger(TwilioInitializer.class);
	
	static {
		logger.info("************ entering " + TwilioInitializer.class.getName() + " ************");
	}
	
	@Autowired
	public TwilioInitializer(final TwilioConfig twilioConfig) {
		this.twilioConfig = twilioConfig;
		Twilio.init(this.twilioConfig.getAccountSid(), this.twilioConfig.getAuthToken());
		logger.info("twilio initialized with: accountId = [{}] and authToken = [{}]", this.twilioConfig.getAccountSid(), this.twilioConfig.getAuthToken());
	}
	
	
	
}











