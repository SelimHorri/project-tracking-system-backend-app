package com.pfa.pack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfa.pack.services.LocationService;

@Controller
@RequestMapping(value = {})
public class LocationController {
	
	private final LocationService service;
	
	@Autowired
	public LocationController(final LocationService service) {
		this.service = service;
	}
	
	
	
}










