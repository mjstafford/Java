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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="categories")
public class Category {
	//============== member variables =====================
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @NotEmpty(message="name is required!")
    @Size(min=1, max=50, message="name must be between 1 and 50 characters")
    private String name;
    
    
    //============== Many To Many Relationship =====================
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name="categories_products",								 //middle table name
    		joinColumns = @JoinColumn(name = "category_id"),		 //foreign key from this model
    		inverseJoinColumns = @JoinColumn(name = "product_id")	 //foreign key from other model
    )
    private List<Product> products;								     //list of other model instances
    
    //============== data creation trackers =====================
    
    
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    

    //============== constructor(S) =====================
	
    
	public Category() {
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


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
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
