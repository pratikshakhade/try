package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
public class CutomerCon {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserService ser;
	
	@PostMapping("/stored")
	public Customer getUsers(@Valid @RequestBody Customer customer) {
		customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
		return ser.saveuser(customer);
		//return customer;
	}
	
	@GetMapping("/get")
	public String getUsers() {
		return "get";
	}
	
}
