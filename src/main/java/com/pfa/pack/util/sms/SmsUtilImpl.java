package com.pfa.pack.util.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pfa.pack.config.twilio.TwilioConfig;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class SmsUtilImpl implements SmsUtil {
	
	private TwilioConfig twilioConfig;
	private static final Logger logger = LoggerFactory.getLogger(SmsUtilImpl.class);
	
	static {
		logger.info("************ entering " + SmsUtilImpl.class.getName() + " ************");
	}
	
	@Autowired
	public SmsUtilImpl(final TwilioConfig twilioConfig) {
		this.twilioConfig = twilioConfig;
	}
	
	@Override
	public void sendSms(final Sms sms) {
		try {
			Message.creator(new PhoneNumber("+216" + sms.getTo()), new PhoneNumber(this.twilioConfig.getTrialNumber()), sms.getMsg()).create();
		}
		catch (ApiException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	
	
	
}











