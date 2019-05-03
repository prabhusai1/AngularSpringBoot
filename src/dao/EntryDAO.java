package com.src.dao;

import org.springframework.web.bind.annotation.RequestBody;

import com.src.entities.Customer;

public interface EntryDAO {
	public Customer createCustomer(@RequestBody Customer customer);
	public int login(@RequestBody Customer customer);
}
