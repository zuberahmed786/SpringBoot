package com.zohocrm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Billing;
import com.zohocrm.repositories.BillingRepo;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingRepo billingRepo;
	
	@Override
	public void saveBill(Billing bill) {
		billingRepo.save(bill);
		
	}

}
