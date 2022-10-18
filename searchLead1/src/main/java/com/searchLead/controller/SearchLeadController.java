package com.searchLead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.searchLead.dto.Lead;

@Controller
public class SearchLeadController {
	
	@RequestMapping("/searchpage")
	public String viewSearchPage()
	{
		return "search_lead";
	}
  
	@RequestMapping("/searchLead")
	public String searchLead(@RequestParam("id") long id, ModelMap model) {
		LeadRestClient client = new LeadRestClient();
		Lead leadById = client.getLeadById(id);
		model.addAttribute("lead", leadById);
		System.out.println(leadById.getFirstName());
		return "lead_result";
		
	}
}
