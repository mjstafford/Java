package com.mjstafford.ninjagoldjava.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldJavaController {
	
	@SuppressWarnings("unchecked")
	@GetMapping("/Gold")
	public String home(HttpSession session) {
		
		
		if(session.getAttribute("currGold") == null) {
			session.setAttribute("currGold", 0);
			session.setAttribute("reward", 0);
			System.out.println("HERE 1");
		} else {
			System.out.println("HERE 2");
			Integer rewardGold = (int) session.getAttribute("reward");
			session.setAttribute("currGold", rewardGold + (int)session.getAttribute("currGold"));			
			System.out.println(session.getAttribute("reward"));
			System.out.println(session.getAttribute("currGold"));
		}
		
		//handle the activities
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM d Y h:mm a");
		ArrayList<String> activities = new ArrayList<String>();
		
		if(session.getAttribute("activities") == null) {
			session.setAttribute("activities", activities);
		} else {
			System.out.println("STUCK");
			activities = (ArrayList<String>) session.getAttribute("activities");
			System.out.println("right");
			activities.add(0, "You entered a " + session.getAttribute("building") + " and earned " + session.getAttribute("reward") + " gold " + "(" + format.format(date) + ")");
			session.setAttribute("activities", activities);
		}
		
		
		return "index.jsp";
	}
	
	@PostMapping("/Gold/process")
	public String processGold(
			HttpSession session,
			@RequestParam(value="building") String building
			) {
		HashMap<String, Integer> buildingsReward = new HashMap<String, Integer>();
		Random r = new Random();
		
		buildingsReward.put("Farm", (r.nextInt(21-10) + 10));				//10 to 20
		buildingsReward.put("Cave", (r.nextInt(11-5) + 5));				//5 to 10
		buildingsReward.put("House", (r.nextInt(6-2) + 2));				//2 to 5
		buildingsReward.put("Quest", (r.nextInt(51 - (-50))+ (-50)));		//-50 to 50
		
		session.setAttribute("reward", buildingsReward.get(building));
		session.setAttribute("building", building);
		
		return "redirect:/Gold";
	}
	
}
