package com.pfa.pack.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.EmployeeService;

@Controller
@RequestMapping(value = {})
public class EmployeeController {
	
	private final EmployeeService service;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	static {
		logger.info("************ entering " + EmployeeController.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeController(final EmployeeService service) {
		this.service = service;
	}
	
	
	
}










