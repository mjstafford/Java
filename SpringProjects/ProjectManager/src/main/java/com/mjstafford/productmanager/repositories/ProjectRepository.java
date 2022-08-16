package com.mjstafford.productmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mjstafford.productmanager.models.Project;
import com.mjstafford.productmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
	List<Project> findAllByLead(User lead);
	
	//contains only works on lists!
	List<Project> findByTeamNotContains(User lead);

	//find all projects where the lead is not the provided parameter
	List<Project> findByLeadNot(User lead);
}
