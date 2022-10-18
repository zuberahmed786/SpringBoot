package com.zohocrm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Contacts;
import com.zohocrm.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired ContactRepository conRepo;
	@Override
	public void saveOneContact(Contacts contact) {
		conRepo.save(contact);
		
	}

}
