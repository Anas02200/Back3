package com.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	
	public Client findByName(String name);
	public Client deleteByName(String name);

}
