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

import com.pfa.pack.model.collection.LocationsCollection;
import com.pfa.pack.model.entity.Location;
import com.pfa.pack.service.LocationService;

@RestController
@RequestMapping(value = {"/app/api/locations"})
public class LocationRESTController {
	
	private final LocationService service;
	private static final Logger logger = LoggerFactory.getLogger(LocationRESTController.class);
	
	static {
		logger.info("************ entering " + LocationRESTController.class.getName() + " ************");
	}
	
	@Autowired
	public LocationRESTController(final LocationService service) {
		this.service = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<LocationsCollection> findAll() {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Location> findById(@PathVariable("id") final String locationId) {
		return new ResponseEntity<>(this.service.findById(Integer.parseInt(locationId)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Location> save(@RequestBody final Location location) {
		return new ResponseEntity<>(this.service.save(location), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Location> update(@RequestBody final Location location) {
		return new ResponseEntity<>(this.service.update(location), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public void delete(final String locationId) {
		this.service.delete(Integer.parseInt(locationId));
	}
	
	
	
}











