package com.pfa.pack.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.AssignmentService;

@Controller
@RequestMapping(value = {})
public class AssignmentController {
	
	private final AssignmentService service;
	private static final Logger logger = LoggerFactory.getLogger(AssignmentController.class);
	
	static {
		logger.info("************ entering " + AssignmentController.class.getName() + " ************");
	}
	
	@Autowired
	public AssignmentController(final AssignmentService service) {
		this.service = service;
	}
	
	
	
}










