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
import com.pfa.pack.model.entity.Credential;
import com.pfa.pack.service.CredentialService;

@RestController
@RequestMapping(value = {"/app/api/credentials"})
public class CredentialResource {
	
	private final CredentialService service;
	private static final Logger logger = LoggerFactory.getLogger(CredentialResource.class);
	
	static {
		logger.info("************ entering " + CredentialResource.class.getName() + " ************");
	}
	
	@Autowired
	public CredentialResource(final CredentialService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<DtoCollection<Credential>> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Credential> findById(@PathVariable("id") final String userCredentialId) {
		return new ResponseEntity<>(this.service.findById(Integer.parseInt(userCredentialId)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Credential> save(@RequestBody final Credential credential) {
		return new ResponseEntity<>(this.service.save(credential), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Credential> update(@RequestBody final Credential credential) {
		return new ResponseEntity<>(this.service.update(credential), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public void delete(final String userCredentialId) {
		this.service.delete(Integer.parseInt(userCredentialId));
	}
	
	
	
}











