package com.mjstafford.languages.services;

import java.util.List;
import java.util.Optional;

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
	
	public Language findById(Long id){
		Optional<Language> optLang = languageRepo.findById(id);
		if(optLang.isPresent()) {
			return optLang.get();
		}
		return null;
	}
	
	public void delete(Long id) {
		languageRepo.deleteById(id);
	}
	
	public Language save(Language language) {
		return languageRepo.save(language);
	}

	public Language update(Language language) {
		return languageRepo.save(language);
	}
	
}
