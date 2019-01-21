package com.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Service {
	@Id
	@GeneratedValue
	private long Id;
	@Column(unique=true)
	private String typeService;
	private String serviceDescription;
	@OneToMany
	private List<Artisan> artisan;

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(long id, String typeService, String serviceDescription) {
		super(); 
		Id = id;
		this.typeService = typeService;
		this.serviceDescription = serviceDescription;
	}
/*
	@OneToMany
	@JoinTable(
	        uniqueConstraints=@UniqueConstraint(columnNames={"service_id","artisan_id"})
	    )
	private List<Artisan> artisan;*/
	

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTypeService() {
		return typeService;
	}

	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	/*public Artisan getArtisan() {
		return artisan;
	}

	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
	}
	*/

}
