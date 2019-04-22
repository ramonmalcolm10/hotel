package com.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	

	public Employee() {

	}

	public Employee(long id, String username, String fname, String lname, String password, int role) {
	
		this.id = id;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.role = role;
	}

	@Id
	@GeneratedValue
	private long id;
	@Column(unique=true)
	private String username;
	private String fname;
	private String lname;
	private String password;
	private int role;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
