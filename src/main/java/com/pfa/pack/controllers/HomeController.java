package com.pfa.pack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value = {"/", "/app"})
	public String displayHome() {
		return "home/home";
	}
	
	
	
}











