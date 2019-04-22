package com.hotel.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {
	public Room() {
	}
	public Room(long id, String roomType, BigDecimal price, String feature) {
		this.id = id;
		this.roomType = roomType;
		this.price = price;
		this.feature = feature;
	}
	@Id
	@GeneratedValue
	private long id;
	private String roomType;
	private BigDecimal price;
	private String feature;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
}
