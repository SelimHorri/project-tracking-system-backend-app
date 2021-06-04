package com.pfa.pack.service;

import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Credential;

public interface CredentialService {
	
	public abstract DtoCollection<Credential> findAll();
	public abstract Credential findById(final Integer userCredentialId);
	public abstract Credential save(final Credential credential);
	public abstract Credential update(final Credential credential);
	public abstract void delete(final Integer userCredentialId);
	public abstract Credential findByUsername(final String username);
	
}
