package com.src.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.src.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
