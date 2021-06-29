package com.pfa.pack.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfa.pack.model.dto.EmployeeProjectData;
import com.pfa.pack.model.dto.ManagerProjectData;
import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Employee;
import com.pfa.pack.service.AssignmentService;
import com.pfa.pack.service.EmployeeService;
import com.pfa.pack.service.ProjectService;

@RestController
@RequestMapping(value = {"/app/api/employees"})
public class EmployeeResource {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeResource.class);
	private final EmployeeService employeeService;
	private final AssignmentService assignmentService;
	private final ProjectService projectService;
	
	static {
		logger.info("************ entering " + EmployeeResource.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeResource(final EmployeeService service, final AssignmentService assignmentService, final ProjectService projectService) {
		this.employeeService = service;
		this.assignmentService = assignmentService;
		this.projectService = projectService;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<DtoCollection<Employee>> findAll() {
		return new ResponseEntity<>(this.employeeService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Employee> findById(@PathVariable("id") final String employeeId) {
		return new ResponseEntity<>(this.employeeService.findById(Integer.parseInt(employeeId)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Employee> save(@RequestBody final Employee employee) {
		return new ResponseEntity<>(this.employeeService.save(employee), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Employee> update(@RequestBody final Employee employee) {
		return new ResponseEntity<>(this.employeeService.update(employee), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public ResponseEntity<Boolean> deleteById(final String employeeId) {
		this.employeeService.deleteById(Integer.parseInt(employeeId));
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/username/{username}"})
	public ResponseEntity<Employee> findByUsername(@PathVariable("username") final String username) {
		return new ResponseEntity<>(this.employeeService.findByUsername(username), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"/username/{username}"})
	public ResponseEntity<Boolean> deleteByUsername(@PathVariable("username") final String username) {
		this.employeeService.deleteByUsername(username);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/data/employee-project-data/{employeeId}"})
	public ResponseEntity<DtoCollection<EmployeeProjectData>> findByEmployeeProjectDataEmployeeId(@PathVariable("employeeId") final String employeeId) {
		return new ResponseEntity<>(new DtoCollection<>(this.assignmentService.findByEmployeeId(Integer.parseInt(employeeId))), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/data/department/{departmentId}"})
	public ResponseEntity<DtoCollection<Employee>> findByDepartmentId(@PathVariable("departmentId") final String departmentId) {
		return new ResponseEntity<>(new DtoCollection<>(this.employeeService.findByDepartmentId(Integer.parseInt(departmentId))), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/data/manager-project-data/{employeeId}"})
	public ResponseEntity<DtoCollection<ManagerProjectData>> findManagerProjectDataByEmployeeId(@PathVariable("employeeId") final String employeeId) {
		return new ResponseEntity<>(new DtoCollection<>(this.projectService.findByEmployeeId(Integer.parseInt(employeeId))), HttpStatus.OK);
	}
	
	
	
}










