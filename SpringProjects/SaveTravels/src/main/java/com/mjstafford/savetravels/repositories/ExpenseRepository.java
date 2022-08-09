package com.mjstafford.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mjstafford.savetravels.models.Expense;

//crudRepository is like "tools" that we will use in the service

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	//can view all built in methods by "ctrl + click" on "crudRepository"
	//must build any other method below
	
	List<Expense> findAll();
}
