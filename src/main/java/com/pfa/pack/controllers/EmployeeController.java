package com.pfa.pack.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.pack.models.dto.EmployeeProjectData;
import com.pfa.pack.models.dto.ProjectCommit;
import com.pfa.pack.models.entities.Assignment;
import com.pfa.pack.models.entities.Project;
import com.pfa.pack.models.entities.UserCredential;
import com.pfa.pack.services.AssignmentService;
import com.pfa.pack.services.ProjectService;
import com.pfa.pack.services.UserCredentialService;

@Controller
@RequestMapping(value = {"/app/employees"})
public class EmployeeController {
	
	private final UserCredentialService userCredentialService;
	private final AssignmentService assignmentService;
	private final ProjectService projectService;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	static {
		logger.info("************ entering " + EmployeeController.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeController(final UserCredentialService userCredentialService, final ProjectService projectService, final AssignmentService assignmentService) {
		this.userCredentialService = userCredentialService;
		this.assignmentService = assignmentService;
		this.projectService = projectService;
	}
	
	@GetMapping(value = {"/employee-info"})
	public String displayEmployeeInfo(final Authentication authentication, final Model model) {
		
		
		
		return "employees/employee-info";
	}
	
	@GetMapping(value = {"/employee-team"})
	public String displayEmployeeTeam(final Authentication authentication, final Model model) {
		
		
		
		return "employees/employee-team";
	}
	
	@GetMapping(value = {"", "/", "/employee-index"})
	public String displayEmployeeIndex(final Authentication authentication, final Model model) {
		
		final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<EmployeeProjectData> employeeProjectData = this.assignmentService.findByEmployeeId(userCredential.getEmployee().getEmployeeId());
		
		model.addAttribute("fnameAndLname", userCredential.getEmployee().getFirstName().toUpperCase() + " " + userCredential.getEmployee().getLastName().toUpperCase());
		model.addAttribute("employeeProjectData", employeeProjectData);
		
		return "employees/employee-index";
	}
	
	@GetMapping(value = {"/employee-show-commits"})
	public String displayEmployeeShowCommits(@RequestParam("projectId") final String projectId, final Authentication authentication, final Model model) {
		
		final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<ProjectCommit> projectCommits = this.assignmentService.findByEmployeeIdAndProjectId(userCredential.getEmployee().getEmployeeId(), Integer.parseInt(projectId));
		final Project project = this.projectService.findById(Integer.parseInt(projectId));
		
		model.addAttribute("projectCommits", projectCommits);
		model.addAttribute("project", project);
		return "employees/employee-show-commits";
	}
	
	@GetMapping(value = {"/employee-add-commit"})
	public String displayEmployeeAddCommit(final Model model) {
		model.addAttribute("", new Assignment());
		return "employees/employee-add-commit";
	}
	
	@PostMapping(value = {"/employee-add-commits"})
	public String handleEmployeeAddCommit(@RequestParam("projectId") final String projectId, final Authentication authentication, final Model model) {
		
		
		
		return "employees/employee-add-commit";
	}
	
	
	
}










