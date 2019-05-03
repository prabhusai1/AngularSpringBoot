package com.src.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.src.dao.EntryDAO;
import com.src.entities.Customer;

@Component
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryDAO entryDAOImpl;

	@Override
	public Customer createCustomer(Customer customer) {
		entryDAOImpl.createCustomer(customer);
		return customer;
	}

	@Override
	public int login(Customer customer) {
		int login=entryDAOImpl.login(customer);
		return login;
	}

}
