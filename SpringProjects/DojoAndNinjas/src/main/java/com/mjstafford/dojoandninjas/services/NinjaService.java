package com.mjstafford.dojoandninjas.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjstafford.dojoandninjas.models.Ninja;
import com.mjstafford.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	NinjaRepository ninjaRepo;
	
	public List<Ninja> findAll(){
		return ninjaRepo.findAll();
	}

	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
}
