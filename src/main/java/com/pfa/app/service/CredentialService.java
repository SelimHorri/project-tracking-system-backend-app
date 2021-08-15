package com.pfa.app.service;

import com.pfa.app.model.dto.collection.DtoCollection;
import com.pfa.app.model.entity.Credential;

public interface CredentialService {
	
	DtoCollection<Credential> findAll();
	Credential findById(final Integer credentialId);
	Credential save(final Credential credential);
	Credential update(final Credential credential);
	void deleteById(final Integer credentialId);
	Credential findByUsername(final String username);
	void deleteByUsername(final String username);
	
}
