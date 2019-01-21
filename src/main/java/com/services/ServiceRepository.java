package com.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
/*	
	@Query("select u from #{#entityName} u where u.typeService = ?1")  
	List<Service> findByName(String Name);
	*/
	public  Service findBytypeService(String typeS);
	public  Service deleteBytypeService(String typeS);

}
