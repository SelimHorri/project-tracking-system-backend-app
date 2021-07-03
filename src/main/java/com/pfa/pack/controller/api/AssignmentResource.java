package com.pfa.pack.controller.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

import com.pfa.pack.model.dto.ProjectCommit;
import com.pfa.pack.model.dto.collection.DtoCollection;
import com.pfa.pack.model.entity.Assignment;
import com.pfa.pack.service.AssignmentService;

@RestController
@RequestMapping(value = {"/app/api/assignments"})
public class AssignmentResource {
	
	private final AssignmentService assignmentService;
	private static final Logger logger = LoggerFactory.getLogger(AssignmentResource.class);
	
	static {
		logger.info("************ entering " + AssignmentResource.class.getName() + " ************");
	}
	
	@Autowired
	public AssignmentResource(final AssignmentService service) {
		this.assignmentService = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<DtoCollection<Assignment>> findAll() {
		return new ResponseEntity<>(this.assignmentService.findAll(), HttpStatus.OK);
	}
	
	// need to be tested
	@GetMapping(value = {"/{employeeId}/{projectId}/{commitDate}"})
	public ResponseEntity<Assignment> findById(@PathVariable("employeeId") final String employeeId, @PathVariable("projectId") final String projectId, @PathVariable("commitDate") final String commitDate) {
		return new ResponseEntity<>(this.assignmentService.findById(Integer.parseInt(employeeId), Integer.parseInt(projectId), LocalDateTime.parse(commitDate, DateTimeFormatter.ofPattern("dd-MM-yyyyHH:mm:ss"))), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Assignment> save(@RequestBody final Assignment assignment) {
		return new ResponseEntity<>(this.assignmentService.save(assignment), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Assignment> update(@RequestBody final Assignment assignment) {
		return new ResponseEntity<>(this.assignmentService.update(assignment), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"/{employeeId}/{projectId}/{commitDate}", "/delete/{employeeId}/{projectId}/{commitDate}"})
	public ResponseEntity<?> deleteById(@PathVariable("employeeId") final String employeeId, @PathVariable("projectId") final String projectId, @PathVariable("commitDate") final String commitDate) {
		this.assignmentService.deleteById(Integer.parseInt(employeeId), Integer.parseInt(projectId), LocalDateTime.parse(commitDate, DateTimeFormatter.ofPattern("dd-MM-yyyyHH:mm:ss")));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// TODO: create this method in order to get a list of assignment by employeeId & managerId
	@GetMapping(value = {"/{employeeId}/{projectId}"})
	public ResponseEntity<DtoCollection<Assignment>> findAllByEmployeeIdAndManagerId(@PathVariable("employeeId") final String employeeId, @PathVariable("projectId") final String managerId) {
		return new ResponseEntity<>(null, null);
	}
	
	@GetMapping(value = {"/data/project-commit/{projectId}"})
	public ResponseEntity<DtoCollection<ProjectCommit>> findByProjectId(@PathVariable("projectId") final String projectId) {
		return ResponseEntity.ok(new DtoCollection<>(this.assignmentService.findByProjectId(Integer.parseInt(projectId))));
	}
	
	@GetMapping(value = {"/data/project-commit/{employeeId}/{projectId}"})
	public ResponseEntity<DtoCollection<ProjectCommit>> findByEmployeeIdAndProjectId(@PathVariable("employeeId")final String employeeId, @PathVariable("projectId") String projectId) {
		return ResponseEntity.ok(new DtoCollection<>(this.assignmentService.findByEmployeeIdAndProjectId(Integer.parseInt(employeeId), Integer.parseInt(projectId))));
	}
	
	@GetMapping(value = {"/data/project-commit/{employeeId}/{projectId}/{commitDate}"})
	public ResponseEntity<ProjectCommit> findByEmployeeIdAndProjectIdAndCommitDate(@PathVariable("employeeId")final String employeeId, @PathVariable("projectId") String projectId, @PathVariable("commitDate") final String commitDate) {
		return ResponseEntity.ok(this.assignmentService.findByEmployeeIdAndProjectIdAndCommitDate(Integer.parseInt(employeeId), Integer.parseInt(projectId), LocalDateTime.parse(commitDate, DateTimeFormatter.ofPattern("dd-MM-yyyyHH:mm:ss"))));
	}
	
	
	
}











