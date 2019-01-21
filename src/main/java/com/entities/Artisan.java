package com.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Artisan extends Admin {
	private String Email;
	private String Phone;
	private String Adresse;
	/*@Id
	@GeneratedValue
	private Long ArtisanId;
	@Column(unique = true)
	private String name;
	private String password;*/

	private String role = "Artisan";
	
	@ManyToOne
	private Service service;
	

	public Artisan() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Artisan(long id, String name, String password, String email, String phone, String adresse, String role) {
		super(id, name, password);
		Email = email;
		Phone = phone;
		Adresse = adresse;
		this.role = role;
		
	}



	public Service getService() {
		return service;
	}



	public void setService(Service service) {
		this.service = service;
	}



	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		this.Phone = phone;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		this.Adresse = adresse;
	}

/*	public Long getArtisanId() {
		return ArtisanId;
	}

	public void setArtisanId(Long artisanId) {
		ArtisanId = artisanId;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
