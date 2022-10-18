package com.marketting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketting.entities.Lead;
import com.marketting.services.LeadService;
import com.marketting.utilities.EmailService;



@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	
	private EmailService emailService;

	@RequestMapping("/viewCreateLeadPage")
	public String viewCreateLeadPage()
	{
		
		return "create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead,ModelMap model)
	{
	    
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(), "Welcome", "Received Email");
		model.addAttribute("msg", "Lead is Saved!!");
		return "create_lead";
	}
	
	@RequestMapping("/listall")
	public String getAllLeads(ModelMap model)
	{
	  List<Lead> leads = leadService.getLeads();
	  model.addAttribute("leads", leads);
	  return "lead_search_result";
	}
	
	@RequestMapping("/delete")
	public String updateOneLead(@RequestParam("id") long id,ModelMap model)
	{
	    leadService.deleteOneLead(id);
	    List<Lead> lead = leadService.getLeads();
	    model.addAttribute("lead", lead);
		return "lead_search_result";
	}
	
	@RequestMapping("/updateLead")
	public String updateLead(@ModelAttribute("lead") Lead lead,ModelMap model)
	{
		leadService.saveLead(lead);
		model.addAttribute("msg","Lead with id: "+lead.getId()+" is Updated Successfully ");
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}
}
