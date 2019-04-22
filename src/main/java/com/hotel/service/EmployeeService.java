package com.hotel.service;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.model.Employee;
import com.hotel.repository.EmployeeRepository;

@Service
public class EmployeeService {
 
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository empRepo;
	
	public Optional<Employee> login(String username, String password) {
		log.trace("Checking if username and password is valid for: {}", username);
		return empRepo.findByUsernameAndPassword(username, password);
	}
	
	public Boolean register(Employee emp) {
		log.trace("Registering new user: {}", emp.getUsername());
		try {
			empRepo.save(emp);
			return true;
		} catch (Exception e) {
			log.error("User could not be registered");
			return false;
		}	
	}

}
