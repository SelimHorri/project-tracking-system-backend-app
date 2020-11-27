package com.pfa.pack.controllers.api;

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

import com.pfa.pack.models.collectionwrappers.UserCredentialsCollection;
import com.pfa.pack.models.entities.UserCredential;
import com.pfa.pack.services.UserCredentialService;

@RestController
@RequestMapping(value = {"/app/api/userCredentials"})
public class UserCredentialRESTController {
	
	private final UserCredentialService service;
	
	@Autowired
	public UserCredentialRESTController(final UserCredentialService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<UserCredentialsCollection> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<UserCredential> findById(@PathVariable("id") final String userCredentialId) {
		return new ResponseEntity<>(this.service.findById(Integer.parseInt(userCredentialId)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<UserCredential> save(@RequestBody final UserCredential userCredential) {
		return new ResponseEntity<>(this.service.save(userCredential), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<UserCredential> update(@RequestBody final UserCredential userCredential) {
		return new ResponseEntity<>(this.service.update(userCredential), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public void delete(final String userCredentialId) {
		this.service.delete(Integer.parseInt(userCredentialId));
	}
	
	
	
}











