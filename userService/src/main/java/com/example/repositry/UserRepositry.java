package com.example.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository
public interface UserRepositry extends JpaRepository<Customer, Integer> {

}
