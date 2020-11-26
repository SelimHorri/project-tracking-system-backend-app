package com.pfa.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.DepartmentService;

@Controller
@RequestMapping(value = {})
public class DepartmentController {
	
	private final DepartmentService service;
	
	@Autowired
	public DepartmentController(final DepartmentService service) {
		this.service = service;
	}
	
	
	
}










