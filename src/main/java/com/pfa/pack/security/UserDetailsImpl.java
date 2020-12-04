package com.pfa.pack.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pfa.pack.models.entities.UserCredential;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private final UserCredential userCredential;
	
	public UserDetailsImpl(final UserCredential userCredential) {
		this.userCredential = userCredential;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(this.userCredential.getRole()));
	}
	
	@Override
	public String getUsername() {
		return this.userCredential.getUsername();
	}
	
	@Override
	public String getPassword() {
		return this.userCredential.getPassword();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return this.userCredential.getEnabled();
	}
	
	

}
