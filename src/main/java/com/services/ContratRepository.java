/*package com.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long > {

	//findby date
	//findby ids PROOBLEMS 
	@Query("select u from #{#entityName} u where u.artisan = (select p from Artisan p where p.Id = ?1)")
	List<Contrat> findByArtisanId(long id);
	
	@Query("select u from #{#entityName} u where u.client = (select p from Client p where p.Id = ?1)")  
	List<Contrat> findByClientID(long id);
	
	@Query("select u from #{#entityName} u where u.service= (select p from Service p where p.Id = ?1)")  
	List<Contrat> findByServiceID(long id);
	
}
*/