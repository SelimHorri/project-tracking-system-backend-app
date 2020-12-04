package com.pfa.pack.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.EmployeeService;

@Controller
@RequestMapping(value = {"/app/managers"})
public class ManagerController {
	
	private final EmployeeService service;
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	static {
		logger.info("************ entering " + ManagerController.class.getName() + " ************");
	}
	
	@Autowired
	public ManagerController(final EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"/manager-index"})
	public String displayEmployeeIndex() {
		return "managers/manager-index";
	}
	
	
	
}










