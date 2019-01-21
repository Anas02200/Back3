package com.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Client;
import com.entities.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
	/*
	 * 
	add ADMIN
	delete
	update*/
	
	public Admin findByName(String name);
	public Admin deleteByName(String name);
	
}
