package com.mjstafford.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mjstafford.productsandcategories.models.Category;
import com.mjstafford.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
	//retrieves a list of all products for a particular category
	List<Product> findAllByCategories(Category category);

	//retrieves a list of all products a particular category does not belong to
    List<Product> findByCategoriesNotContains(Category category);

}
