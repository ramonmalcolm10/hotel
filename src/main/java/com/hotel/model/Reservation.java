package com.hotel.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {

	
	
	public Reservation() {
		
	}
	public Reservation(long id, long custId, int roomNum, LocalDate startDate, LocalDate endDate) {
		
		this.id = id;
		this.custId = custId;
		this.roomNum = roomNum;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	@Id
	@GeneratedValue
	private long id;
	
	private long custId;
	
	@Column(nullable=false)
	private int roomNum;
	
	private LocalDate startDate = LocalDate.now();
	private  LocalDate endDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}
