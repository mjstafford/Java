package com.mjstafford.javaexam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class thingsController {
	@GetMapping("/")
	public String dashboard() {
		return "dashboard.jsp";
	}
}
