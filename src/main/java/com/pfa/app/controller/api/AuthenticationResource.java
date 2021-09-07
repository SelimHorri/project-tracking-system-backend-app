package com.pfa.app.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.app.model.dto.AuthenticationRequest;
import com.pfa.app.model.dto.AuthenticationResponse;
import com.pfa.app.service.AuthenticationService;

@RestController
@RequestMapping(value = {"/api/authenticate"})
public class AuthenticationResource {
	
	private final AuthenticationService authenticationService;
	
	@Autowired
	public AuthenticationResource(final AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody final AuthenticationRequest authenticationRequest) {
		return ResponseEntity.ok(this.authenticationService.authenticate(authenticationRequest));
	}
	
	
	
}







