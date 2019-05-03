package com.src.dao;

import org.springframework.web.bind.annotation.PathVariable;

public interface TransactionDAO {
	public int deposit(@PathVariable int amt);

	public int withdraw(@PathVariable int amt);

	public int viewBalance();

	public int fundTransfer(@PathVariable int amt, @PathVariable int accountNo);
}
