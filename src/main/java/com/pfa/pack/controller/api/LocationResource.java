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
import com.pfa.pack.model.entity.Location;
import com.pfa.pack.service.LocationService;

@RestController
@RequestMapping(value = {"/app/api/locations"})
public class LocationResource {
	
	private final LocationService locationService;
	private static final Logger logger = LoggerFactory.getLogger(LocationResource.class);
	
	static {
		logger.info("************ entering " + LocationResource.class.getName() + " ************");
	}
	
	@Autowired
	public LocationResource(final LocationService service) {
		this.locationService = service;
	}
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<DtoCollection<Location>> findAll() {
		return new ResponseEntity<>(this.locationService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/{id}"})
	public ResponseEntity<Location> findById(@PathVariable("id") final String locationId) {
		return new ResponseEntity<>(this.locationService.findById(Integer.parseInt(locationId)), HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/save"})
	public ResponseEntity<Location> save(@RequestBody final Location location) {
		return new ResponseEntity<>(this.locationService.save(location), HttpStatus.OK);
	}
	
	@PutMapping(value = {"", "/update"})
	public ResponseEntity<Location> update(@RequestBody final Location location) {
		return new ResponseEntity<>(this.locationService.update(location), HttpStatus.OK);
	}
	
	@DeleteMapping(value = {"", "/delete"})
	public void deleteById(final String locationId) {
		this.locationService.deleteById(Integer.parseInt(locationId));
	}
	
	
	
}











