package com.zohocrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Lead;
import com.zohocrm.services.BillingService;
import com.zohocrm.services.LeadService;

@Controller
public class BillingController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/generateBill")
	public String getLeadId(@RequestParam("id") long id,ModelMap model)
	{
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead", lead);
		return"generate_bill";
	}
	
	@RequestMapping("/saveBill")

	public String saveBill(@ModelAttribute("bill") Billing bill, ModelMap model) {
		billingService.saveBill(bill);
		model.addAttribute("msg", "Bill is Saved");
		return"generate_bill";
	}
}
