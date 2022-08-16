package com.mjstafford.productmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjstafford.productmanager.models.Project;
import com.mjstafford.productmanager.models.User;
import com.mjstafford.productmanager.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepo;
	
	public List<Project> findAll(){
		return projectRepo.findAll();
	}

	public List<Project> findAllByLead(User lead){
		return projectRepo.findAllByLead(lead);
	}
	
	public List<Project> findByTeamNotContains(User lead){
		return projectRepo.findByTeamNotContains(lead);
	}
	
	public List<Project> findByLeadNot(User lead){
		return projectRepo.findByLeadNot(lead);
	}
	
	
}
