package com.pfa.pack.exception.custom;

import com.twilio.exception.ApiException;

public class ApiTwilioException extends ApiException {
	
	private static final long serialVersionUID = 1L;
	
	public ApiTwilioException(final String message) {
		super(message);
	}
	
	public ApiTwilioException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	
	
}








