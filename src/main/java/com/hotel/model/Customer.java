package com.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer {

	public Customer() {
		
	}

	public Customer(long id, String fname, String lname, String email, Reservation reservation, String password) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.reservation = reservation;
		this.password = password;
	}


	@Id
	@GeneratedValue
	private long id;
	@NotBlank
	@Column(nullable=false)
	private String fname;
	@NotBlank
	@Column(nullable=false)
	private String lname;
	@NotBlank
	@Column(nullable=false, unique=true)
	private String email;
	
	@NotBlank
	@Column(nullable=false)
	private String password;
	
	@OneToOne
	@JoinColumn()
	private Reservation reservation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
