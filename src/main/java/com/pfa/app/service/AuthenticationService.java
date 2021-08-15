package com.pfa.app.service;

import com.pfa.app.model.dto.AuthenticationRequest;
import com.pfa.app.model.dto.AuthenticationResponse;

public interface AuthenticationService {
	
	AuthenticationResponse authenticate(final AuthenticationRequest authenticationRequest);
	
}





