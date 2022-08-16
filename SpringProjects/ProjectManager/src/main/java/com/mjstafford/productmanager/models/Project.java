package com.mjstafford.productmanager.models;


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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="projects")
public class Project {
	//============== member variables =====================
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @NotEmpty(message="Title is required!")
    @Size(min=3, max=30, message="Title must be between 3 and 30 characters")
    private String title;
    
    @NotEmpty(message="Description is required!")
    @Size(min=3, max=300, message="Description must be between 3 and 300 characters")
    private String description;
    
    @NotEmpty(message="Due date is required!")
    private Date dueDate;
    
    @NotEmpty(message="Lead is required!")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User lead;
    
    //manyToMany
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name="users_projects",								 	 //middle table name
    		joinColumns = @JoinColumn(name = "project_id"),		     //foreign key from this model
    		inverseJoinColumns = @JoinColumn(name = "user_id")	 	//foreign key from other model
    )
    private List<User> team;
    
    
    //one-project-to-many-tasks
    @OneToMany(mappedBy="project", fetch = FetchType.LAZY)
    private List<Task> tasks;
    
    //============== data creation trackers =====================
    
    
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    

    //============== constructor(S) =====================
    
    public Project() {}
    
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public User getLead() {
		return lead;
	}

	public void setLead(User lead) {
		this.lead = lead;
	}

	public List<User> getTeam() {
		return team;
	}

	public void setTeam(List<User> team) {
		this.team = team;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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
