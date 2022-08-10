package com.mjstafford.savetravels.controllers;

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

import com.mjstafford.savetravels.models.Expense;
import com.mjstafford.savetravels.services.ExpenseService;

@Controller
public class ExpensesController {
	
	//does your dependency injection for you, otherwise need a constructor to instantiate it
	//do not need private final when using Autowired
	@Autowired						
	ExpenseService expenseService;
	
	//ideally, should have use /expenses as base route to make this RESTful
	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense expense, Model model){	//modelAttribute here since there is a form on the page
		//find all expenses and send to jsp
		List<Expense> expenses = expenseService.getAll();
		model.addAttribute("expenses", expenses);
		
		return "index.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.getOne(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
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
	
	//edit expense form - show page
    @GetMapping("/expense/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.getOne(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }
    
    //edit expense process form submit
    //Be sure to use 'id' in your route: value="/expense/{id}". Using a different path variable name will create a new instance.
    @RequestMapping(value="/expense/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
        	//we can re-render this page if there are errors because it can never duplicate a submission in the db while an error exists
        	//this also automatically keeps all of the users previous input into the fields
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/";
        }
    }
    
    //delete route
    @RequestMapping(value="/expense/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	expenseService.deleteExpense(id);
        return "redirect:/";
    }
	
}
