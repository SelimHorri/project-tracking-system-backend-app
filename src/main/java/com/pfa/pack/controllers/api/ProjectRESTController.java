package com.pfa.pack.controllers.api;

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

import com.pfa.pack.models.collectionwrappers.ProjectsCollection;
import com.pfa.pack.models.entities.Project;
import com.pfa.pack.services.ProjectService;

@RestController
@RequestMapping(value = {"/app/api/projects"})
public class ProjectRESTController {
	
	private final ProjectService service;
	private static final Logger logger = LoggerFactory.getLogger(ProjectRESTController.class);
	
	static {
		logger.info("************ entering " + ProjectRESTController.class.getName() + " ************");
	}
	
	@Autowired
	public ProjectRESTController(final ProjectService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<ProjectsCollection> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Project> findById(@PathVariable("id") final String projectId) {
		return new ResponseEntity<>(this.service.findById(Integer.parseInt(projectId)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Project> save(@RequestBody final Project project) {
		return new ResponseEntity<>(this.service.save(project), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Project> update(@RequestBody final Project project) {
		return new ResponseEntity<>(this.service.update(project), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public void delete(final String projectId) {
		this.service.delete(Integer.parseInt(projectId));
	}
	
	
	
}











