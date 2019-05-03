package com.src.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.dao.EntryDAO;
import com.src.entities.Customer;
import com.src.repository.CustomerRepository;
import com.src.service.EntryService;

@RestController
@RequestMapping("/entry")

//This annotation is used to give access to other origins...to access 8080 from 4200
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private Customer cust;

	@Autowired
	private EntryService entryServiceImpl;

	@Autowired
	private TransactionController transsaction;

	@GetMapping("/getAllCustomers")
	public List<Customer> getCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable int id) {
		return customerRepository.findById(id);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public boolean deleteCustomer(@PathVariable int id) {
		customerRepository.deleteById(id);
		return true;
	}

	@PostMapping("/addCustomer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return entryServiceImpl.createCustomer(customer);
	}

	@PostMapping("/loginCustomer")
	public int login(@RequestBody Customer customer) {
		transsaction.selectChoice(customer);
		return entryServiceImpl.login(customer);
	}

	@PutMapping("/updateCustomer/{id}")
	public Customer updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
		Optional<Customer> tempCust = customerRepository.findById(id);
		if (tempCust.isPresent()) {
			cust = tempCust.get();
			cust.setAadharNo(updatedCustomer.getAadharNo());
			cust.setAccountNo(id);
			cust.setAddress(updatedCustomer.getAddress());
			cust.setBalance(updatedCustomer.getBalance());
			cust.setEmailId(updatedCustomer.getEmailId());
			cust.setFirstName(updatedCustomer.getFirstName());
			cust.setLastName(updatedCustomer.getLastName());
			cust.setMobileNo(updatedCustomer.getMobileNo());
			cust.setPancardNo(updatedCustomer.getPancardNo());
			cust.setPassword(updatedCustomer.getPassword());

			customerRepository.save(cust);
		}
		return cust;
	}
}
