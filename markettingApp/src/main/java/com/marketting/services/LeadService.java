package com.marketting.services;

import java.util.List;

import com.marketting.entities.Lead;



public interface LeadService {
	
	public void saveLead(Lead lead);

	public List<Lead> getLeads();


	public void deleteOneLead(long id);

	public Lead getOneLead(long id);
	

}
