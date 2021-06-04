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
import com.pfa.pack.model.entity.Department;
import com.pfa.pack.service.DepartmentService;

@RestController
@RequestMapping(value = {"/app/api/departments"})
public class DepartmentResource {
	
	private final DepartmentService departmentService;
	private static final Logger logger = LoggerFactory.getLogger(DepartmentResource.class);
	
	static {
		logger.info("************ entering " + DepartmentResource.class.getName() + " ************");
	}
	
	@Autowired
	public DepartmentResource(final DepartmentService service) {
		this.departmentService = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<DtoCollection<Department>> findAll() {
		return new ResponseEntity<>(this.departmentService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Department> findById(@PathVariable("id") final String departmentId) {
		return new ResponseEntity<>(this.departmentService.findById(Integer.parseInt(departmentId)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Department> save(@RequestBody final Department department) {
		return new ResponseEntity<>(this.departmentService.save(department), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Department> update(@RequestBody final Department department) {
		return new ResponseEntity<>(this.departmentService.update(department), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public ResponseEntity<Boolean> deleteById(final String departmentId) {
		this.departmentService.deleteById(Integer.parseInt(departmentId));
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
	
}











