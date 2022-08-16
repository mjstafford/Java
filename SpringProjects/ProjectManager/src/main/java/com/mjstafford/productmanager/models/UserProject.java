package com.mjstafford.productmanager.models;

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


@Entity
@Table(name="users_projects")
public class UserProject {
	//============== member variables =====================
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	    
	    
	    //============== Many To Many Relationships =====================
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="project_id")
	    private Project project;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
	    
	    //============== data creation trackers =====================
	    
	    
	    @Column(updatable = false)
	    private Date createdAt;
	    private Date updatedAt;
	    

	    //============== constructor(S) =====================
		
	    
		public UserProject() {
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


		public Project getProject() {
			return project;
		}


		public void setProject(Project project) {
			this.project = project;
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
