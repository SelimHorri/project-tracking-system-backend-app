package com.pfa.pack.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.EmployeeService;
import com.pfa.pack.services.UserCredentialService;

@Controller
@RequestMapping(value = {"/app/admins/employees"})
public class AdminEmployeeController {
	
	private final EmployeeService employeeService;
	private final UserCredentialService userCredentialService;
	private static final Logger logger = LoggerFactory.getLogger(AdminEmployeeController.class);
	
	static {
		logger.info("************ entering " + AdminEmployeeController.class.getName() + " ************");
	}
	
	@Autowired
	public AdminEmployeeController(final EmployeeService employeeService, final UserCredentialService userCredentialService) {
		this.employeeService = employeeService;
		this.userCredentialService = userCredentialService;
	}
	
	@GetMapping(value = {"", "/", "/admin-employees-list"})
	public String displayAdminEmployeesList(final Model model) {
		model.addAttribute("employees", this.employeeService.findAll().getEmployees());
		return "admins/employees/admin-employees-list";
	}
	
	@GetMapping(value = {"/admin-employees-add", "/add"})
	public String displayAdminEmployeesAdd() {
		
		
		
		return "admins/employees/admin-employees-add";
	}
	
	@PostMapping(value = {"/admin-employees-add"})
	public String handleAdminEmployeesAdd() {
		
		
		
		return "admins/employees/admin-employees-add";
	}
	
	@GetMapping(value = {"/admin-employees-edit", "/edit"})
	public String displayAdminEmployeesEdit() {
		
		
		
		return "admins/employees/admin-employees-edit";
	}
	
	@PostMapping(value = {"/admin-employees-edit"})
	public String handleAdminEmployeesEdit() {
		
		
		
		return "admins/employees/admin-employees-edit";
	}
	
	
	
}













