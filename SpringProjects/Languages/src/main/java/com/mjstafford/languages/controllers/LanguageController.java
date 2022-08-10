package com.mjstafford.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mjstafford.languages.models.Language;
import com.mjstafford.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
	
	@Autowired
	LanguageService service;

	@GetMapping("")
	public String home(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = service.findAllLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		List<Language> languages = service.findAllLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
}
