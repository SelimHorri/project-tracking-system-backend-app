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

import com.pfa.pack.model.collection.DepartmentsCollection;
import com.pfa.pack.model.entity.Department;
import com.pfa.pack.service.DepartmentService;

@RestController
@RequestMapping(value = {"/app/api/departments"})
public class DepartmentRESTController {
	
	private final DepartmentService service;
	private static final Logger logger = LoggerFactory.getLogger(DepartmentRESTController.class);
	
	static {
		logger.info("************ entering " + DepartmentRESTController.class.getName() + " ************");
	}
	
	@Autowired
	public DepartmentRESTController(final DepartmentService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<DepartmentsCollection> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Department> findById(@PathVariable("id") final String departmentId) {
		return new ResponseEntity<>(this.service.findById(Integer.parseInt(departmentId)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Department> save(@RequestBody final Department department) {
		return new ResponseEntity<>(this.service.save(department), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Department> update(@RequestBody final Department department) {
		return new ResponseEntity<>(this.service.update(department), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public void delete(final String departmentId) {
		this.service.delete(Integer.parseInt(departmentId));
	}
	
	
	
}











