package com.mjstafford.productsandcategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="products")
public class Product {
	//============== member variables =====================
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @NotEmpty(message="name is required!")
    @Size(min=1, max=50, message="name must be between 1 and 50 characters")
    private String name;
    
    @NotEmpty(message="description is required!")
    @Size(min=2, max=500, message="description must be between 2 and 500 characters")
    private String description;
    
    @NotNull(message="price is required!")
    @Min(value=1, message="price must be greater than 1")
    private double price;
    
    
    //============== Many To Many Relationship =====================
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name="categories_products",								 //middle table name
    		joinColumns = @JoinColumn(name = "product_id"),		     //foreign key from this model
    		inverseJoinColumns = @JoinColumn(name = "category_id")	 //foreign key from other model
    )
    private List<Category> categories;								 //list of other model instances
    
    //============== data creation trackers =====================
    
    
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    

    //============== constructor(S) =====================
	
    
	public Product() {
	}
	
	
	// =============== Data Creation Event ===============
	
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

	//============== getters and setters =====================

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
