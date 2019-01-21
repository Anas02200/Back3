package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Admin {
	@Id
	@GeneratedValue
	private long Id;
	@Column(unique = true)
	private String name;
	private String password;
	private String role = "admin";//??
//test
	public Admin() {

	}

	public Admin(long id, String name, String password) {
		super();
		Id = id;
		this.name = name;
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return Id;
	}

	public String getname() {
		return name;
	}

	@Override
	public String toString() {
		return "UserTest [Id=" + Id + ", Name=" + name + "]";
	}

	public void setname(String name) {
		this.name = name;
	}

	public String hashPassword(String Password) {
		// hashing code
		return Password;
	}

}
