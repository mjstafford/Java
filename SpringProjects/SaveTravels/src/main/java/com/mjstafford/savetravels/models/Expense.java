package com.mjstafford.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")		//should have named this expenses since its a table holding all expenses
public class Expense {
	// =============== Primary key ===============
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// =============== member variables ===============
	
    @NotNull(message="name cannot be blank")
    @Size(min = 2, max = 200, message="name must be between 2 and 200 characters")
    private String name;
    
    @NotNull(message="vendor cannot be blank")
    @Size(min = 5, max = 200, message="vendor must be between 5 and 200 characters")
    private String vendor;

    @NotNull(message="amount cannot be blank")
    @Min(value = 0, message="amount must be greater than 0")
    private Integer amount;
    
    @NotNull(message="description cannot be blank")
    @Size(min = 5, max = 500, message="description must be between 5 and 500 characters")
    private String description;

    @Column(updatable=false)  // This will not allow the createdAt column to be updated after creation
    @DateTimeFormat(pattern="yyyy-MM-dd")	//not required to have this format
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")	//DateTimeFormat, has other patterns that we could make
    private Date updatedAt;
    
    
    // =============== constructors ===============
    
    //Bean constructor
    public Expense() {
	}
    
    
	public Expense(String name, String vendor, Integer amount, String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
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
	
	
	// =============== getters and setters ===============
	

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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
