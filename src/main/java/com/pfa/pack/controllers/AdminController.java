package com.pfa.pack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/app/admins"})
public class AdminController {
	
	@GetMapping(value = {"", "/", "/admin-index"})
	public String displayAdminIndex() {
		
		
		
		return "admins/admin-index";
	}
	
	
	
}










