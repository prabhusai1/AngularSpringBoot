package com.src.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)

	@Column(name = "account_no")
	private int accountNo;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "password")
	private String password;

	@Column(name = "pancard_no")
	private String pancardNo;

	@Column(name = "aadhar_no", unique = true)
	private long aadharNo;

	@Column(name = "address")
	private String address;

	@Column(name = "mobile_no")
	private long mobileNo;

	@Column(name = "balance")
	private float balance;

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPancardNo() {
		return pancardNo;
	}

	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstName, String lastName, String emailId, String password, String pancardNo, long aadharNo,
			String address, long mobileNo, float balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.pancardNo = pancardNo;
		this.aadharNo = aadharNo;
		this.address = address;
		this.mobileNo = mobileNo;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", password=" + password + ", pancardNo=" + pancardNo + ", aadharNo=" + aadharNo
				+ ", address=" + address + ", mobileNo=" + mobileNo + ", balance=" + balance + "]";
	}

}
