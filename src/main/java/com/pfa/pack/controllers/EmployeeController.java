package com.pfa.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.EmployeeService;

@Controller
@RequestMapping(value = {})
public class EmployeeController {
	
	private final EmployeeService service;
	
	@Autowired
	public EmployeeController(final EmployeeService service) {
		this.service = service;
	}
	
	
	
}










