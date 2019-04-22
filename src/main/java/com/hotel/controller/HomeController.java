package com.hotel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.model.Customer;
import com.hotel.repository.RoomRepository;
import com.hotel.service.CustomerService;

@Controller
public class HomeController {

	private final CustomerService customerService;
	private final RoomRepository roomRepo;

	@Autowired
	public HomeController(CustomerService customerService, RoomRepository roomRepo) {
		this.customerService = customerService;
		this.roomRepo = roomRepo;
	}

	@GetMapping("/register")
	public String register(Customer customer) {
		return "register";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("rooms", roomRepo.findAll());
		return "index";
	}

	@PostMapping("/register")
	public String register(@Valid Customer customer, BindingResult result, Model model) {

		if (customerService.register(customer)) {
			model.addAttribute("successMsg", "You have successfully registered");
			return "login";
		}
		model.addAttribute("errorMsg", "Failed to register please try again");
		return "register";
	}
	
	@GetMapping("/login")
	public String login(Customer customer) {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@Valid Customer customer, BindingResult result, Model model) {
		
		if(customerService.login(customer.getEmail(), customer.getPassword())) {
			return "index";
		}
		else {
			model.addAttribute("errorMsg", "Failed to login");
			return "login";
		}
	}
}
