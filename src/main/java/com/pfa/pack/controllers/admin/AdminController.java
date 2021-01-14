package com.pfa.pack.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/app/admins"})
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	static {
		logger.info("************ entering " + AdminController.class.getName() + " ************");
	}
	
	@GetMapping(value = {"", "/", "/admin-index"})
	public String displayAdminIndex() {
		return "admins/admin-index";
	}
	
	@GetMapping(value = {"/locations"})
	public String displayAdminLocationsList() {
		return "redirect:/app/admins/locations/admin-locations-list";
	}
	
	@GetMapping(value = {"/departments"})
	public String displayAdminDepartmentsList() {
		return "redirect:/app/admins/departments/admin-departments-list";
	}
	
	@GetMapping(value = {"/employees"})
	public String displayAdminEmployeesList() {
		return "redirect:/app/admins/employees/admin-employees-list";
	}
	
	
	
}










