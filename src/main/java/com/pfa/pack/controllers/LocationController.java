package com.pfa.pack.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.LocationService;

@Controller
@RequestMapping(value = {})
public class LocationController {
	
	private final LocationService service;
	private static final Logger logger = LoggerFactory.getLogger(LocationController.class);
	
	static {
		logger.info("************ entering " + LocationController.class.getName() + " ************");
	}
	
	@Autowired
	public LocationController(final LocationService service) {
		this.service = service;
	}
	
	
	
}










