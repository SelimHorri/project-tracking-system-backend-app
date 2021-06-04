package com.pfa.pack.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pfa.pack.exception.custom.ApiTwilioException;
import com.pfa.pack.exception.payload.ExceptionMsg;

@ControllerAdvice
public class ExceptionMsgHandler {
	
	@ExceptionHandler(
		value = {
			ApiTwilioException.class
		}
	)
	public ResponseEntity<Object> handleApiTwilioCustomException(final ApiTwilioException exception) {
		
		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		final ExceptionMsg exceptionMsg = new ExceptionMsg(exception.getMessage(), badRequest, ZonedDateTime.now());
		System.err.println(exceptionMsg);
		
		return new ResponseEntity<>(exceptionMsg, badRequest);
	}
	
	
	
}










