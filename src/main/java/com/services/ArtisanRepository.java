package com.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Artisan;
import com.entities.Client;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long>{
 
	public Artisan findByName(String name);
	public Artisan deleteByName(String name);
	/*
	
	
	@Query("select u from #{#entityName} u where u.Name = ?1")  
	List<Artisan> findByName(String Name);*/
	
	
	@Query("select u from #{#entityName} u where u.Adresse = ?1") 
	List<Artisan> findByAdresse(String adresse);
	
	//CRUD ARTISAN
	//FINDBY ID 
}

//select u from Artisan u where u.Id = ?1