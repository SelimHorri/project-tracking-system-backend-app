package com.pfa.pack.service.impls;

import java.util.Collections;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.UserCredential;
import com.pfa.pack.repository.UserCredentialRepository;
import com.pfa.pack.service.UserCredentialService;

@Service
@Transactional
public class UserCredentialServiceImpl implements UserCredentialService {
	
	private final UserCredentialRepository rep;
	private static final Logger logger = LoggerFactory.getLogger(UserCredentialServiceImpl.class);
	
	static {
		logger.info("************ entering " + UserCredentialServiceImpl.class.getName() + " ************");
	}
	
	@Autowired
	public UserCredentialServiceImpl(final UserCredentialRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public DtoCollection<UserCredential> findAll() {
		return new DtoCollection<>(Collections.unmodifiableList(this.rep.findAll()));
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
	
	/**
	 * @param username
	 * @return a userCredential instance
	 */
	@Override
	public UserCredential findByUsername(final String username) {
		return this.rep.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("\n-------------- NO SUCH ELEMENT by username: " + username + " --------------\n"));
	}
	
	
	
}










