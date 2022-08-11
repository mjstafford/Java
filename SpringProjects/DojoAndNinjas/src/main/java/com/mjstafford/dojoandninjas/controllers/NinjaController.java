package com.mjstafford.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mjstafford.dojoandninjas.models.Ninja;
import com.mjstafford.dojoandninjas.services.DojoService;
import com.mjstafford.dojoandninjas.services.NinjaService;

@Controller
public class NinjaController {

	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	// ================== GET ROUTES =====================
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.findAll());
		return "new_ninja.jsp";
	}
	
	
	// ================== Actions ROUTES =====================
	
	@PostMapping("/ninjas/new")
	public String processNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.findAll());
			return "new_ninja.jsp";
		}
		
		ninjaService.create(ninja);
		
		return "redirect:/ninjas/new";
	}
	
	
}
