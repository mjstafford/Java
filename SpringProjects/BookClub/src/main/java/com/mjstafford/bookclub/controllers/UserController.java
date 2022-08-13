package com.mjstafford.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mjstafford.bookclub.models.LoginUser;
import com.mjstafford.bookclub.models.User;
import com.mjstafford.bookclub.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	// ================== GET ROUTES ================
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLoginUser", new LoginUser());
		return "login.jsp";
	}

    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("userId");
    	session.removeAttribute("userName");
    	return "redirect:/";
    }
	
	// ================== Action ROUTES ================
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		//will return user that was created in DB or null(if errors occurred)
		User user = userService.register(newUser, result);
		
		if(result.hasErrors()) {
            model.addAttribute("newLoginUser", new LoginUser());
            return "login.jsp";
		}
		
        //Store their ID from the DB in session
        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getUserName());		
		
		return "redirect:/books";
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLoginUser") LoginUser newLoginUser, BindingResult result, Model model, HttpSession session) {
		User user = userService.login(newLoginUser, result);
		
		if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
		}
		
        //Store their ID from the DB in session
        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getUserName());
   
        return "redirect:/books";
		
	}
	
}





