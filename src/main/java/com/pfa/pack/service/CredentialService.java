package com.pfa.pack.service;

import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Credential;

public interface CredentialService {
	
	DtoCollection<Credential> findAll();
	Credential findById(final Integer credentialId);
	Credential save(final Credential credential);
	Credential update(final Credential credential);
	void deleteById(final Integer credentialId);
	Credential findByUsername(final String username);
	void deleteByUsername(final String username);
	
}
