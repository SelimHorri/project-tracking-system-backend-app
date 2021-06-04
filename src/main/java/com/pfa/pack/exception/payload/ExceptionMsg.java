package com.pfa.pack.exception.payload;

import java.io.Serializable;
import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;

public class ExceptionMsg implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final String msg;
	private Throwable throwable;
	private final HttpStatus status;
	
	@DateTimeFormat(pattern = "dd-MM-yyyyHH:mm:ss")
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyyHH:mm:ss")
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	private final ZonedDateTime timestamp;
	
	public ExceptionMsg(final String msg, final HttpStatus status, final ZonedDateTime timestamp) {
		this.msg = msg;
		this.status = status;
		this.timestamp = timestamp;
	}
	
	public ExceptionMsg(final String msg, final Throwable throwable, final HttpStatus status, final ZonedDateTime timestamp) {
		this.msg = msg;
		this.throwable = throwable;
		this.status = status;
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "ExceptionMsg [msg=" + msg + ", throwable=" + throwable + ", status=" + status + ", timestamp=" + timestamp + "]";
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public Throwable getThrowable() {
		return throwable;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	
	
}










