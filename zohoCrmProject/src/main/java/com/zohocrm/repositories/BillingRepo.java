package com.zohocrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.zohocrm.entities.Billing;

public interface BillingRepo extends JpaRepository<Billing,Long>{

}
