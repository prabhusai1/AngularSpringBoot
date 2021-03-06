package com.src.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface TransactionService {
	public int deposit(@PathVariable int amt);

	public int withdraw(@PathVariable int amt);

	public int viewBalance();

	public int fundTransfer(@PathVariable int amt, @PathVariable int accountNo);
}
