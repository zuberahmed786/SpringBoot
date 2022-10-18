package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contacts;
import com.zohocrm.entities.Lead;
import com.zohocrm.services.ContactService;
import com.zohocrm.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/viewLeadPage")
	public String viewLeadPage() {
		
		
		return"register_lead";
	}
	
	@PostMapping("/saveOneLead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		
		leadService.saveLead(lead);
		model.addAttribute("lead", lead);
		return"lead_information";
		
	}
	
	@RequestMapping("/composeEmail")
	public String composeEmail(@RequestParam("email") String email, ModelMap model) {
		System.out.println(email);
		model.addAttribute("email", email);
		return "compose_email";
	}
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, ModelMap model)
	{
		Lead lead = leadService.getOneLead(id);
		
		Contacts contact = new Contacts();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveOneContact(contact);
		
		leadService.deleteOneLead(lead.getId());
		model.addAttribute("message", "Lead saved to contact list");
		return"lead_information";
	}
	
	@RequestMapping("/listAll")
	public String getAllLeads(ModelMap model) {
	  List<Lead> leads =	leadService.getLeads();
	  model.addAttribute("leads", leads);
	  return "list_leads";
	}

	@RequestMapping("/findLeadById")
	public String findOneLead(@RequestParam("id") long id) {
		Lead lead = leadService.getOneLead(id);
		return "lead_information";
		
	}
}
