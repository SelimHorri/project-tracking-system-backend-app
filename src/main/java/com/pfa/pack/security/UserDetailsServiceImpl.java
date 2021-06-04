package com.pfa.pack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pfa.pack.service.CredentialService;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	private CredentialService service;
	
	@Autowired
	public UserDetailsServiceImpl(final CredentialService service) {
		this.service = service;
	}
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		return new UserDetailsImpl(this.service.findByUsername(username.trim()));
	}
	
	
	
}
