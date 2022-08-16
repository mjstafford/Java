package com.mjstafford.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjstafford.productsandcategories.models.Category;
import com.mjstafford.productsandcategories.models.Product;
import com.mjstafford.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	public Category Save(Category category) {
		return categoryRepo.save(category);
	}

	public List<Category> findAll() {
		return categoryRepo.findAll();
	}
	
	//finds all the categories that contain the specific product in the products member variable
	public List<Category> findAllByProducts(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	// finds all the categories that do not contain the specified product in the products member variable
	public List<Category> findByProductsNotContains(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}

	public Category findCategoryById(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}

	public Category findById(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
}
