package com.mjstafford.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mjstafford.savetravels.models.Expense;
import com.mjstafford.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	//dependency injection of a ExpenseRepository instance
	private final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	
	//methods that call the repo's
	public Expense save(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	//methods that call the repo's
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}

	public void delete(Long id) {
		expenseRepo.deleteById(id);
	}
	
	public List<Expense> getAll(){
		return expenseRepo.findAll();
	}

	public Expense getOne(Long id){
		//optional allows our program to not crash when looking for a dog id that doesn't exist
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		return null;
	}
	
}
