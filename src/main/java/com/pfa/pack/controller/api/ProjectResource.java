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
import com.pfa.pack.model.entity.Project;
import com.pfa.pack.service.ProjectService;

@RestController
@RequestMapping(value = {"/app/api/projects"})
public class ProjectResource {
	
	private final ProjectService projectService;
	private static final Logger logger = LoggerFactory.getLogger(ProjectResource.class);
	
	static {
		logger.info("************ entering " + ProjectResource.class.getName() + " ************");
	}
	
	@Autowired
	public ProjectResource(final ProjectService service) {
		this.projectService = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<DtoCollection<Project>> findAll() {
		return new ResponseEntity<>(this.projectService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Project> findById(@PathVariable("id") final String projectId) {
		return new ResponseEntity<>(this.projectService.findById(Integer.parseInt(projectId)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Project> save(@RequestBody final Project project) {
		return new ResponseEntity<>(this.projectService.save(project), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Project> update(@RequestBody final Project project) {
		return new ResponseEntity<>(this.projectService.update(project), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public void deleteById(final String projectId) {
		this.projectService.deleteById(Integer.parseInt(projectId));
	}
	
	
	
}











