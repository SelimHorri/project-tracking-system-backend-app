package com.pfa.pack.services.impls;

import java.util.Collections;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.pack.models.collectionwrappers.UserCredentialsCollection;
import com.pfa.pack.models.entities.UserCredential;
import com.pfa.pack.repositories.UserCredentialRepository;
import com.pfa.pack.services.UserCredentialService;

@Service
@Transactional
public class UserCredentialServiceImpl implements UserCredentialService {
	
	private final UserCredentialRepository rep;
	
	@Autowired
	public UserCredentialServiceImpl(final UserCredentialRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public UserCredentialsCollection findAll() {
		return new UserCredentialsCollection(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	@Override
	public UserCredential findById(final Integer userCredentialId) {
		return this.rep.findById(userCredentialId).orElseThrow(() -> new NoSuchElementException("\\n------------ NO ELEMENT FOUND !!!!! ------------\\n"));
	}
	
	@Override
	public UserCredential save(final UserCredential userCredential) {
		return this.rep.save(userCredential);
	}
	
	@Override
	public UserCredential update(final UserCredential userCredential) {
		return this.rep.save(userCredential);
	}
	
	@Override
	public void delete(final Integer userCredentialId) {
		this.rep.delete(this.findById(userCredentialId));
	}
	
	
	
}










