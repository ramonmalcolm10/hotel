package com.hotel.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	//boolean existsByUsernameAndPassword(String username, String password);
	Optional<Employee>findByUsernameAndPassword(String username, String password);
	
}
