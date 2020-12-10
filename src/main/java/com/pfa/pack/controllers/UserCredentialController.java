package com.pfa.pack.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.UserCredentialService;

@Controller
@RequestMapping(value = {"/app/credentials"})
public class UserCredentialController {
	
	private final UserCredentialService userCredentialService;
	private static final Logger logger = LoggerFactory.getLogger(UserCredentialController.class);
	
	static {
		logger.info("************ entering " + UserCredentialController.class.getName() + " ************");
	}
	
	@Autowired
	public UserCredentialController(final UserCredentialService userCredentialService) {
		this.userCredentialService = userCredentialService;
	}
	
	@GetMapping(value = {"/credential-edit"})
	public String displayCredentialEdit() {
		
		
		
		return "";
	}
	
	
	
}









