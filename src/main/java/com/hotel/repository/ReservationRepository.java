package com.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
