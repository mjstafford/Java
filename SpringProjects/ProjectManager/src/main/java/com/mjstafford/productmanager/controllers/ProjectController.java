package com.mjstafford.productmanager.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mjstafford.productmanager.models.User;
import com.mjstafford.productmanager.services.ProjectService;
import com.mjstafford.productmanager.services.UserService;

@Controller
public class ProjectController {

		@Autowired
		private ProjectService projectService;
		
		@Autowired
		private UserService userService;
	
		@GetMapping("/dashboard")
		public String dashboard(Model model, HttpSession session) {
			User user = userService.findById((Long) session.getAttribute("userId"));
			System.out.println("HERE");
			projectService.findByLeadNot(user);
			System.out.println("THERE");
			
			model.addAttribute("projects", projectService.findByLeadNot(user));
			model.addAttribute("myProjects", projectService.findAllByLead(user));
			model.addAttribute("userName", user.getFirstName());
			return "dashboard.jsp";
		}
	
		
		
}
