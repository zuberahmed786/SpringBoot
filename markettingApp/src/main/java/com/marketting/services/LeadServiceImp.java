package com.marketting.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketting.entities.Lead;
import com.marketting.repositories.LeadRepository;


@Service
public class LeadServiceImp implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
		
	}

	@Override
	public List<Lead> getLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteOneLead(long id) {
		leadRepo.deleteById(id);
		
	}

	

	public Lead getOneLead(long id) {
		Lead lead = leadRepo.findById(id).get();
		return lead;
	}

	
}
