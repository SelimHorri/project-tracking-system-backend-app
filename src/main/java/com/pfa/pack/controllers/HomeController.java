package com.pfa.pack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/app"})
public class HomeController {
	
	@GetMapping(value = {"", "/"})
	public String displayHome() {
		return "home/home";
	}
	
	
	
}











