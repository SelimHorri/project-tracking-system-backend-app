package com.pfa.pack.controllers;

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

import com.pfa.pack.converters.ProjectDtoProjectConverter;
import com.pfa.pack.models.dto.ManagerProjectData;
import com.pfa.pack.models.dto.ProjectDTO;
import com.pfa.pack.models.entities.Project;
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
	private final ProjectDtoProjectConverter projectDtoProjectConverter;
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	static {
		logger.info("************ entering " + ManagerController.class.getName() + " ************");
	}
	
	@Autowired
	public ManagerController(final EmployeeService employeeService, final UserCredentialService userCredentialService, final ProjectService projectService, final ProjectDtoProjectConverter projectDtoProjectConverter) {
		this.employeeService = employeeService;
		this.userCredentialService = userCredentialService;
		this.projectService = projectService;
		this.projectDtoProjectConverter = projectDtoProjectConverter;
	}
	
	@GetMapping(value = {"", "/", "/manager-index"})
	public String displayManagerIndex(final Authentication authentication, final Model model) {
		
		final UserCredential userCredential = this.userCredentialService.findByUsername(authentication.getName());
		final List<ManagerProjectData> managerProjectDatas = this.projectService.findByEmployeeId(userCredential.getEmployee().getEmployeeId());
		
		model.addAttribute("managerProjectDatas", managerProjectDatas);
		
		return "managers/manager-index";
	}
	
	@GetMapping(value = {"/manager-add-project"})
	public String displayManagerAddProject(final Authentication authentication, final Model model) {
		
		model.addAttribute("username", authentication.getName());
		model.addAttribute("project", new Project());
		
		return "managers/manager-add-project";
	}
	
	@PostMapping(value = {"/manager-add-project"})
	public String handleManagerAddProject(@ModelAttribute("project") @Valid final ProjectDTO projectDTO, final BindingResult error, final Authentication authentication, final Model model) {
		
		if (error.hasErrors()) {
			System.err.println(error);
			model.addAttribute("username", authentication.getName());
			model.addAttribute("msg", "Something went wrong !! ");
			model.addAttribute("msgColour", "danger");
			return "managers/manager-add-project";
		}
		
		final Project project = this.projectService.save(projectDTO);
		System.out.println(project);
		
		model.addAttribute("msg", "project " + project.getTitle() + " created successfully");
		model.addAttribute("msgColour", "success");
		
		return "managers/manager-add-project";
	}
	
	
	
}










