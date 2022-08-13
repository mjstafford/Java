package com.mjstafford.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	//============== member variables =====================
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @NotEmpty(message="Title is required!")
    @Size(min=1, max=50, message="Title must be between 1 and 50 characters")
    private String title;
    
    @NotEmpty(message="Author is required!")
    @Size(min=2, max=50, message="Author must be between 2 and 50 characters")
    private String author;
    
    @NotEmpty(message="Thoughts is required!")
    @Size(min=2, max=500, message="Thoughts must be between 2 and 500 characters")
    private String thoughts;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    //============== data creation trackers =====================
    
    
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    

    //============== constructor(S) =====================
	
    
	public Book() {
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getThoughts() {
		return thoughts;
	}


	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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
