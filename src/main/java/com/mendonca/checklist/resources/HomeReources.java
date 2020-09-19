package com.mendonca.checklist.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeReources {

	@GetMapping("/")
	public String home() {
		return "home";
	}
}
