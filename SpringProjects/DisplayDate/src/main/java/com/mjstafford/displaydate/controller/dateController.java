package com.mjstafford.displaydate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dateController {

	@RequestMapping("/")
	public String home() {
		return "date.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE', the 'd' of 'MMMM', ' Y " );
		String dateString = dateFormat.format(date);
		
		model.addAttribute("date", dateString);
		
		return "cuurentDate.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a" );
		String timeString = timeFormat.format(date);
		
		model.addAttribute("time", timeString);
		
		return "currentTime.jsp";
	}
}
