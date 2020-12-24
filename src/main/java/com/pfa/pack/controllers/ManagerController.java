package com.pfa.pack.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.pack.enums.StatusEnum;
import com.pfa.pack.models.dto.ManagerProjectData;
import com.pfa.pack.models.dto.ProjectDTO;
import com.pfa.pack.models.entities.Assignment;
import com.pfa.pack.models.entities.Employee;
import com.pfa.pack.models.entities.Project;
import com.pfa.pack.models.entities.UserCredential;
import com.pfa.pack.services.AssignmentService;
import com.pfa.pack.services.EmployeeService;
import com.pfa.pack.services.ProjectService;
import com.pfa.pack.services.UserCredentialService;

@Controller
@RequestMapping(value = {"/app/managers"})
public class ManagerController {
	
	private final EmployeeService employeeService;
	private final UserCredentialService userCredentialService;
	private final AssignmentService assignmentService;
	private final ProjectService projectService;
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	static {
		logger.info("************ entering " + ManagerController.class.getName() + " ************");
	}
	
	@Autowired
	public ManagerController(final EmployeeService employeeService, final UserCredentialService userCredentialService, final AssignmentService assignmentService, final ProjectService projectService) {
		this.employeeService = employeeService;
		this.userCredentialService = userCredentialService;
		this.assignmentService = assignmentService;
		this.projectService = projectService;
	}
	
	@GetMapping(value = {"", "/", "/manager-index"})
	public String displayManagerIndex(final Authentication authentication, final Model model) {
		
		final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<ManagerProjectData> managerProjectDatas = this.projectService.findByEmployeeId(userCredential.getEmployee().getEmployeeId());
		
		model.addAttribute("fname", userCredential.getEmployee().getFirstName().toUpperCase().charAt(0) + userCredential.getEmployee().getFirstName().toLowerCase().substring(1));
		model.addAttribute("lname", userCredential.getEmployee().getLastName().toUpperCase().charAt(0) + userCredential.getEmployee().getLastName().toLowerCase().substring(1));
		model.addAttribute("managerProjectDatas", managerProjectDatas);
		
		return "managers/manager-index";
	}
	
	@GetMapping(value = {"/manager-info"})
	public String displayManagerInfo(final Authentication authentication, final Model model) {
		
		final Employee manager = this.employeeService.findById(this.userCredentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId());
		model.addAttribute("m", manager);
		
		return "managers/manager-info";
	}
	
	@GetMapping(value = {"/manager-team"})
	public String displayManagerTeam(final Authentication authentication, final Model model) {
		
		final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<Employee> team = this.employeeService.findByDepartmentId(userCredential.getEmployee().getDepartment().getDepartmentId());
		
		model.addAttribute("team", team);
		
		return "managers/manager-team";
	}
	
	@GetMapping(value = {"/manager-add-project"})
	public String displayManagerAddProject(final Authentication authentication, final Model model) {
		
		final List<Employee> managerSubEmployees = this.employeeService.findByManagerId(this.userCredentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId());
		
		model.addAttribute("listStatus", StatusEnum.values());
		model.addAttribute("managerSubEmployees", managerSubEmployees);
		model.addAttribute("username", authentication.getName());
		model.addAttribute("project", new Project());
		
		return "managers/manager-add-project";
	}
	
	@PostMapping(value = {"/manager-add-project"})
	public String handleManagerAddProject(@ModelAttribute("project") @Valid final ProjectDTO projectDTO, final BindingResult error, final Authentication authentication, final Model model) {
		
		final List<Employee> managerSubEmployees = this.employeeService.findByManagerId(this.userCredentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId());
		
		// to check of binding variables
		if (error.hasErrors()) {
			logger.error("----------ERROR Binding object----------");
			System.err.println(error);
			model.addAttribute("username", authentication.getName());
			model.addAttribute("listStatus", StatusEnum.values());
			model.addAttribute("managerSubEmployees", managerSubEmployees);
			model.addAttribute("msg", "Something went wrong !! ");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-add-project";
		}
		
		// to check the selection of one employee at least
		if (projectDTO.getAssignedEmployees() == null) {
			model.addAttribute("username", authentication.getName());
			model.addAttribute("listStatus", StatusEnum.values());
			model.addAttribute("managerSubEmployees", managerSubEmployees);
			model.addAttribute("msg", "Please you have to assign one employee at least to create the project");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-add-project"; 
		}
		
		final LocalDate startDate = LocalDate.parse(projectDTO.getStartDate());
		final LocalDate endDate = LocalDate.parse(projectDTO.getEndDate());
		
		// to check if the end date is after the start date
		if (startDate.isAfter(endDate)) {
			model.addAttribute("username", authentication.getName());
			model.addAttribute("listStatus", StatusEnum.values());
			model.addAttribute("managerSubEmployees", managerSubEmployees);
			model.addAttribute("msg", "EndDate is before StartDate! please check again...");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-add-project";
		}
		
		// successful output msg
		final String msg = "project " + projectDTO.getTitle() + " created successfully";
		
		// persist a new project in DB
		final Project project = this.projectService.save(projectDTO);
		logger.info(msg);
		
		// print the list of the assigned employees' ids
		System.err.println(projectDTO.getAssignedEmployees());
		
		// assign checked employees to the already created project
		final Assignment assignment = new Assignment();
		projectDTO.getAssignedEmployees().forEach((employeeId) -> {
			assignment.setEmployeeId(Integer.parseInt(employeeId));
			assignment.setProjectId(project.getProjectId());
			assignment.setCommitMgrDesc("init"); // 'init' to tell this is the assignment
			assignment.setEmployee(this.employeeService.findById(Integer.parseInt(employeeId)));
			assignment.setProject(project);
			this.assignmentService.save(assignment);
			logger.info("employeeId : {} is assigned to this project with projectId : {}", employeeId, project.getProjectId());
		});
		
		model.addAttribute("msg", msg);
		model.addAttribute("assignMsg", "employees assigned successfully to this project");
		model.addAttribute("msgColour", "success");
		
		return "managers/manager-add-project";
	}
	
	@GetMapping(value = {"/manager-delete-project"})
	public String handleManagerDeleteProject(@RequestParam("projectId") final String projectId, final Model model) {
		
		this.assignmentService.deleteByProjectId(Integer.parseInt(projectId));
		logger.warn("assignments with projectId = {} are deleted", projectId);
		
		this.projectService.deleteById(Integer.parseInt(projectId));
		logger.warn("project with its projectId = {} is deleted", projectId);
		
		return "redirect:/app/managers/manager-index";
	}
	
	
	
}










