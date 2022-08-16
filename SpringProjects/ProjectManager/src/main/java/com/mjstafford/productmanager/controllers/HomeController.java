package com.mjstafford.productmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mjstafford.productmanager.models.LoginUser;
import com.mjstafford.productmanager.models.User;
import com.mjstafford.productmanager.services.UserService;

@Controller
public class HomeController {

	@Autowired 
	UserService userService;
	
	
	// ================== GET ROUTES ================
	
	@GetMapping("")
	public String home(@ModelAttribute("newUser") User newUser, @ModelAttribute("newLoginUser") User newLoginUser) {
		return "login.jsp";
	}
	
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("userId");
    	session.removeAttribute("userFirstName");
    	session.removeAttribute("userLastName");
    	return "redirect:/";
    }
	
	
	// ===================== Action Routes =======================
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		//validate via service
		//will return user that was created in DB or null(if errors occurred)
		User user = userService.register(newUser, result);
		
		if(result.hasErrors()) {
            model.addAttribute("newLoginUser", new LoginUser());
            return "login.jsp";
		}
		
        //Store their ID from the DB in session
        session.setAttribute("userId", user.getId());
        session.setAttribute("userFristName", user.getFirstName());		
        session.setAttribute("userLastName", user.getLastName());		
		
		return "redirect:/dashboard";
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
        session.setAttribute("userFirstName", user.getFirstName());
        session.setAttribute("userLastName", user.getLastName());
   
        return "redirect:/dashboard";
		
	}
}
