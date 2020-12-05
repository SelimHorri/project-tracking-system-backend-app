package com.pfa.pack.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.ProjectService;

@Controller
@RequestMapping(value = {"/app/projects"})
public class ProjectController {
	
	private final ProjectService service;
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	static {
		logger.info("************ entering " + ProjectController.class.getName() + " ************");
	}
	
	@Autowired
	public ProjectController(final ProjectService service) {
		this.service = service;
	}
	
	
	
}










