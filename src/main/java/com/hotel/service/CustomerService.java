package com.hotel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hotel.model.Customer;
import com.hotel.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	


	public boolean register(Customer customer) {
		
		try {			
			 customerRepo.save(customer);
		
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean login(String email, String password) {
		return customerRepo.existsByEmailAndPassword(email, password);
	}
	
}
