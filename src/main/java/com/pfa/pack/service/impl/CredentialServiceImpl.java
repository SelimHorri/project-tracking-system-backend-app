package com.pfa.pack.service.impl;

import java.util.Collections;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pfa.pack.exception.custom.ObjectNotFoundException;
import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Credential;
import com.pfa.pack.repository.CredentialRepository;
import com.pfa.pack.service.CredentialService;

@Service
@Transactional
public class CredentialServiceImpl implements CredentialService {
	
	private final CredentialRepository rep;
	private static final Logger logger = LoggerFactory.getLogger(CredentialServiceImpl.class);
	
	static {
		logger.info("************ entering " + CredentialServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public CredentialServiceImpl(final CredentialRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public DtoCollection<Credential> findAll() {
		return new DtoCollection<>(Collections.unmodifiableList(this.rep.findAll()));
	}
	
	@Override
	public Credential findById(final Integer userCredentialId) {
		return this.rep.findById(userCredentialId).orElseThrow(() -> new ObjectNotFoundException("###### NO Credential object FOUND! ######"));
	}
	
	@Override
	public Credential save(final Credential credential) {
		return this.rep.save(credential);
	}
	
	@Override
	public Credential update(final Credential credential) {
		return this.rep.save(credential);
	}
	
	@Override
	public void delete(final Integer userCredentialId) {
		this.rep.delete(this.findById(userCredentialId));
	}
	
	/**
	 * @param username
	 * @return a userCredential instance
	 */
	@Override
	public Credential findByUsername(final String username) {
		return this.rep.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("\n-------------- NO Credential object FOUND with username: " + username + " ! --------------\n"));
	}
	
	
	
}










