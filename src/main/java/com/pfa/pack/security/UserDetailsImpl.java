package com.pfa.pack.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pfa.pack.model.entity.Credential;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private final Credential credential;
	
	public UserDetailsImpl(final Credential credential) {
		this.credential = credential;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(this.credential.getRole()));
	}
	
	@Override
	public String getUsername() {
		return this.credential.getUsername();
	}
	
	@Override
	public String getPassword() {
		return this.credential.getPassword();
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
		return this.credential.getEnabled();
	}
	
	

}
