package com.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
	@Modifying
	@Query(value="update admin u SET u.name=?2,u.password=?3 where u.name=?1",nativeQuery = true)
	public void modify(String name,String newName,String password);
	
}
