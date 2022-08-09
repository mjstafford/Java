package com.mjstafford.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mjstafford.savetravels.models.Expense;
import com.mjstafford.savetravels.services.ExpenseService;

@Controller
public class ExpensesController {
	
	//does your dependency injection for you, otherwise need a constructor to instantiate it
	@Autowired						
	ExpenseService expenseService;
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense expense, Model model){	//modelAttribute here since there is a form on the page
		//find all expenses and send to jsp
		List<Expense> expenses = expenseService.getAll();
		model.addAttribute("expenses", expenses);
		
		return "index.jsp";
	}
	
	@PostMapping("/new")
	public String processExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model){
		
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.getAll();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		
		expenseService.save(expense);
		
		
		return "redirect:/";
	}
}
