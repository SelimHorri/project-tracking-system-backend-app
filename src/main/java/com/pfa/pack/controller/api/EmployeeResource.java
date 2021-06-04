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

import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Employee;
import com.pfa.pack.service.EmployeeService;

@RestController
@RequestMapping(value = {"/app/api/employees"})
public class EmployeeResource {
	
	private final EmployeeService service;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeResource.class);
	
	static {
		logger.info("************ entering " + EmployeeResource.class.getName() + " ************");
	}
	
	@Autowired
	public EmployeeResource(final EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<DtoCollection<Employee>> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Employee> findById(@PathVariable("id") final String employeeId) {
		return new ResponseEntity<>(this.service.findById(Integer.parseInt(employeeId)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Employee> save(@RequestBody final Employee employee) {
		return new ResponseEntity<>(this.service.save(employee), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Employee> update(@RequestBody final Employee employee) {
		return new ResponseEntity<>(this.service.update(employee), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public void delete(final String employeeId) {
		this.service.delete(Integer.parseInt(employeeId));
	}
	
	
	
}










