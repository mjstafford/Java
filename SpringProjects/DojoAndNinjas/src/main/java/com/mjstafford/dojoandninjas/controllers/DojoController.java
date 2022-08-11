package com.mjstafford.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mjstafford.dojoandninjas.models.Dojo;
import com.mjstafford.dojoandninjas.services.DojoService;

@Controller
public class DojoController {

	@Autowired
	private DojoService dojoService;
	
	// ================== GET ROUTES =====================
	
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "new_dojo.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		//a dojo will have all the ninjas in a list variable!
		model.addAttribute("dojo", dojoService.findById(id));
		
		return "show_dojo_with_ninjas.jsp";
	}

	
	// ================== Actions ROUTES =====================
	
	
	@PostMapping("/dojos/new")
	public String ProcessNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "new_dojo.jsp";
		}
		
		Dojo newDojo = dojoService.create(dojo);
		return "redirect:/dojos/" + newDojo.getId() ;
	}
	
}
