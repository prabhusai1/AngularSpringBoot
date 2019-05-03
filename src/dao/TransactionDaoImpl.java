package com.src.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.src.entities.Customer;
import com.src.repository.CustomerRepository;

@Component
public class TransactionDaoImpl implements TransactionDAO {

	@Autowired
	private Customer customer;

	@Autowired
	private Customer fundTransferredcustomer;

	@Autowired
	private CustomerRepository customerRepository;

	public void selectChoice(Customer loggedIncustomer) {
		Optional<Customer> tempCust = customerRepository.findById(loggedIncustomer.getAccountNo());
		if (tempCust.isPresent()) {
			customer = tempCust.get();
		}
	}

	@Override
	public int deposit(int amt) {
		int amount = (int) (customer.getBalance() + amt);
		customer.setBalance(amount);
		amount = (int) customer.getBalance();

		customerRepository.save(customer);
		return amount;
	}

	@Override
	public int withdraw(int amt) {
		if (customer.getBalance() > amt) {
			int amount = (int) (customer.getBalance() - amt);
			customer.setBalance(amount);
			amount = (int) customer.getBalance();

			customerRepository.save(customer);

			return amount;
		} else {
			return 0;
		}
	}

	@Override
	public int viewBalance() {
		return (int) customer.getBalance();
	}

	@Override
	public int fundTransfer(int amt, int accountNo) {
		Optional<Customer> tempCust = customerRepository.findById(accountNo);

		if ((tempCust.isPresent()) && (amt < customer.getBalance())) {

			fundTransferredcustomer = tempCust.get();

			fundTransferredcustomer.setBalance(fundTransferredcustomer.getBalance() + amt);

			customer.setBalance(customer.getBalance() - amt);

			customerRepository.save(customer);

			customerRepository.save(fundTransferredcustomer);
		}

		return (int) customer.getBalance();
	}

}
