package com.zohocrm.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Lead;
import com.zohocrm.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	
    @Autowired
    private LeadRepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
		
	}

	public Lead getOneLead(long id) {
		Lead findById = leadRepo.findById(id).get();
		return findById;
	}

	@Override
	public void deleteOneLead(long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public List<Lead> getLeads() {
		List<Lead> findAll = leadRepo.findAll();
		return findAll;
	}


}
