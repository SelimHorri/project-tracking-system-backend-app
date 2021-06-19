package com.pfa.pack.service;

import com.pfa.pack.model.dto.AuthenticationRequest;
import com.pfa.pack.model.dto.AuthenticationResponse;

public interface AuthenticationService {
	
	AuthenticationResponse authenticate(final AuthenticationRequest authenticationRequest);
	
}





