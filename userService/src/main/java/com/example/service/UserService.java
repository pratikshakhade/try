package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.repositry.UserRepositry;


@Service
public class UserService {
	
	
	@Autowired
    UserRepositry repo;
	
	public Customer saveuser(Customer custemer) {
		return repo.save(custemer);
	//	return custemer;
	}

}
