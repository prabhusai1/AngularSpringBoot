package com.src.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.src.entities.Customer;
import com.src.repository.CustomerRepository;

@Component
public class EntryDaoImpl implements EntryDAO {

	@Autowired
	private Customer customer;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public int login(Customer updatedCustomer) {
		Optional<Customer> tempCust = customerRepository.findById(updatedCustomer.getAccountNo());
		if (tempCust.isPresent()) {
			customer = tempCust.get();
			if ((customer.getAccountNo() == updatedCustomer.getAccountNo())
					&& (customer.getPassword().equals(updatedCustomer.getPassword()))) {
				
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

}
