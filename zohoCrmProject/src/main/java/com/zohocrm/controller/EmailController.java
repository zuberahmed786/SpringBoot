package com.zohocrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.utilities.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	
	@RequestMapping("/sendEmail")
	public String sendEmail(@RequestParam("to") String to , @RequestParam("sub") String sub, @RequestParam("emailbody") String body,ModelMap model) {
		emailService.sendEmail(to, sub, body);
	    model.addAttribute("msg", "Email send Successfully!!");
		return"register_lead";
	}

	
}
