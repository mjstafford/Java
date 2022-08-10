package com.mjstafford.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult bindingResult, Model model ) {
		if(bindingResult.hasErrors()) {
			List<Language> languages = service.findAllLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}
		
		//if everything is good we need to save it!
		service.save(language);
		
		return "redirect:/languages";
	}
	
	// EDIT - show
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
        Language language = service.findById(id);
        model.addAttribute("language", language);
		return "edit.jsp";
	}

	// EDIT - process
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		
		service.update(language);
		return "redirect:/languages";
	}
	
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = service.findById(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}

	// path for deleting language
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/languages";
	}
	
	
	
}
