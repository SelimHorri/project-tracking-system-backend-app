package com.pfa.pack.services.impls;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	
}










