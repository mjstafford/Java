package com.mjstafford.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjstafford.languages.models.Language;
import com.mjstafford.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	private final LanguageRepository languageRepo;

	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	// =============== methods should call on the repository ===============
	
	public List<Language> findAllLanguages(){
		return languageRepo.findAll();
	}
	
}
