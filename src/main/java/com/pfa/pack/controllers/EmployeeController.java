package com.pfa.pack.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.models.dto.EmployeeProjectData;
import com.pfa.pack.models.entities.UserCredential;
import com.pfa.pack.services.AssignmentService;
import com.pfa.pack.services.EmployeeService;
import com.pfa.pack.services.ProjectService;
import com.pfa.pack.services.UserCredentialService;

@Controller
@RequestMapping(value = {"/app/employees"})
public class EmployeeController {
	
	private final EmployeeService service;
	private final UserCredentialService userCredentialService;
	private final ProjectService projectService;
	private final AssignmentService assignmentService;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	static {
		logger.info("************ entering " + EmployeeController.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeController(final EmployeeService service, final UserCredentialService userCredentialService, final ProjectService projectService, final AssignmentService assignmentService) {
		this.service = service;
		this.userCredentialService = userCredentialService;
		this.projectService = projectService;
		this.assignmentService = assignmentService;
	}
	
	@GetMapping(value = {"/employee-index"})
	public String displayEmployeeIndex(final Authentication authentication, final Model model) {
		
		final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<EmployeeProjectData> employeeProjectData = this.assignmentService.findByEmployeeId(userCredential.getEmployee().getEmployeeId());
		
		model.addAttribute("username", authentication.getName());
		model.addAttribute("employeeProjectData", employeeProjectData);
		
		return "employees/employee-index";
	}
	
	
	
}










