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
public class ProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	
	//================= GET Routes ===================
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("products", productService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "home.jsp";
	}

	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("newProduct") Product newProduct) {
		return "new_product.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, @ModelAttribute("newCategoryProduct") CategoryProduct newCategoryProduct, Model model) {
		model.addAttribute("product", productService.findById(id));
		model.addAttribute("categories", categoryService.findAllByProducts(productService.findById(id)));
		model.addAttribute("availableCategories", categoryService.findByProductsNotContains(productService.findById(id)));
		return "show_product.jsp";
	}
	
	
	
	//================= ACTION Routes ===================
	
	@PostMapping("/products/new")
	public String processNewProduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		if(result.hasErrors()) {
			return "new_product.jsp";
		}
		
		Product product = productService.Save(newProduct);
		
		return "redirect:/products/" + product.getId();
	}
	
	@PostMapping("/products/{id}/new_category")
	public String processNewProductCategory(@PathVariable("id") Long id, @Valid @ModelAttribute("newCategoryProduct") CategoryProduct newCategoryProduct, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("product", productService.findById(id));
			model.addAttribute("categories", categoryService.findAllByProducts(productService.findById(id)));
			model.addAttribute("availableCategories", categoryService.findByProductsNotContains(productService.findById(id)));
			System.out.println("errors!");
			return "show_product.jsp";
		}
		
		// retrieve an instance of a category using another method in the service.
		Category thisCategory = categoryService.findCategoryById(newCategoryProduct.getCategory().getId());
		
		// retrieve an instance of a product using another method in the service.
		Product thisProduct = productService.findProductById(newCategoryProduct.getProduct().getId());
		
		// add the product to this category's list of products
		thisProduct.getCategories().add(thisCategory);	// add the category to this products's list of categories
		productService.Save(thisProduct);	// Save thisProduct, since you made changes to its category list.
			
		return "redirect:/products/" + thisProduct.getId();
	}
	
	
	
}
