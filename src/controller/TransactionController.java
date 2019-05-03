package com.src.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.dao.TransactionDaoImpl;
import com.src.entities.Customer;
import com.src.repository.CustomerRepository;
import com.src.service.TransactionService;

@RestController
@RequestMapping("/transactions")

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

@Component
public class TransactionController {

	@Autowired
	private Customer customer;

	@Autowired
	private Customer fundTransferredcustomer;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionService transactionServiceImpl;

	@Autowired
	private TransactionDaoImpl transactionDaoImpl;

	public void selectChoice(Customer loggedIncustomer) {
		transactionDaoImpl.selectChoice(loggedIncustomer);

	}

	@PutMapping("deposit/{amt}")
	public int deposit(@PathVariable int amt) {
		return transactionServiceImpl.deposit(amt);
	}

	@PutMapping("withdraw/{amt}")
	public int withdraw(@PathVariable int amt) {

//		if (customer.getBalance() > amt) {
//			int amount = (int) (customer.getBalance() - amt);
//			customer.setBalance(amount);
//			amount = (int) customer.getBalance();
//			
//			customerRepository.save(customer);
//			
//			return amount;
//		} else {
//			return 0;
//		}

		return transactionServiceImpl.withdraw(amt);
	}

	@GetMapping("/viewBalance")
	public int viewBalance() {
//		return (int) customer.getBalance();
		return transactionServiceImpl.viewBalance();
	}

	@PutMapping("/fundTransfer/{amt}/{accountNo}")
	public int fundTransfer(@PathVariable int amt, @PathVariable int accountNo) {

//		Optional<Customer> tempCust = customerRepository.findById(accountNo);
//
//		if ((tempCust.isPresent()) && (amt < customer.getBalance())) {
//			fundTransferredcustomer = tempCust.get();
//
//			fundTransferredcustomer.setBalance(fundTransferredcustomer.getBalance() + amt);
//
//			customer.setBalance(customer.getBalance() - amt);
//			
//			customerRepository.save(customer);
//			
//			customerRepository.save(fundTransferredcustomer);
//		}
//
//		return (int) customer.getBalance();

		return transactionServiceImpl.fundTransfer(amt, accountNo);
	}

}
