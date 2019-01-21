package com.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	/*
	 * @Query("select u from #{#entityName} u where u.typeService = ?1")
	 * List<Service> findByName(String Name);
	 */
	public Service findByName(String typeS);

	public Service deleteByName(String typeS);

	@Modifying
	@Query(value = "update client u SET u.name=?2,u.serviceDescription=?3 where u.name=?1", nativeQuery = true)
	public void modify(String name, String newName, String serviceDescription);

	// un arti peut faire un seul service
	// find artisans dyal wahd service select artisan id from *** where service id
	// == done
	// find le services d un artisan==>select services from
	// add artisan to service(service id ,artisan id ==>
	// add service to artisan table arti=>champ service add service id + go table sa
	// add(serv id _ art id)
	

}
