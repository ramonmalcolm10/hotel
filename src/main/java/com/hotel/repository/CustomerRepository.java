package com.hotel.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hotel.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	
	boolean existsByEmailAndPassword(String email, String password);
}
