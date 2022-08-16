package com.mjstafford.javaexam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mjstafford.javaexam.models.LoginUser;
import com.mjstafford.javaexam.models.User;
import com.mjstafford.javaexam.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email).orElse(null);
	}
	
	public User register(User newUser, BindingResult result) {		
		//user already exist?
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()){
			result.rejectValue("email", "Unique",  "The email is already in use!");
		}
		
		//password field matches confirm field?
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		
		//if result has errors do not return a user
		if(result.hasErrors()) {
			return null;
		}
		
		//else hash password & set that password on the newUser
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
		
		//Save user into DB
		return userRepo.save(newUser);
	}
	
    public User login(LoginUser newLogin, BindingResult result) {
    	if(result.hasErrors()) {
    		return null;
    	}
    	    	
    	//user doesn't exist
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()){
    		result.rejectValue("email", "Unique", "Invalid Credentials (user)!");
    		return null;
		}
    	
		User user = potentialUser.get();
    	//password matches??
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Credentials (password)!");
			return null;
		}
    	//else return that user
        return user;
    }

	public Object findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
}