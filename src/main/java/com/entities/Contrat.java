package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Contrat {

	@Id
	@GeneratedValue
	private long Id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date date;//date formating problem

	@OneToOne
	private Artisan artisan;
	@OneToOne
	private Client client;
	@OneToOne
	private Service service;

	
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Contrat(Date date) {
		super();
		this.date = date;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Artisan getArtisan() {
		return artisan;
	}

	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
