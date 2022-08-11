package com.mjstafford.dojoandninjas.services;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjstafford.dojoandninjas.models.Dojo;
import com.mjstafford.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	DojoRepository dojoRepo;
	
	
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}


	public List<Dojo> findAll() {
		return dojoRepo.findAll();
	}


	public Dojo findById(Long id) {
		//long hand version
		//Optional<Dojo> dojo = dojoRepo.findById(id);
		//if(dojo.isPresent()) {
		//	return dojo.get();
		//}
		//return null;
		
		return dojoRepo.findById(id).orElse(null);	//short hand version
	}
	
}
