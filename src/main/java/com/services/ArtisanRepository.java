package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Artisan;
import com.entities.Client;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long> {

	public Artisan findByName(String name);

	public Artisan deleteByName(String name);

	/*
	 * 
	 * 
	 * @Query("select u from #{#entityName} u where u.Name = ?1") List<Artisan>
	 * findByName(String Name);
	 */

	@Query("select u from #{#entityName} u where u.Adresse = ?1")
	List<Artisan> findByAdresse(String adresse);

	@Modifying
	@Query(value = "update artisan u SET u.name=?2,u.email=?3,u.phone=?4,u.password=?5,u.adresse=?6 where u.name=?1", nativeQuery = true)
	public void modify(String name, String newName, String email, String phone, String password, String adresse);

	@Query(value = "Select * from artisan u where ( Select id from service t where t.name=?)=u.service_id", nativeQuery = true)
	public List<Artisan> findByServiceName(String name);

	@Modifying
	@Transactional
	@Query(value = "insert into service_artisan values ((Select id from service t where t.name=?2),(Select id from artisan t where t.name=?1))", nativeQuery = true)
	public void AddArtisanToservice(String ArtisanName, String ServiceName);

	@Modifying
	@Transactional
	@Query(value = "update Artisan u SET u.service_id=( Select id from service t where t.name=?2) where u.name=?1 ", nativeQuery = true)
	public void AddServiceToArtisan(String name, String ServiceName);
	// CRUD ARTISAN
	// FINDBY ID
}

// select u from Artisan u where u.Id = ?1