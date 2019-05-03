package com.src.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.src.dao.TransactionDAO;

@Component
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDaoImpl;

	@Override
	public int deposit(int amt) {
		return transactionDaoImpl.deposit(amt);
	}

	@Override
	public int withdraw(int amt) {
		return transactionDaoImpl.withdraw(amt);
	}

	@Override
	public int viewBalance() {
		return transactionDaoImpl.viewBalance();
	}

	@Override
	public int fundTransfer(int amt, int accountNo) {
		return transactionDaoImpl.fundTransfer(amt, accountNo);
	}

}
