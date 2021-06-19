package com.pfa.pack.controller.business.admin;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfa.pack.model.entity.Location;
import com.pfa.pack.service.LocationService;

@Controller
@RequestMapping(value = {"/app/admins/locations"})
public class AdminLocationController {
	
	private final LocationService locationService;
	private static final Logger logger = LoggerFactory.getLogger(AdminLocationController.class);
	
	static {
		logger.info("************ entering " + AdminLocationController.class.getName() + " ************");
	}
	
	@Autowired
	public AdminLocationController(final LocationService locationService) {
		this.locationService = locationService;
	}
	
	@GetMapping(value = {"/", "/admin-locations-list"})
	public String displayAdminLocationsList(final Model model) {
		
		model.addAttribute("locations", this.locationService.findAll().getCollection());
		return "admins/locations/admin-locations-list";
	}
	
	@GetMapping(value = {"/admin-locations-add", "/add"})
	public String displayAdminLocationsAdd(final Model model) {
		
		model.addAttribute("location", new Location());
		return "admins/locations/admin-locations-add";
	}
	
	@PostMapping(value = {"/admin-locations-add", "/add"})
	public String handleAdminLocationsAdd(@ModelAttribute("location") @Valid final Location location, final BindingResult error, final Model model) {
		
		if (error.hasErrors()) {
			model.addAttribute("msg", "Problem happened here, please check again !");
			model.addAttribute("msgColour", "danger");
			return "admins/locations/admin-locations-add";
		}
		
		this.locationService.save(location);
		logger.info("Location with locationId : {} has been saved successfully", location.getLocationId());
		
		model.addAttribute("msg", "This location has been created successfully");
		model.addAttribute("msgColour", "success");
		
		return "admins/locations/admin-locations-add";
	}
	
	@GetMapping(value = {"/admin-locations-edit", "/edit"})
	public String displayAdminLocationsEdit(@RequestParam("locationId") final String locationId, final Model model) {
		
		model.addAttribute("location", this.locationService.findById(Integer.parseInt(locationId)));
		return "admins/locations/admin-locations-edit";
	}
	
	@PostMapping(value = {"/admin-locations-edit", "/edit"})
	public String handleAdminLocationsEdit(@ModelAttribute("location") @Valid final Location location, final BindingResult error, final Model model) {
		
		if (error.hasErrors()) {
			model.addAttribute("msg", "Problem happened here, please check again !");
			model.addAttribute("msgColour", "danger");
			return "admins/locations/admin-loclocations location0_ations-edit";
		}
		
		this.locationService.update(location);
		logger.info("Location with locationId : {} has been modified successfully", location.getLocationId());
		
		model.addAttribute("msg", "This location has been modified successfully");
		model.addAttribute("msgColour", "success");
		
		return "admins/locations/admin-locations-edit";
	}
	
	@GetMapping(value = {"/admin-locations-delete", "/delete"})
	public String handleAdminLocationsDelete(@RequestParam("locationId") final String locationId) {
		
		this.locationService.deleteById(Integer.parseInt(locationId));
		logger.info("Location with locationId : {} has been removed successfully", locationId);
		
		return "redirect:/app/admins/locations/admin-locations-list";
	}
	
	
	
}













