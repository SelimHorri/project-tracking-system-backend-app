package com.pfa.pack.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.models.entities.Department;
import com.pfa.pack.services.DepartmentService;
import com.pfa.pack.services.LocationService;

@Controller
@RequestMapping(value = {"/app/admins/departments"})
public class AdminDepartmentController {
	
	private final DepartmentService departmentService;
	private final LocationService locationService;
	private static final Logger logger = LoggerFactory.getLogger(AdminDepartmentController.class);
	
	static {
		logger.info("************ entering " + AdminDepartmentController.class.getName() + " ************");
	}
	
	@Autowired
	public AdminDepartmentController(final DepartmentService departmentService, final LocationService locationService) {
		this.departmentService = departmentService;
		this.locationService = locationService;
	}

	@GetMapping(value = {"", "/", "/admin-departments-list"})
	public String displayAdminDepartmentsList(final Model model) {
		
		model.addAttribute("departments", this.departmentService.findAll().getDepartments());
		return "admins/departments/admin-departments-list";
	}
	
	@GetMapping(value = {"/admin-departments-add", "/add"})
	public String displayAdminDepartmentsAdd(final Model model) {
		
		model.addAttribute("listLocation", this.locationService.findAll().getLocations());
		model.addAttribute("department", new Department());
		return "admins/departments/admin-departments-add";
	}
	
	@PostMapping(value = {"/admin-departments-add"})
	public String handleAdminDepartmentsAdd() {
		
		
		
		return "admins/departments/admin-departments-add";
	}
	
	@GetMapping(value = {"/admin-departments-edit", "/edit"})
	public String displayAdminDepartmentsEdit() {
		
		
		
		return "admins/departments/admin-departments-edit";
	}
	
	@PostMapping(value = {"/admin-departments-edit"})
	public String handleAdminDepartmentsEdit() {
		
		
		
		return "admins/departments/admin-departments-edit";
	}
	
	
	
}













