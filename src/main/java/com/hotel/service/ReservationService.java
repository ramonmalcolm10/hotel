package com.hotel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Reservation;
import com.hotel.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepo;
	
	public Iterable<Reservation> getAllReservation() {
		return reservationRepo.findAll();
	}
	
	public Optional<Reservation> getUserReservation(long id) {
		return reservationRepo.findById(id);
	}
	
	public void makeReservation(Reservation reservation) {
		reservationRepo.save(reservation);
	}
	
	public boolean modifyReservation(Reservation reservation) {
		
		try {
			reservationRepo.save(reservation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void cancelReservation(long id) {
		reservationRepo.deleteById(id);
	}
	
}
