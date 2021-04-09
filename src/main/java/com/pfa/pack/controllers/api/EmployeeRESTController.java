package com.pfa.pack.controllers.api;

import java.util.List;

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

import com.pfa.pack.models.collectionwrappers.EmployeesCollection;
import com.pfa.pack.models.dto.EmployeeProjectData;
import com.pfa.pack.models.entities.Employee;
import com.pfa.pack.services.AssignmentService;
import com.pfa.pack.services.EmployeeService;

@RestController
@RequestMapping(value = {"/app/api/employees"})
public class EmployeeRESTController {
	
	private final EmployeeService employeeService;
	private final AssignmentService assignmentService;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRESTController.class);
	
	static {
		logger.info("************ entering " + EmployeeRESTController.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeRESTController(final EmployeeService service, final AssignmentService assignmentService) {
		this.employeeService = service;
		this.assignmentService = assignmentService;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<EmployeesCollection> findAll() {
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
	public void delete(final String employeeId) {
		this.employeeService.delete(Integer.parseInt(employeeId));
	}
	
	@GetMapping(value = {"/display-projects/{employeeId}"})
	public ResponseEntity<List<EmployeeProjectData>> findByEmployeeId(@PathVariable("employeeId") final String employeeId) {
		return new ResponseEntity<>(this.assignmentService.findByEmployeeId(Integer.parseInt(employeeId)), HttpStatus.OK);
	}
	
	
	
}











