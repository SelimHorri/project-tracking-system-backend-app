package com.pfa.pack.services;

import com.pfa.pack.models.collectionwrappers.UserCredentialsCollection;
import com.pfa.pack.models.entities.UserCredential;

public interface UserCredentialService {
	
	public abstract UserCredentialsCollection findAll();
	public abstract UserCredential findById(final Integer userCredentialId);
	public abstract UserCredential save(final UserCredential userCredential);
	public abstract UserCredential update(final UserCredential userCredential);
	public abstract void delete(final Integer userCredentialId);
	public abstract UserCredential findByUsername(final String username);
	
}
