package com.pfa.pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/app"})
public class HomeController {
	
	/**
	 * get to entry point
	 * @return home
	 */
	@GetMapping(value = {"", "/"})
	public String displayHome() {
		return "home/home";
	}
	
	
	
}











