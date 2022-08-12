package com.mjstafford.dojoandninjas.authentication.services;

import java.util.Optional;

//added in BCrypt import
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mjstafford.dojoandninjas.authentication.models.LoginUser;
import com.mjstafford.dojoandninjas.authentication.models.User;
import com.mjstafford.dojoandninjas.authentication.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    
    
    
    public User register(User newUser, BindingResult result) {
    	//remember newUser is an object of User ...just not in the DB yet
    	
    	// Reject if email is taken (present in database), if user already exists
    	Optional<User>  potentialUser = userRepo.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()) {
    		//user already exists, therefore reject	(result.rejectValue("fieldHere", "errorCodeHere",  "OurMessageWeShow"))
    		result.rejectValue("email", "Unique",  "The email is already in use!");
    	}
    	
    	//if passwords do no match add an error to results
    	String passwordEntered = newUser.getPassword();
    	String passwordConfirm = newUser.getConfirm();
    	if(!passwordEntered.equals(passwordConfirm)) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    		
        // Return null if result has errors ...remember that this is not the controller so the service doesnt show the errors
    	if(result.hasErrors()) {
    		return null;
    	}
    
        // Hash and set password
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	
    	//save user to database
        return userRepo.save(newUser);
    }
    
    public User login(LoginUser newLoginUser, BindingResult result) {
    	if(result.hasErrors()) {
    		return null;
    	}
        
    	// Find user in the DB by email
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginUser.getEmail());
    	if(!potentialUser.isPresent()) {
    		// Reject if NOT present
    		result.rejectValue("email", "Unique", "Invalid Credentials(1)!");
    		//if email is not found, don't check the password just return right away
    		return null;
    	}
    	
    	User user = potentialUser.get();
		
		// Reject if BCrypt password match fails
		if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Credentials(2)!");
			
			return null;
		}
		
		// Otherwise everything checks out, return the user object
        return user;
    }

    
    
    
    
	public User findByEmail(String email) {	// not-shorthand
		Optional<User> potentialUser = userRepo.findByEmail(email);	
		if(potentialUser.isPresent()) {
			return potentialUser.get();
		}
		return null;
	}

	
	public User getOne(Long id) {
		return userRepo.findById(id).orElse(null);		//short hand to avoid Optional if/else
	}

}
