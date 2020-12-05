package com.pfa.pack.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.pfa.pack.models.dto.ChartData;
import com.pfa.pack.models.entities.Project;
import com.pfa.pack.services.EmployeeService;
import com.pfa.pack.services.ProjectService;

@Controller
@RequestMapping(value = {"/app/employees"})
public class EmployeeController {
	
	private final EmployeeService service;
	private final ProjectService projectService;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	static {
		logger.info("************ entering " + EmployeeController.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeController(final EmployeeService service, final ProjectService projectService) {
		this.service = service;
		this.projectService = projectService;
	}
	
	@GetMapping(value = {"/employee-index"})
	public String displayEmployeeIndex(final Model model) throws JsonProcessingException {
		
		final List<Project> projects = this.projectService.findAll().getProjects();
		final List<ChartData> projectData = this.projectService.getProjectStatus();
		
		final ObjectMapper mapper = new JsonMapper();
		final String jsonString = mapper.writeValueAsString(projectData);
		
		model.addAttribute("projectsList", projects);
		model.addAttribute("projectStatusCnt", jsonString);
		
		return "employees/employee-index";
	}
	
	
	
}










