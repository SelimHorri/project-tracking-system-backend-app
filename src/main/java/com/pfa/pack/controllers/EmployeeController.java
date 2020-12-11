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
import com.pfa.pack.models.entities.Employee;
import com.pfa.pack.models.entities.Project;
import com.pfa.pack.models.entities.UserCredential;
import com.pfa.pack.services.AssignmentService;
import com.pfa.pack.services.EmployeeService;
import com.pfa.pack.services.ProjectService;
import com.pfa.pack.services.UserCredentialService;

@Controller
@RequestMapping(value = {"/app/employees"})
public class EmployeeController {
	
	private final EmployeeService employeeService;
	private final UserCredentialService userCredentialService;
	private final AssignmentService assignmentService;
	private final ProjectService projectService;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	static {
		logger.info("************ entering " + EmployeeController.class.getName() + " ************");
	}
	
	/**
	 * Injected dependencies
	 * @param employeeService
	 * @param userCredentialService
	 * @param projectService
	 * @param assignmentService
	 */
	@Autowired
	public EmployeeController(final EmployeeService employeeService, final UserCredentialService userCredentialService, final ProjectService projectService, final AssignmentService assignmentService) {
		this.employeeService = employeeService;
		this.userCredentialService = userCredentialService;
		this.assignmentService = assignmentService;
		this.projectService = projectService;
	}
	
	/**
	 * display employee-info view
	 * @param authentication
	 * @param model
	 * @return employee-info
	 */
	@GetMapping(value = {"/employee-info"})
	public String displayEmployeeInfo(final Authentication authentication, final Model model) {
		
		final Employee employee = this.employeeService.findById(this.userCredentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId());
		model.addAttribute("e", employee);
		
		return "employees/employee-info";
	}
	
	/**
	 * display employee-team view
	 * @param authentication
	 * @param model
	 * @return employee-team
	 */
	@GetMapping(value = {"/employee-team"})
	public String displayEmployeeTeam(final Authentication authentication, final Model model) {
		
		final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<Employee> team = this.employeeService.findByDepartmentId(userCredential.getEmployee().getDepartment().getDepartmentId());
		
		model.addAttribute("team", team);
		
		return "employees/employee-team";
	}
	
	/**
	 * display employee-index view
	 * @param authentication
	 * @param model
	 * @return employee-index
	 */
	@GetMapping(value = {"", "/", "/employee-index"})
	public String displayEmployeeIndex(final Authentication authentication, final Model model) {
		
		final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<EmployeeProjectData> employeeProjectData = this.assignmentService.findByEmployeeId(userCredential.getEmployee().getEmployeeId());
		
		model.addAttribute("fnameAndLname", userCredential.getEmployee().getFirstName().toUpperCase() + " " + userCredential.getEmployee().getLastName().toUpperCase());
		model.addAttribute("employeeProjectData", employeeProjectData);
		
		return "employees/employee-index";
	}
	
	/**
	 * display employee-show-commits view to show all users' commits on a specific project by this url : /employee-show-all-commits
	 * @param projectId
	 * @param authentication
	 * @param model
	 * @return employee-show-commits
	 */
	@GetMapping(value = {"/employee-show-all-commits"})
	public String displayEmployeeShowAllCommits(@RequestParam("projectId") final String projectId, final Authentication authentication, final Model model) {
		
		// final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<ProjectCommit> allProjectCommits = this.assignmentService.findByProjectId(Integer.parseInt(projectId));
		final Project project = this.projectService.findById(Integer.parseInt(projectId));
		
		model.addAttribute("commits", allProjectCommits);
		model.addAttribute("project", project);
		
		return "employees/employee-show-commits";
	}
	
	/**
	 * display employee-show-commits view to show current user commits on a specific project by this url : /employee-show-my-commits
	 * @param projectId
	 * @param authentication
	 * @param model
	 * @return employee-show-commits
	 */
	@GetMapping(value = {"/employee-show-my-commits"})
	public String displayEmployeeShowMyCommits(@RequestParam("projectId") final String projectId, final Authentication authentication, final Model model) {
		
		// final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<ProjectCommit> myProjectCommits = this.assignmentService.findByEmployeeIdAndProjectId(this.userCredentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId(), Integer.parseInt(projectId));
		final Project project = this.projectService.findById(Integer.parseInt(projectId));
		
		model.addAttribute("commits", myProjectCommits);
		model.addAttribute("project", project);
		
		return "employees/employee-show-commits";
	}
	
	// TODO: implement correct logic to display employee-add-commit view
	@GetMapping(value = {"/employee-add-commit"})
	public String displayEmployeeAddCommit(final Model model) {
		model.addAttribute("", new Assignment());
		return "employees/employee-add-commit";
	}
	
	// TODO: implement correct logic to handle employee-add-commit view in order to commit a new work
	@PostMapping(value = {"/employee-add-commits"})
	public String handleEmployeeAddCommit(@RequestParam("projectId") final String projectId, final Authentication authentication, final Model model) {
		
		
		
		return "employees/employee-add-commit";
	}
	
	
	
}










