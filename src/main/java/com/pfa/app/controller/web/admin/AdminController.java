package com.pfa.app.controller.web.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.app.model.entity.Employee;
import com.pfa.app.service.CredentialService;
import com.pfa.app.service.EmployeeService;

@Controller
@RequestMapping(value = {"/admins"})
public class AdminController {
	
	private final EmployeeService employeeService;
	private final CredentialService credentialService;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	static {
		logger.info("************* entering " + AdminController.class.getName() + " *************");
	}
	
	@Autowired
	public AdminController(final EmployeeService employeeService, final CredentialService credentialService) {
		this.employeeService = employeeService;
		this.credentialService = credentialService;
	}
	
	@GetMapping(value = {"", "/", "/admin-index"})
	public String displayAdminIndex() {
		return "admins/admin-index";
	}
	
	@GetMapping(value = {"/admin-info"})
	public String displayManagerInfo(final Authentication authentication, final Model model) {
		
		final Employee admin = this.employeeService.findById(this.credentialService.findByUsername(authentication.getName()).getEmployee().getEmployeeId());
		model.addAttribute("a", admin);
		
		return "admins/admin-info";
	}
	
	@GetMapping(value = {"/locations"})
	public String displayAdminLocationsList() {
		return "redirect:/admins/locations/admin-locations-list";
	}
	
	@GetMapping(value = {"/departments"})
	public String displayAdminDepartmentsList() {
		return "redirect:/admins/departments/admin-departments-list";
	}
	
	@GetMapping(value = {"/employees"})
	public String displayAdminEmployeesList() {
		return "redirect:/admins/employees/admin-employees-list";
	}
	
	
	
}










