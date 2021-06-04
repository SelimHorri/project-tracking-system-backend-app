package com.pfa.pack.service;

import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.UserCredential;

public interface UserCredentialService {
	
	public abstract DtoCollection<UserCredential> findAll();
	public abstract UserCredential findById(final Integer userCredentialId);
	public abstract UserCredential save(final UserCredential userCredential);
	public abstract UserCredential update(final UserCredential userCredential);
	public abstract void delete(final Integer userCredentialId);
	public abstract UserCredential findByUsername(final String username);
	
}
