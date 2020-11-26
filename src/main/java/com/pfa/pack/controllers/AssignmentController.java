package com.pfa.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.AssignmentService;

@Controller
@RequestMapping(value = {})
public class AssignmentController {
	
	private final AssignmentService service;
	
	@Autowired
	public AssignmentController(final AssignmentService service) {
		this.service = service;
	}
	
	
	
}










