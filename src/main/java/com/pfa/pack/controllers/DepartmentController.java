package com.pfa.pack.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.DepartmentService;

@Controller
@RequestMapping(value = {})
public class DepartmentController {
	
	private final DepartmentService service;
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	static {
		logger.info("************ entering " + DepartmentController.class.getName() + " ************");
	}
	
	@Autowired
	public DepartmentController(final DepartmentService service) {
		this.service = service;
	}
	
	
	
}










