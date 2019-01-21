package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client extends Admin {
	private String Email;
	private String Phone;
	//@Id
	//@GeneratedValue
	//private Long ClientId;
	//@Column(unique = true)
	//private String name;
	//private String password;
	private String role = "Client";

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Client(long id, String name, String password, String email, String phone, String role) {
		super(id, name, password);
		Email = email;
		Phone = phone;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
/*
	public Long getClientId() {
		return ClientId;
	}

	public void setClientId(Long clientId) {
		this.ClientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	*/

}
