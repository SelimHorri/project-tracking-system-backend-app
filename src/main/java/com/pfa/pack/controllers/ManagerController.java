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

import com.pfa.pack.models.dto.ManagerProjectData;
import com.pfa.pack.models.entities.UserCredential;
import com.pfa.pack.services.EmployeeService;
import com.pfa.pack.services.ProjectService;
import com.pfa.pack.services.UserCredentialService;

@Controller
@RequestMapping(value = {"/app/managers"})
public class ManagerController {
	
	private final EmployeeService employeeService;
	private final UserCredentialService userCredentialService;
	private final ProjectService projectService;
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	static {
		logger.info("************ entering " + ManagerController.class.getName() + " ************");
	}
	
	@Autowired
	public ManagerController(final EmployeeService employeeService, final UserCredentialService userCredentialService, final ProjectService projectService) {
		this.employeeService = employeeService;
		this.userCredentialService = userCredentialService;
		this.projectService = projectService;
	}
	
	@GetMapping(value = {"/manager-index"})
	public String displayManagerIndex(final Authentication authentication, final Model model) {
		
		final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<ManagerProjectData> managerProjectDatas = this.projectService.findByEmployeeId(userCredential.getEmployee().getEmployeeId());
		
		model.addAttribute("managerProjectDatas", managerProjectDatas);
		
		return "managers/manager-index";
	}
	
	
	
}










