package com.marketting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketting.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead , Long> {

}
