package com.pfa.pack.service;

import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Credential;

public interface CredentialService {
	
	DtoCollection<Credential> findAll();
	Credential findById(final Integer userCredentialId);
	Credential save(final Credential credential);
	Credential update(final Credential credential);
	void delete(final Integer userCredentialId);
	Credential findByUsername(final String username);
	
}
