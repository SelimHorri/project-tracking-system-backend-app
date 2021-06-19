package com.pfa.pack.controller.business.admin;

import javax.validation.Valid;

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

import com.pfa.pack.constant.AccountEnum;
import com.pfa.pack.model.entity.Employee;
import com.pfa.pack.model.entity.Credential;
import com.pfa.pack.service.EmployeeService;
import com.pfa.pack.service.CredentialService;

@Controller
@RequestMapping(value = {"/app/admins/employees"})
public class AdminEmployeeController {
	
	private final EmployeeService employeeService;
	private final CredentialService credentialService;
	private static final Logger logger = LoggerFactory.getLogger(AdminEmployeeController.class);
	
	static {
		logger.info("************ entering " + AdminEmployeeController.class.getName() + " ************");
	}
	
	@Autowired
	public AdminEmployeeController(final EmployeeService employeeService, final CredentialService credentialService) {
		this.employeeService = employeeService;
		this.credentialService = credentialService;
	}
	
	@GetMapping(value = {"/admin-employee-credentials", "/credentials"})
	public String displayAdminEmployeeCredentialsList(@RequestParam("userId") final String userId, final Model model) {
		
		model.addAttribute("userCredential", this.credentialService.findById(Integer.parseInt(userId)));
		return "admins/employees/admin-employee-credentials";
	}
	
	@GetMapping(value = {"/", "/admin-employees-list"})
	public String displayAdminEmployeesList(final Model model) {
		
		model.addAttribute("employees", this.employeeService.findAll().getCollection());
		return "admins/employees/admin-employees-list";
	}
	
	@GetMapping(value = {"/admin-employees-add", "/add"})
	public String displayAdminEmployeesAdd(final Model model) {
		
		model.addAttribute("employee", new Employee());
		model.addAttribute("listManager", this.employeeService.findAllManagers());
		model.addAttribute("roles", AccountEnum.values());
		return "admins/employees/admin-employees-add";
	}
	
	@PostMapping(value = {"/admin-employees-add"})
	public String handleAdminEmployeesAdd(@ModelAttribute("employee") @Valid final Employee employee, final BindingResult error, final Model model) {
		
		if (error.hasErrors()) {
			model.addAttribute("listManager", this.employeeService.findAllManagers());
			model.addAttribute("roles", AccountEnum.values());
			model.addAttribute("msg", "Problem happened here, please check again !");
			model.addAttribute("msgColour", "danger");
		}
		
		this.employeeService.save(employee);
		logger.info("Employee with employeeId : {} has been saved successfully", employee.getEmployeeId());
		
		model.addAttribute("listManager", this.employeeService.findAllManagers());
		model.addAttribute("roles", AccountEnum.values());
		model.addAttribute("msg", "This employee has been created successfully");
		model.addAttribute("msgColour", "success");
		
		return "admins/employees/admin-employees-add";
	}
	
	@GetMapping(value = {"/admin-employees-edit", "/edit"})
	public String displayAdminEmployeesEdit(@RequestParam("employeeId") final String employeeId, final Model model) {
		
		model.addAttribute("employee", this.employeeService.findById(Integer.parseInt(employeeId)));
		model.addAttribute("listManager", this.employeeService.findAllManagers());
		model.addAttribute("roles", AccountEnum.values());
		return "admins/employees/admin-employees-edit";
	}
	
	@PostMapping(value = {"/admin-employees-edit"})
	public String handleAdminEmployeesEdit(@ModelAttribute("employee") @Valid final Employee employee, final BindingResult error, final Model model) {
		
		if (error.hasErrors()) {
			model.addAttribute("employee", this.employeeService.findById(employee.getEmployeeId()));
			model.addAttribute("listManager", this.employeeService.findAllManagers());
			model.addAttribute("roles", AccountEnum.values());
			return "admins/employees/admin-employees-edit";
		}
		
		this.employeeService.update(employee);
		logger.info("Employee with employeeId : {} has been updated successfully", employee.getEmployeeId());
		
		model.addAttribute("listManager", this.employeeService.findAllManagers());
		model.addAttribute("roles", AccountEnum.values());
		model.addAttribute("msg", "This employee has been updated successfully");
		model.addAttribute("msgColour", "success");
		
		return "admins/employees/admin-employees-edit";
	}
	
	@GetMapping(value = {"/admin-employees-isactive", "/isactive"})
	public String handleAdminEmployeesInActive(@RequestParam("employeeId") final String employeeId) {
		
		final Credential credential = this.employeeService.findById(Integer.parseInt(employeeId)).getCredential();
		credential.setEnabled(!credential.getEnabled());
		
		this.credentialService.save(credential);
		logger.info("Employee with employeeId : {} has been enabled/disabled successfully", credential.getEmployee().getEmployeeId());
		
		return "redirect:/app/admins/employees/admin-employees-list";
	}
	
	@GetMapping(value = {"/admin-employees-delete", "/delete"})
	public String handleAdminEmployeesDelete(@RequestParam("employeeId") final String employeeId) {
		
		this.employeeService.deleteById(Integer.parseInt(employeeId));
		logger.info("Employee with employeeId : {} has been removed successfully", employeeId);
		
		return "redirect:/app/admins/employees/admin-employees-list";
	}
	
	
	
}













