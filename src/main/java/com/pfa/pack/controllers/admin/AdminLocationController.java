package com.pfa.pack.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.EmployeeService;
import com.pfa.pack.services.LocationService;

@Controller
@RequestMapping(value = {"/app/admins/locations"})
public class AdminLocationController {
	
	private final EmployeeService employeeService;
	private final LocationService locationService;
	private static final Logger logger = LoggerFactory.getLogger(AdminLocationController.class);
	
	static {
		logger.info("************ entering " + AdminLocationController.class.getName() + " ************");
	}
	
	@Autowired
	public AdminLocationController(final EmployeeService employeeService, final LocationService locationService) {
		this.employeeService = employeeService;
		this.locationService = locationService;
	}
	
	@GetMapping(value = {"", "/", "/admin-locations-list"})
	public String displayAdminLocationsList() {
		
		
		
		return "admins/locations/admin-locations-list";
	}
	
	@GetMapping(value = {"/admin-locations-add", "/add"})
	public String displayAdminLocationsAdd() {
		
		
		
		return "admins/locations/admin-locations-add";
	}
	
	@PostMapping(value = {"/admin-locations-add"})
	public String handleAdminLocationsAdd() {
		
		
		
		return "admins/locations/admin-locations-add";
	}
	
	@GetMapping(value = {"/admin-locations-edit", "/edit"})
	public String displayAdminLocationsEdit() {
		
		
		
		return "admins/locations/admin-locations-edit";
	}
	
	@PostMapping(value = {"/admin-locations-edit"})
	public String handleAdminLocationsEdit() {
		
		
		
		return "admins/locations/admin-locations-edit";
	}
	
	
	
}













