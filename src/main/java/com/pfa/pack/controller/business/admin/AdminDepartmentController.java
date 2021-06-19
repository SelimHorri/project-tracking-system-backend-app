package com.pfa.pack.controller.business.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.pack.model.entity.Department;
import com.pfa.pack.service.DepartmentService;
import com.pfa.pack.service.LocationService;

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

	@GetMapping(value = {"/", "/admin-departments-list"})
	public String displayAdminDepartmentsList(final Model model) {
		
		model.addAttribute("departments", this.departmentService.findAll().getCollection());
		return "admins/departments/admin-departments-list";
	}
	
	@GetMapping(value = {"/admin-departments-add", "/add"})
	public String displayAdminDepartmentsAdd(final Model model) {
		
		model.addAttribute("listLocation", this.locationService.findAll().getCollection());
		model.addAttribute("department", new Department());
		return "admins/departments/admin-departments-add";
	}
	
	@PostMapping(value = {"/admin-departments-add", "/add"})
	public String handleAdminDepartmentsAdd(@ModelAttribute("department") final Department department, @RequestParam("locationId") final String locationId, final BindingResult error, final Model model) {
		
		if (error.hasErrors()) {
			model.addAttribute("listLocation", this.locationService.findAll().getCollection());
			model.addAttribute("department", new Department());
			model.addAttribute("msg", "Problem happened here, please check again !");
			model.addAttribute("msgColour", "danger");
			return "admins/departments/admin-departments-add";
		}
		
		department.setLocation(this.locationService.findById(Integer.parseInt(locationId)));
		
		this.departmentService.save(department);
		logger.info("department with departmentId : {} has been saved successfully", department.getDepartmentId());
		
		model.addAttribute("listLocation", this.locationService.findAll().getCollection());
		model.addAttribute("msg", "This department has been created successfully");
		model.addAttribute("msgColour", "success");
		
		return "admins/departments/admin-departments-add";
	}
	
	@GetMapping(value = {"/admin-departments-edit", "/edit"})
	public String displayAdminDepartmentsEdit(@RequestParam("departmentId") final String departmentId, final Model model) {
		
		model.addAttribute("department", this.departmentService.findById(Integer.parseInt(departmentId)));
		model.addAttribute("listLocation", this.locationService.findAll().getCollection());
		return "admins/departments/admin-departments-edit";
	}
	
	@PostMapping(value = {"/admin-departments-edit", "/edit"})
	public String handleAdminDepartmentsEdit(@ModelAttribute("department") final Department department, @RequestParam("locationId") final String locationId, final BindingResult error, final Model model) {
		
		if (error.hasErrors()) {
			model.addAttribute("listLocation", this.locationService.findAll().getCollection());
			model.addAttribute("msg", "Problem happened here, please check again !");
			model.addAttribute("msgColour", "danger");
			return "admins/departments/admin-departments-edit";
		}
		
		department.setLocation(this.locationService.findById(Integer.parseInt(locationId)));
		
		this.departmentService.update(department);
		logger.info("department with departmentId : {} has been modified successfully", department.getDepartmentId());
		
		model.addAttribute("listLocation", this.locationService.findAll().getCollection());
		model.addAttribute("msg", "This department has been modified successfully");
		model.addAttribute("msgColour", "success");
		
		return "admins/departments/admin-departments-edit";
	}
	
	@GetMapping(value = {"/admin-departments-delete", "/delete"})
	public String handleAdminDepartmentsDelete(@RequestParam("departmentId") final String departmentId) {
		
		this.departmentService.deleteById(Integer.parseInt(departmentId));
		logger.info("Department with departmentId : {} has been removed successfully", departmentId);
		
		return "redirect:/app/admins/departments/admin-departments-list";
	}
	
	
	
}













