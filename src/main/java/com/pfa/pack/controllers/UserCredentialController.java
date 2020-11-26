package com.pfa.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.UserCredentialService;

@Controller
@RequestMapping(value = {})
public class UserCredentialController {
	
	private final UserCredentialService service;
	
	@Autowired
	public UserCredentialController(final UserCredentialService service) {
		this.service = service;
	}
	
	
	
}










