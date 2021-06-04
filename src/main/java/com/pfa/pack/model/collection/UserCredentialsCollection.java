package com.pfa.pack.model.collection;

import java.io.Serializable;
import java.util.List;

import com.pfa.pack.model.entity.UserCredential;

public final class UserCredentialsCollection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<UserCredential> userCredentials;
	
	public UserCredentialsCollection() {
		
	}
	
	public UserCredentialsCollection(final List<UserCredential> userCredentials) {
		this.userCredentials = userCredentials;
	}
	
	public List<UserCredential> getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(final List<UserCredential> userCredentials) {
		this.userCredentials = userCredentials;
	}
	
	
	
}








