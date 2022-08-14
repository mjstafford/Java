package com.mjstafford.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mjstafford.productsandcategories.models.Category;
import com.mjstafford.productsandcategories.models.CategoryProduct;
import com.mjstafford.productsandcategories.models.Product;
import com.mjstafford.productsandcategories.services.CategoryService;
import com.mjstafford.productsandcategories.services.ProductService;


@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	
	//================= GET Routes ===================

	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("newCategory") Category newCategory) {
		return "new_category.jsp";
	}
	
	@GetMapping("/categories/{id}")
	public String showProduct(@PathVariable("id") Long id, @ModelAttribute("newCategoryProduct") CategoryProduct newCategoryProduct, Model model) {
		model.addAttribute("category", categoryService.findById(id));
		model.addAttribute("products", productService.findAllByCategories(categoryService.findById(id)));
		model.addAttribute("availableProducts", productService.findByCategoriesNotContains(categoryService.findById(id)));
		return "show_category.jsp";
	}
	
	
	//================= ACTION Routes ===================
	
	@PostMapping("/categories/new")
	public String processNewProduct(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result) {
		if(result.hasErrors()) {
			return "new_category.jsp";
		}
		
		Category category = categoryService.Save(newCategory);
		
		return "redirect:/categories/" + category.getId();
	}
	
	@PostMapping("/categories/{id}/new_product")
	public String processNewProductCategory(@PathVariable("id") Long id, @Valid @ModelAttribute("newCategoryProduct") CategoryProduct newCategoryProduct, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("category", categoryService.findById(id));
			model.addAttribute("products", productService.findAllByCategories(categoryService.findById(id)));
			model.addAttribute("availableProducts", productService.findByCategoriesNotContains(categoryService.findById(id)));
			System.out.println("errors!");
			return "show_category.jsp";
		}
		
		// retrieve an instance of a category using another method in the service.
		Category thisCategory = categoryService.findById(id);
		
		// retrieve an instance of a product using another method in the service.
		Product thisProduct = productService.findProductById(newCategoryProduct.getProduct().getId());
		
		// add the product to this category's list of products
		thisCategory.getProducts().add(thisProduct); // add the product to this categories list of products
		
		categoryService.Save(thisCategory);	// Save thisCategory, since you made changes to its products list.
			
		return "redirect:/categories/" + thisCategory.getId();
	}
}
