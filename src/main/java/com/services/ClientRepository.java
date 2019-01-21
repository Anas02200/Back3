package com.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	
	public Client findByName(String name);
	public Client deleteByName(String name);
	
	@Modifying
	@Query(value="update client u SET u.name=?2,u.email=?3,u.phone=?4,u.password=?5 where u.name=?1",nativeQuery = true)
	public void modify(String name,String newName,String email,String phone,String password);
}
