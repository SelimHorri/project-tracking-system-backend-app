package com.pfa.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.ProjectService;

@Controller
@RequestMapping(value = {})
public class ProjectController {
	
	private final ProjectService service;
	
	@Autowired
	public ProjectController(final ProjectService service) {
		this.service = service;
	}
	
	
	
}










