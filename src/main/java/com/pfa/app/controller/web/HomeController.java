package com.pfa.app.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"", "/"})
public class HomeController {
	
	/**
	 * get to entry point
	 * @return home
	 */
	@GetMapping(path = {"", "/"})
	public String displayHome() {
		return "home/home";
	}
	
	
	
}











