package com.pfa.pack.util.sms;

import java.io.Serializable;

public final class Sms implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final String to;
	private final String msg;
	
	public Sms(final String to, final String msg) {
		this.to = to;
		this.msg = msg;
	}
	
	public String getTo() {
		return to;
	}
	
	public String getMsg() {
		return msg;
	}
	
	
	
}











