package com.pfa.pack.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.DepartmentService;
import com.pfa.pack.services.EmployeeService;

@Controller
@RequestMapping(value = {"/app/admins/departments"})
public class AdminDepartmentController {
	
	private final EmployeeService employeeService;
	private final DepartmentService departmentService;
	private static final Logger logger = LoggerFactory.getLogger(AdminDepartmentController.class);
	
	static {
		logger.info("************ entering " + AdminDepartmentController.class.getName() + " ************");
	}
	
	@Autowired
	public AdminDepartmentController(final EmployeeService employeeService, final DepartmentService departmentService) {
		this.employeeService = employeeService;
		this.departmentService = departmentService;
	}

	@GetMapping(value = {"", "/", "/admin-departments-list"})
	public String displayAdminDepartmentsList(final Model model) {
		model.addAttribute("departments", this.departmentService.findAll().getDepartments());
		return "admins/departments/admin-departments-list";
	}
	
	@GetMapping(value = {"/admin-departments-add", "/add"})
	public String displayAdminDepartmentsAdd() {
		
		
		
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













