package com.mjstafford.hellohuman;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	
	@RequestMapping("/")
	public String homeWithQueries(@RequestParam(value="name", required=false) String name,
			@RequestParam(value="last_name", required=false) String lastName,
			@RequestParam(value="times", required=false) Integer times){
		if(times != null) {
			return ("Hello " + name + " ").repeat(times);
		} else if(lastName != null) {
			return "Hello " + name + " " + lastName;
		} else if(name != null) {
			return "Hello " + name;
		}
		return "Hello Human";
	}

	//non Bonus route
//	@RequestMapping("/")
//	public String homeWithQueries(@RequestParam(value="name", required=false) String searchQuery){
//		if(searchQuery != null) {
//			return "Hello " + searchQuery;
//		}
//		return "Hello Human";
//	}

}