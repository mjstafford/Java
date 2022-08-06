package com.mjstafford.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/show")
	public String show(HttpSession session) {
		return "show.jsp";
	}

	@PostMapping("/process")
	public String process(
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="endeavor") String endeavor,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="description") String description,
			HttpSession session
			){
		
		//save form info into session
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("endeavor", endeavor);
		session.setAttribute("thing", thing);
		session.setAttribute("description", description);
		
		return "redirect:/omikuji/show";
	}
}
