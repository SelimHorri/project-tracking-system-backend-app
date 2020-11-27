package com.pfa.pack.controllers.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.pfa.pack.models.collectionwrappers.AssignmentsCollection;
import com.pfa.pack.models.entities.Assignment;
import com.pfa.pack.services.AssignmentService;

@RestController
@RequestMapping(value = {"/app/api/assignments"})
public class AssignmentRESTController {
	
	private final AssignmentService service;
	
	@Autowired
	public AssignmentRESTController(final AssignmentService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<AssignmentsCollection> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	// need to be tested
	@GetMapping(value = {"/{employeeId}/{projectId}/{commitDate}"})
	public ResponseEntity<Assignment> findByCompositeIds(@PathVariable("employeeId") final String employeeId, 
														 @PathVariable("projectId") final String projectId,
														 @PathVariable("commitDate") @DateTimeFormat(pattern = "dd-MM-yyyy#HH:mm:ss") final String commitDate
												  		) {
		final int id1 = Integer.parseInt(employeeId);
		final int id2 = Integer.parseInt(projectId);
		return new ResponseEntity<>(this.service.findByCompositeIds(id1, id2, LocalDateTime.parse(commitDate)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Assignment> save(@RequestBody final Assignment assignment) {
		return new ResponseEntity<>(this.service.save(assignment), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Assignment> update(@RequestBody final Assignment assignment) {
		return new ResponseEntity<>(this.service.update(assignment), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public void delete(@PathVariable("employeeId") final String employeeId, @PathVariable("projectId") final String projectId, @PathVariable("commitDate") @DateTimeFormat(pattern = "dd-MM-yyyy") final LocalDateTime commitDate) {
		final int id1 = Integer.parseInt(employeeId);
		final int id2 = Integer.parseInt(projectId);
		
		this.service.delete(id1, id2, commitDate);
	}
	
	
	
}











