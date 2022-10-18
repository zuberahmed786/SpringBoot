package com.searchLead.controller;

import org.springframework.web.client.RestTemplate;

import com.searchLead.dto.Lead;

public class LeadRestClient {
	
	public Lead getLeadById(long id)
	{
		RestTemplate rest = new RestTemplate();
		Lead forObject = rest.getForObject("http://localhost:8080/api/leads/get/"+id, Lead.class);
		return forObject;
	}

}
