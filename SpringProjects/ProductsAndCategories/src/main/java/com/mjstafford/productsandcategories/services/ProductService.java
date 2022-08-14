package com.mjstafford.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjstafford.productsandcategories.models.Category;
import com.mjstafford.productsandcategories.models.Product;
import com.mjstafford.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	public Product Save(Product product) {
		return productRepo.save(product);
	}

	public List<Product> findAllByCategories(Category category) {
		return productRepo.findAllByCategories(category);
	}

	public List<Product> findByCategoriesNotContains(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}

	public List<Product> findAll() {
		return productRepo.findAll();
	}

	public Product findById(Long id) {
		return productRepo.findById(id).orElse(null);
	}

	public Product findProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	
}
