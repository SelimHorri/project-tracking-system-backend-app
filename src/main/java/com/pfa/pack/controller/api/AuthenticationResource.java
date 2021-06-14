package com.pfa.pack.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.pack.model.dto.AuthenticationRequest;
import com.pfa.pack.model.dto.AuthenticationResponse;

@RestController
@RequestMapping(value = {"/app/api/authenticate"})
public class AuthenticationResource {
	
	private final AuthenticationManager authenticationManager;
	
	@Autowired
	public AuthenticationResource(final AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody final AuthenticationRequest authenticationRequest) {
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch (BadCredentialsException e) {
			throw new BadCredentialsException("#### BAD CREDENTIALS ####");
		}
		
		return ResponseEntity.ok(new AuthenticationResponse(authenticationRequest.getUsername(), Optional.of(authenticationRequest.getUsername()).isPresent()));
	}
	
	
	
}







