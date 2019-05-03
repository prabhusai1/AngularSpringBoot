package com.src.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.src.entities.Customer;

public interface EntryService {
	public Customer createCustomer(@RequestBody Customer customer);
	public int login(@RequestBody Customer customer);
}
