package com.mjstafford.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class counterController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
			session.setAttribute("count", ((int)session.getAttribute("count")+1));
		}
		
		return "index.jsp";
	}
	
	@RequestMapping("/count")
	public String show(HttpSession session, Model model) {
		model.addAttribute("count", session.getAttribute("count"));
		return "show.jsp";
	}
	
	@RequestMapping("/reset")
	public String rest(HttpSession session, Model model) {
//		session.removeAttribute("count");
		session.setAttribute("count",0);
		return "redirect:/count";
	}
}
